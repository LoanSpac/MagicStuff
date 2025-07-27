package fr.loanspac.magicstuff.example.sword;

import fr.loanspac.magicstuff.item.MagicItem;
import fr.loanspac.magicstuff.type.MagicType;
import fr.loanspac.magicstuff.utils.ItemBuilder;
import org.bukkit.Material;

public class WrongSword extends MagicItem {
    public WrongSword(MagicType magicType) {
        super("wrong-sword", magicType, new ItemBuilder(Material.OAK_WOOD)
                .addData(magicType.getNamespacedKey(), "wrong-sword")
                .build(), null);
    }
}
