package fr.loanspac.magicstuff.example.armor;

import fr.loanspac.magicstuff.example.skill.SpeedSkill;
import fr.loanspac.magicstuff.item.MagicItem;
import fr.loanspac.magicstuff.type.MagicType;
import fr.loanspac.magicstuff.utils.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class SpeedBoots extends MagicItem {
    public SpeedBoots(MagicType magicType) {
        super("speed_boots", magicType, new ItemBuilder(Material.IRON_BOOTS)
                .addData(magicType.getNamespacedKey(), "speed-boots")
                .applyCustomModelData(magicType.getNamespacedKey())
                .name(Component.text("§bSpeed Boots"))
                .lore(Component.text("§5[Shift] + [Left Click] to activate speed 3"))
                .build(), new SpeedSkill());
    }
}
