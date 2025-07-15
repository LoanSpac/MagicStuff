package fr.loanspac.magicstuff.example.sword;

import fr.loanspac.magicstuff.example.skill.DashSkill;
import fr.loanspac.magicstuff.item.MagicItem;
import fr.loanspac.magicstuff.type.MagicType;
import fr.loanspac.magicstuff.utils.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class DashSword extends MagicItem {
    public DashSword(MagicType magicType) {
        super("dash_sword", magicType, new ItemBuilder(Material.IRON_SWORD)
                .addData(magicType.getNamespacedKey(), "dash-sword")
                .applyCustomModelData(magicType.getNamespacedKey())
                .name(Component.text("§aDash Sword"))
                .lore(Component.text("§c[Right Click] to dash"))
                .build(), new DashSkill());
    }
}
