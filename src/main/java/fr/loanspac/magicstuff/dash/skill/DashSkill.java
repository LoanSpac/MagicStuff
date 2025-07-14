package fr.loanspac.magicstuff.dash.skill;

import fr.loanspac.magicstuff.sword.skill.Skill;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class DashSkill extends Skill {

    public DashSkill() {
        super("dash_skill");
    }

    @Override
    public void executor(Player player) {
        Vector direction = player.getEyeLocation().getDirection();
        direction.multiply(15);
        direction.normalize();
        player.setVelocity(direction);
    }
}
