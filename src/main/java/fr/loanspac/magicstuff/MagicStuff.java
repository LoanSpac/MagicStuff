package fr.loanspac.magicstuff;

import fr.loanspac.magicstuff.commands.MagicCommand;
import fr.loanspac.magicstuff.example.sword.DashSword;
import fr.loanspac.magicstuff.listeners.PlayerListener;
import fr.loanspac.magicstuff.sword.MagicSword;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public final class MagicStuff extends JavaPlugin {
    private final List<MagicSword> magicSwords = new ArrayList<>();
    private final NamespacedKey swordKey = new NamespacedKey(this, "magic-sword");

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerListener(this), this);
        Objects.requireNonNull(getCommand("magic")).setExecutor(new MagicCommand(this));

        // Load Stuff
        registerMagicSword(new DashSword(this.swordKey));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerMagicSword(MagicSword sword) {
        magicSwords.add(sword);
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
