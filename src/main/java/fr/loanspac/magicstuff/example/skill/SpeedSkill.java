package fr.loanspac.magicstuff.example.skill;

import fr.loanspac.magicstuff.skill.ActionType;
import fr.loanspac.magicstuff.skill.Skill;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.time.Duration;
import java.util.Arrays;

public class SpeedSkill extends Skill {

    public SpeedSkill() {
        super("speed_skill", Arrays.asList(ActionType.SHIFT, ActionType.LEFT_CLICK));
    }

    @Override
    public void executor(Player player) {
        if (this.getCooldown().hasCooldown(player.getUniqueId())) {
            player.sendMessage(Component.text("§cYour speed is in cooldown !"));
            player.sendMessage(Component.text("§cPlease wait " + this.getCooldown().getRemainingCooldown(player.getUniqueId()).getSeconds() + " seconds"));
            return;
        }
        this.getCooldown().setCooldown(player.getUniqueId(), Duration.ofSeconds(15));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5*20, 3));
    }
}
