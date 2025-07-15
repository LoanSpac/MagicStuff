package fr.loanspac.magicstuff.type;

import fr.loanspac.magicstuff.item.MagicItem;
import lombok.Getter;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class MagicType {
    private final String name;
    private final NamespacedKey namespacedKey;
    private final ItemStack defaultItem;
    private final List<MagicItem> itemList = new ArrayList<>();
    public abstract boolean applyRule(ItemStack item);

    protected MagicType(String name, NamespacedKey namespacedKey, ItemStack defaultItem) {
        this.name = name;
        this.namespacedKey = namespacedKey;
        this.defaultItem = defaultItem;
    }
}
