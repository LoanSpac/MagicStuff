package fr.loanspac.magicstuff.item;

import fr.loanspac.magicstuff.skill.Skill;
import fr.loanspac.magicstuff.type.MagicType;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

@Getter
public abstract class MagicItem {
    private final String name;
    private final MagicType magicType;
    private final ItemStack item;
    public final Skill skill;

    protected MagicItem(String name, MagicType magicType, ItemStack item, Skill skill) {
        if (magicType != null && !(magicType.applyRule(item))) {
            item = magicType.getDefaultItem();
        }
        this.name = name;
        this.magicType = magicType;
        this.item = item;
        this.skill = skill;
        if (magicType != null) magicType.getItemList().add(this);
    }
}
