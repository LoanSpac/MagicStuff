package fr.loanspac.magicstuff;

import fr.loanspac.magicstuff.dash.DashSword;
import fr.loanspac.magicstuff.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MagicStuff extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        Bukkit.getPluginManager().registerEvents(new DashSword(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
