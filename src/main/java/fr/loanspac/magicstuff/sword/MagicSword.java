package fr.loanspac.magicstuff.sword;

import fr.loanspac.magicstuff.skill.Skill;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

@Getter
public abstract class MagicSword {
    private final String name;
    private final ItemStack item;
    public final Skill skill;

    protected MagicSword(String name, ItemStack item, Skill skill) {
        this.name = name;
        this.item = item;
        this.skill = skill;
    }
}
