package fr.loanspac.magicstuff.commands;

import fr.loanspac.magicstuff.MagicStuff;
import fr.loanspac.magicstuff.sword.MagicSword;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public class MagicCommand implements CommandExecutor {
    private final MagicStuff plugin;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String @NotNull [] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cThis command cannot be execute in console.");
            return false;
        }
        Player player = (Player) sender;
        if (args.length < 2) return false;
        if (!(args[0].equals("give"))) return false;
        for (MagicSword magicSword: this.plugin.getMagicSwords()) {
            if (magicSword.getName().equals(args[1])) {
                player.getInventory().addItem(magicSword.getItem());
                String itemName = magicSword.getItem().getItemMeta().getItemName();
                if (itemName.isEmpty()) {
                    itemName = magicSword.getItem().getType().name();
                }
                sender.sendMessage("§aYou obtain the Magic Sword §7[" + itemName + "§7]");
                return true;
            }
        }
        return false;
    }
}
