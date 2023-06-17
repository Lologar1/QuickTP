package me.analyzers.anautils.utils;

import me.analyzers.anautils.AnaUtils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class ItemBuilder {
    private int amount;
    private ArrayList<String> lore = new ArrayList<>();
    private ItemMeta meta;
    private Material material;
    public ItemBuilder(Material material){
        this.material = material;
        meta = new ItemStack(material).getItemMeta();
    }
    public ItemBuilder setAmount(int amount){
        this.amount = amount;
        return this;
    }
    public ItemBuilder addLore(String line){
        lore.add(line);
        return this;
    }
    public ItemBuilder addEnchant(Enchantment enchantment, int level, boolean bypass){
        meta.addEnchant(enchantment, level, bypass);
        return this;
    }
    public ItemBuilder setDisplayName(String name){
        meta.setDisplayName(name);
        return this;
    }
    public ItemBuilder setAttribute(Attribute attribute, AttributeModifier modifier){
        meta.addAttributeModifier(attribute, modifier);
        return this;
    }
    public ItemBuilder setFlag(ItemFlag flag){
        meta.addItemFlags(flag);
        return this;
    }
    public ItemBuilder removeAttribute(Attribute attribute){
        meta.removeAttributeModifier(attribute);
        return this;
    }
    public ItemBuilder removeAttribute(ItemFlag flag){
        meta.removeItemFlags(flag);
        return this;
    }
    public ItemBuilder removeEnchant(Enchantment enchantment){
        meta.removeEnchant(enchantment);
        return this;
    }
    public ItemBuilder setPDC(String key, String data){
        PersistentDataContainer itemPDC = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(AnaUtils.getPlugin(), key);
        itemPDC.set(namespacedKey, PersistentDataType.STRING, data);
        return this;
    }
    public ItemBuilder setPDC(String key, int data){
        PersistentDataContainer itemPDC = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(AnaUtils.getPlugin(), key);
        itemPDC.set(namespacedKey, PersistentDataType.INTEGER, data);
        return this;
    }
    public ItemBuilder setPDC(String key, long data){
        PersistentDataContainer itemPDC = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(AnaUtils.getPlugin(), key);
        itemPDC.set(namespacedKey, PersistentDataType.LONG, data);
        return this;
    }
    public ItemBuilder setPDC(String key, float data){
        PersistentDataContainer itemPDC = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(AnaUtils.getPlugin(), key);
        itemPDC.set(namespacedKey, PersistentDataType.FLOAT, data);
        return this;
    }
    public ItemStack build(){
        ItemStack item = new ItemStack(material);
        meta.setLore(lore);
        item.setItemMeta(meta);
        item.setAmount(amount);
        return item;
    }

}
