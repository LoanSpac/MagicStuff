package fr.loanspac.magicstuff.dash;

import fr.loanspac.magicstuff.dash.skill.DashSkill;
import fr.loanspac.magicstuff.sword.MagicSword;
import fr.loanspac.magicstuff.utils.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class DashSword extends MagicSword implements Listener {

    public DashSword() {
        super("Dash Sword", new ItemBuilder(Material.IRON_SWORD).name(Component.text("§aDash Sword")).lore(Component.text("§cSword description lore")).build(), new DashSkill());
    }

    @EventHandler
    public void onAction(PlayerInteractEvent event) {
        if (event.getAction().isRightClick() && Objects.equals(event.getItem(), this.getItem())) {
            this.skill.executor(event.getPlayer());
        }
    }
}
