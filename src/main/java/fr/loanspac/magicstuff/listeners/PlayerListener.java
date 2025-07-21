package fr.loanspac.magicstuff.listeners;

import fr.loanspac.magicstuff.MagicStuff;
import fr.loanspac.magicstuff.item.MagicItem;
import fr.loanspac.magicstuff.skill.ActionType;
import fr.loanspac.magicstuff.type.MagicType;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class PlayerListener implements Listener {
    private final MagicStuff plugin;

    @EventHandler
    public void onAction(PlayerInteractEvent event) {
        List<ItemStack> items = Arrays.asList(event.getItem(),
                event.getPlayer().getInventory().getHelmet(),
                event.getPlayer().getInventory().getChestplate(),
                event.getPlayer().getInventory().getLeggings(),
                event.getPlayer().getInventory().getBoots());

        for (ItemStack item: items) {
            if (item == null) continue;
            for (MagicType magicType: this.plugin.getMagicTypes()) {
                PersistentDataContainer container = item.getItemMeta().getPersistentDataContainer();

                if (container.has(magicType.getNamespacedKey(), PersistentDataType.STRING)) {
                    String namespacedValue = container.get(magicType.getNamespacedKey(), PersistentDataType.STRING);
                    if (namespacedValue == null) continue;
                    for (MagicItem magicItem: magicType.getItemList()) {
                        if (magicItem.getSkill() == null) continue;
                        if (namespacedValue.equals(magicItem.getName()) && this.checkActionTypes(event, magicItem.getSkill().getActionTypes())) {
                            magicItem.getSkill().executor(event.getPlayer());
                        }
                    }
                }
            }
        }
    }

    private boolean checkActionTypes(PlayerInteractEvent event, List<ActionType> actionTypes) {
        for (ActionType actionType : actionTypes) {
            switch (actionType) {
                case RIGHT_CLICK:
                    if (!event.getAction().isRightClick()) return false;
                    break;
                case LEFT_CLICK:
                    if (!event.getAction().isLeftClick()) return false;
                    break;
                case SHIFT:
                    if (!event.getPlayer().isSneaking()) return false;
                    break;
                case JUMP:
                    if (!event.getPlayer().isJumping()) return false;
                    break;
                default:
                    break;
            }
        }
        return true;
    }
}
