package fr.loanspac.magicstuff.sword.skill;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class SpeedSkill extends Skill {

    public SpeedSkill() {
        super("Speed Skill");
    }

    @Override
    public void executor(Player player) {
        double multiplier = Math.min(10, 10 / 7.5 + (Math.exp(0.0072 * (70 - 950)) * (Math.pow(10, 0.59) * Math.pow(70, 1.3))) * 1 / (1 * 1.1));

        Vector direction = player.getEyeLocation().getDirection();

        direction.setY(((direction.getY() >= 0.45 || direction.getY() <= -0.5) ? direction.getY() : 0.20))
                .normalize()
                .setX(direction.getX() * multiplier)
                .setZ(direction.getZ() * multiplier)
                .setY(direction.getY() * (multiplier / 1.5));

        player.setVelocity(direction);
    }
}
