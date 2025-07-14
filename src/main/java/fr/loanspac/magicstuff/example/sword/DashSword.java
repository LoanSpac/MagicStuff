package fr.loanspac.magicstuff.example.sword;

import fr.loanspac.magicstuff.example.skill.DashSkill;
import fr.loanspac.magicstuff.sword.MagicSword;
import fr.loanspac.magicstuff.utils.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public class DashSword extends MagicSword {

    public DashSword(NamespacedKey key) {
        super("dash_sword", new ItemBuilder(Material.IRON_SWORD)
                .addData(key, "dash-sword")
                .name(Component.text("§aDash Sword"))
                .lore(Component.text("§cSword description lore"))
                .build(), new DashSkill());
    }
}
