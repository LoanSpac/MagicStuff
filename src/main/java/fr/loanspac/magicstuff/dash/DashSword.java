package fr.loanspac.magicstuff.dash;

import fr.loanspac.magicstuff.dash.skill.DashSkill;
import fr.loanspac.magicstuff.sword.MagicSword;
import fr.loanspac.magicstuff.utils.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class DashSword extends MagicSword {

    public DashSword() {
        super("Dash Sword", new ItemBuilder(Material.IRON_SWORD).name(Component.text("§aDash Sword")).lore(Component.text("§cSword description lore")).build(), new DashSkill());
    }
}
