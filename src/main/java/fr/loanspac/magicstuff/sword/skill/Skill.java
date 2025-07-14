package fr.loanspac.magicstuff.sword.skill;

import fr.loanspac.magicstuff.utils.CooldownManager;
import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
public abstract class Skill {
    private final String name;
    private final CooldownManager cooldown = new CooldownManager();
    public abstract void executor(Player player);

    protected Skill(String name) {
        this.name = name;
    }
}
