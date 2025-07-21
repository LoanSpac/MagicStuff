package fr.loanspac.magicstuff;

import fr.loanspac.magicstuff.commands.MagicCommand;
import fr.loanspac.magicstuff.example.armor.SpeedBoots;
import fr.loanspac.magicstuff.example.armor.WrongArmor;
import fr.loanspac.magicstuff.example.sword.DashSword;
import fr.loanspac.magicstuff.example.sword.WrongSword;
import fr.loanspac.magicstuff.listeners.PlayerListener;
import fr.loanspac.magicstuff.type.MagicType;
import fr.loanspac.magicstuff.type.armor.MagicArmor;
import fr.loanspac.magicstuff.type.items.MagicGlobal;
import fr.loanspac.magicstuff.type.sword.MagicSword;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public final class MagicStuff extends JavaPlugin {
    private final List<MagicType> magicTypes = new ArrayList<>();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new PlayerListener(this), this);
        Objects.requireNonNull(getCommand("magic")).setExecutor(new MagicCommand(this));

        // Load Stuff
        registerMagicType(new MagicGlobal(this));
        registerMagicType(new MagicSword(this));
        registerMagicType(new MagicArmor(this));

        boolean example = this.getConfig().getBoolean("example-stuff");
        if (example) {
            new DashSword(this.findInstance(this.magicTypes, MagicSword.class));
            new WrongSword(this.findInstance(this.magicTypes, MagicSword.class));
            new SpeedBoots(this.findInstance(this.magicTypes, MagicArmor.class));
            new WrongArmor(this.findInstance(this.magicTypes, MagicArmor.class));
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerMagicType(MagicType magicType) {
        this.magicTypes.add(magicType);
    }

    // Utils for find MagicSword
    public <T> T findInstance(List<?> list, Class<T> clazz) {
        for (Object element : list) {
            if (clazz.isInstance(element)) {
                return clazz.cast(element);
            }
        }
        return null;
    }
}
