package fr.loanspac.magicstuff.sword;

import fr.loanspac.magicstuff.sword.skill.SpeedSkill;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class SpeedSword extends MagicSword implements Listener {

    public SpeedSword() {
        super("§aSpeed Sword", "§cSpeed description lore", Material.IRON_SWORD, new SpeedSkill());
    }

    @EventHandler
    public void onAction(PlayerInteractEvent event) {
        if (event.getAction().isRightClick() && Objects.equals(event.getItem(), this.buildItem())) {
            this.skill.executor(event.getPlayer());
        }
    }
}
