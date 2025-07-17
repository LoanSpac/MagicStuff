package fr.loanspac.magicstuff.example.armor;

import fr.loanspac.magicstuff.item.MagicItem;
import fr.loanspac.magicstuff.type.MagicType;
import fr.loanspac.magicstuff.utils.ItemBuilder;
import org.bukkit.Material;

public class WrongArmor extends MagicItem {
    public WrongArmor(MagicType magicType) {
        super("wrong-armor", magicType, new ItemBuilder(Material.OAK_WOOD)
                .addData(magicType.getNamespacedKey(), "wrong-armor")
                .build(), null);
    }
}
