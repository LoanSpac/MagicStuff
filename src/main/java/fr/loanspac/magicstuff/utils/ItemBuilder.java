package fr.loanspac.magicstuff.utils;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ItemBuilder {
    private final ItemStack item;

    public ItemBuilder(Material material) {
        this.item = new ItemStack(material);
    }

    public ItemBuilder(ItemStack item) {
        this.item = item;
    }

    public ItemBuilder(String textures) {
        this.item = new ItemStack(Material.PLAYER_HEAD);
        this.item.editMeta(SkullMeta.class, skullMeta -> {
            final UUID uuid = UUID.randomUUID();
            final PlayerProfile playerProfile = Bukkit.createProfile(uuid, uuid.toString().substring(0, 16));
            playerProfile.setProperty(new ProfileProperty("textures", textures));
            skullMeta.setPlayerProfile(playerProfile);
        });
    }

    public ItemBuilder amount(int amount) {
        this.item.setAmount(amount);
        return this;
    }

    @SuppressWarnings("deprecation")
    public ItemBuilder durability(short durability) {
        this.item.setDurability(durability);
        return this;
    }

    public ItemBuilder name(Component name) {
        this.item.editMeta(itemMeta -> itemMeta.itemName(name));
        return this;
    }

    public ItemBuilder lore(Component line) {
        this.item.editMeta(itemMeta -> itemMeta.lore(Collections.singletonList(line)));
        return this;
    }

    public ItemBuilder lore(Component... lines) {
        this.item.editMeta(itemMeta -> itemMeta.lore(Arrays.asList(lines)));
        return this;
    }

    public ItemBuilder lore(List<Component> lines) {
        this.item.editMeta(itemMeta -> itemMeta.lore(lines));
        return this;
    }

    public ItemBuilder addFlags(ItemFlag... flags) {
        this.item.editMeta(itemMeta -> itemMeta.addItemFlags(flags));
        return this;
    }

    public ItemBuilder removeFlags(ItemFlag... flags) {
        this.item.editMeta(itemMeta -> itemMeta.removeItemFlags(flags));
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchantment, int level, boolean ignoreLevelRestriction) {
        this.item.editMeta(itemMeta -> itemMeta.addEnchant(enchantment, level, ignoreLevelRestriction));
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchantment, int level) {
        this.item.editMeta(itemMeta -> itemMeta.addEnchant(enchantment, level, false));
        return this;
    }

    public ItemBuilder removeEnchant(Enchantment enchantment) {
        this.item.editMeta(itemMeta -> itemMeta.removeEnchant(enchantment));
        return this;
    }

    public ItemBuilder removeEnchants() {
        this.item.editMeta(ItemMeta::removeEnchantments);
        return this;
    }

    public ItemBuilder armorColor(Color color) {
        this.item.editMeta(LeatherArmorMeta.class, armorMeta -> armorMeta.setColor(color));
        return this;
    }

    public ItemStack build() {
        return this.item;
    }
}
