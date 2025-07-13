package fr.loanspac.magicstuff.sword;

import fr.loanspac.magicstuff.sword.skill.Skill;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class MagicSword {
    private final String name;
    private final String description;
    private final Material material;
    public final Skill skill;

    public MagicSword(String name, String description, Material material, Skill skill) {
        this.name = name;
        this.description = description;
        this.material = material;
        this.skill = skill;
    }

    public ItemStack buildItem() {
        ItemStack item = new ItemStack(this.material);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.itemName(Component.text(this.name));
        List<Component> lores = new ArrayList<>();
        lores.add(Component.text(this.description));
        itemMeta.lore(lores);
        item.setItemMeta(itemMeta);
        return item;
    }
}
