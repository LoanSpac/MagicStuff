package fr.loanspac.magicstuff;

import fr.loanspac.magicstuff.listeners.PlayerListener;
import fr.loanspac.magicstuff.sword.SpeedSword;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MagicStuff extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        Bukkit.getPluginManager().registerEvents(new SpeedSword(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
