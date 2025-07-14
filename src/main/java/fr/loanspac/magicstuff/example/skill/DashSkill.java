package fr.loanspac.magicstuff.example.skill;

import fr.loanspac.magicstuff.skill.Skill;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.time.Duration;

public class DashSkill extends Skill {

    public DashSkill() {
        super("dash_skill");
    }

    @Override
    public void executor(Player player) {
        if (this.getCooldown().hasCooldown(player.getUniqueId())) {
            player.sendMessage(Component.text("§cYour dash is in cooldown !"));
            player.sendMessage(Component.text("§cPlease wait " + this.getCooldown().getRemainingCooldown(player.getUniqueId()).getSeconds() + " seconds"));
            return;
        }
        this.getCooldown().setCooldown(player.getUniqueId(), Duration.ofSeconds(5));
        Vector direction = player.getEyeLocation().getDirection();
        direction.multiply(15);
        direction.normalize();
        player.setVelocity(direction);
    }
}
