package fr.loanspac.magicstuff.item;

import fr.loanspac.magicstuff.skill.Skill;
import fr.loanspac.magicstuff.type.MagicType;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

@Getter
public abstract class MagicItem {
    private final String name;
    private final MagicType type;
    private final ItemStack item;
    public final Skill skill;

    protected MagicItem(String name, MagicType type, ItemStack item, Skill skill) {
        if (type != null && !(type.applyRule(item))) {
            item = type.getDefaultItem();
        }
        this.name = name;
        this.type = type;
        this.item = item;
        this.skill = skill;
        if (type != null) type.getItemList().add(this);
    }
}
