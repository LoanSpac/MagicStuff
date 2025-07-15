package fr.loanspac.magicstuff.commands;

import fr.loanspac.magicstuff.MagicStuff;
import fr.loanspac.magicstuff.item.MagicItem;
import fr.loanspac.magicstuff.type.MagicType;
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

        for (MagicType magicType: this.plugin.getMagicTypes()) {
            for (MagicItem magicItem: magicType.getItemList()) {
                if (magicItem.getName().equals(args[1])) {
                    player.getInventory().addItem(magicItem.getItem());
                    String itemName = magicItem.getItem().getItemMeta().getItemName();
                    if (itemName.isEmpty()) {
                        itemName = magicItem.getItem().getType().name();
                    }
                    sender.sendMessage("§aYou obtain the " + magicType.getName() + " §7[" + itemName + "§7]");
                    return true;
                }
            }
        }
        return false;
    }
}
