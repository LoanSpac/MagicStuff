package fr.loanspac.magicstuff.type.armor;

import fr.loanspac.magicstuff.MagicStuff;
import fr.loanspac.magicstuff.type.MagicType;
import fr.loanspac.magicstuff.utils.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class MagicArmor extends MagicType {

    public MagicArmor(MagicStuff plugin) {
        super("Magic Armor", new NamespacedKey(plugin, "magic-armor"), new ItemBuilder(Material.IRON_CHESTPLATE).name(Component.text("§cThis item has a incorrect type")).build());
    }

    @Override
    public boolean applyRule(ItemStack item) {
        return (Arrays.asList(Material.NETHERITE_HELMET, Material.NETHERITE_CHESTPLATE, Material.NETHERITE_LEGGINGS, Material.NETHERITE_BOOTS,
                        Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS,
                        Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS,
                        Material.GOLDEN_HELMET, Material.GOLDEN_CHESTPLATE, Material.GOLDEN_LEGGINGS, Material.GOLDEN_BOOTS,
                        Material.CHAINMAIL_HELMET, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS,
                        Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, Material.TURTLE_HELMET)
                .contains(item.getType()));
    }
}
