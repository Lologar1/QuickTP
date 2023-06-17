package me.analyzers.anautils.customEnchantments;

import me.analyzers.anautils.utils.PDCUtils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CustomEnchantment {
    private String name;
    private String id;
    private ChatColor color;
    private int maxLevel;
    private boolean combineable;
    private String[] applicable; //lowecase, materials & support for custom items
    private Enchantment[] vanillaConflicts;
    private CustomEnchantment[] conflicts;

    private static HashMap<String, CustomEnchantment> enchantments = new HashMap<>();

    public static CustomEnchantment getById(String id){
        return enchantments.getOrDefault(id, null);
    }

    public static boolean hasCustomEnchantment(CustomEnchantment enchantment, ItemStack item){
        return Arrays.stream(PDCUtils.get(item, "enchantments").split(" ")).collect(Collectors.toList()).contains(enchantment.getId());
    }
    public static boolean hasCustomEnchantment(String enchantment, ItemStack item){
        return Arrays.stream(PDCUtils.get(item, "enchantments").split(" ")).collect(Collectors.toList()).contains(enchantment);
    }

    public static void addCustomEnchantment(CustomEnchantment enchantment, ItemStack item){
        PDCUtils.set(item, "enchantments", PDCUtils.get(item, "enchantments") + enchantment.getId() + " ");
    }
    public static void addCustomEnchantment(String enchantment, ItemStack item){
        PDCUtils.set(item, "enchantments", PDCUtils.get(item, "enchantments") + enchantment + " ");
    }
    public static List<String> getCustomEnchantments(ItemStack itemStack){
        return Arrays.stream(PDCUtils.get(itemStack, "enchantments").split(" ")).collect(Collectors.toList());
    }
    public CustomEnchantment(net.md_5.bungee.api.ChatColor color, Enchantment[] vanillaConflicts, String name, String id, int maxLevel, CustomEnchantment[] conflicts, String[] applicable, boolean combineable){
        this.name = name;
        this.id = id;
        this.maxLevel = maxLevel;
        this.conflicts = conflicts;
        this.applicable = applicable;
        this.vanillaConflicts = vanillaConflicts;
        this.combineable = combineable;
        this.color = color;

        enchantments.put(id, this);
    }

    public ChatColor getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public boolean isCombineable() {
        return combineable;
    }

    public String getId(){
        return id;
    }

    public String[] getApplicable() {
        return applicable;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public CustomEnchantment[] getConflicts() {
        return conflicts;
    }
    public Enchantment[] getVanillaConflicts(){
        return vanillaConflicts;
    }
    @Override
    public String toString(){
        return id;
    }

}
