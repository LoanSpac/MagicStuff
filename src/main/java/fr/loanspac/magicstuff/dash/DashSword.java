package fr.loanspac.magicstuff.dash;

import fr.loanspac.magicstuff.dash.skill.DashSkill;
import fr.loanspac.magicstuff.sword.MagicSword;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class DashSword extends MagicSword implements Listener {

    public DashSword() {
        super("§aDash Sword", "§cSword description lore", Material.IRON_SWORD, new DashSkill());
    }

    @EventHandler
    public void onAction(PlayerInteractEvent event) {
        if (event.getAction().isRightClick() && Objects.equals(event.getItem(), this.buildItem())) {
            this.skill.executor(event.getPlayer());
        }
    }
}
