package fr.loanspac.magicstuff.listeners;

import fr.loanspac.magicstuff.MagicStuff;
import fr.loanspac.magicstuff.item.MagicItem;
import fr.loanspac.magicstuff.type.MagicType;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

@RequiredArgsConstructor
public class PlayerListener implements Listener {
    private final MagicStuff plugin;

    @EventHandler
    public void onAction(PlayerInteractEvent event) {
        if (event.getItem() == null) return;
        PersistentDataContainer container = event.getItem().getItemMeta().getPersistentDataContainer();

        for (MagicType magicType: this.plugin.getMagicTypes()) {
            if (container.has(magicType.getNamespacedKey(), PersistentDataType.STRING)) {
                for (MagicItem magicItem: magicType.getItemList()) {
                    if (event.getAction().isRightClick() && Objects.equals(event.getItem(), magicItem.getItem())) {
                        magicItem.skill.executor(event.getPlayer());
                    }
                }
            }
        }
    }
}
