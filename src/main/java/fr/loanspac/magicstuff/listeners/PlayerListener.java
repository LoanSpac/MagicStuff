package fr.loanspac.magicstuff.listeners;

import fr.loanspac.magicstuff.MagicStuff;
import fr.loanspac.magicstuff.dash.DashSword;
import fr.loanspac.magicstuff.sword.MagicSword;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

@RequiredArgsConstructor
public class PlayerListener implements Listener {
    private final MagicStuff plugin;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        DashSword sword = this.plugin.findInstance(this.plugin.getMagicSwords(), DashSword.class);
        if (sword == null) return;
        event.getPlayer().getInventory().addItem(sword.getItem());
    }

    @EventHandler
    public void onAction(PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        PersistentDataContainer container = event.getItem().getItemMeta().getPersistentDataContainer();
        if (container.has(this.plugin.getSwordKey(), PersistentDataType.STRING)) {
            for (MagicSword magicSword: this.plugin.getMagicSwords()) {
                if (event.getAction().isRightClick() && Objects.equals(event.getItem(), magicSword.getItem())) {
                    magicSword.skill.executor(event.getPlayer());
                }
            }
        }
    }
}
