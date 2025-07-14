package fr.loanspac.magicstuff.listeners;

import fr.loanspac.magicstuff.dash.DashSword;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().getInventory().addItem(new DashSword().getItem());
    }
}
