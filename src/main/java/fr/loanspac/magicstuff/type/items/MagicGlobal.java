package fr.loanspac.magicstuff.type.items;

import fr.loanspac.magicstuff.MagicStuff;
import fr.loanspac.magicstuff.type.MagicType;
import fr.loanspac.magicstuff.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public class MagicGlobal extends MagicType {
    public MagicGlobal(MagicStuff plugin) {
        super("Magic Global", new NamespacedKey(plugin, "magic-global"), new ItemBuilder(Material.APPLE).build());
    }

    @Override
    public boolean applyRule(ItemStack item) {
        return true;
    }
}
