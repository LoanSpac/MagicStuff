package fr.loanspac.magicstuff.type.sword;

import fr.loanspac.magicstuff.MagicStuff;
import fr.loanspac.magicstuff.type.MagicType;
import fr.loanspac.magicstuff.utils.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class MagicSword extends MagicType {

    public MagicSword(MagicStuff plugin) {
        super("Magic Sword", new NamespacedKey(plugin, "magic-sword"), new ItemBuilder(Material.WOODEN_SWORD).name(Component.text("§cThis item has a incorrect type")).build());
    }

    @Override
    public boolean applyRule(ItemStack item) {
        return (Arrays.asList(Material.NETHERITE_SWORD, Material.DIAMOND_SWORD, Material.GOLDEN_SWORD, Material.IRON_SWORD, Material.STONE_SWORD, Material.WOODEN_SWORD)
                .contains(item.getType()));
    }
}
