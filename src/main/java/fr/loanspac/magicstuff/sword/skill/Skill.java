package fr.loanspac.magicstuff.sword.skill;

import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
public abstract class Skill {
    private final String name;
    public abstract void executor(Player player);

    public Skill(String name) {
        this.name = name;
    }
}
