package fr.loanspac.magicstuff.skill;

import fr.loanspac.magicstuff.utils.CooldownManager;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.List;

@Getter
public abstract class Skill {
    private final String name;
    private final CooldownManager cooldown = new CooldownManager();
    private final List<ActionType> actionTypes;
    public abstract void executor(Player player);

    protected Skill(String name, List<ActionType> actionTypes) {
        this.name = name;
        this.actionTypes = actionTypes;
    }
}
