package fr.loanspac.magicstuff.listeners;

import fr.loanspac.magicstuff.sword.SpeedSword;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(Component.text("§3Voici votre épée !"));
        event.getPlayer().getInventory().addItem(new SpeedSword().buildItem());
    }
}
