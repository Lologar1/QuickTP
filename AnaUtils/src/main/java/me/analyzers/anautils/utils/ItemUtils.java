package me.analyzers.anautils.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ItemUtils {
    public static String convertItemStackToString(ItemStack what){
        // serialize the object
        String serializedObject = "";
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream so = new ObjectOutputStream(bo);
            so.writeObject(what);
            so.flush();
            serializedObject = bo.toString();
            return serializedObject;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public static ItemStack convertStringToItemStack(String data){
        // deserialize the object
        try {
            byte b[] = data.getBytes();
            ByteArrayInputStream bi = new ByteArrayInputStream(b);
            ObjectInputStream si = new ObjectInputStream(bi);
            ItemStack obj = (ItemStack) si.readObject();
            return obj;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public static String convertItemStackArrayToString(ItemStack what[]){
        // serialize the object
        String serializedObject = "";
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream so = new ObjectOutputStream(bo);
            so.writeObject(what);
            so.flush();
            serializedObject = bo.toString();
            return serializedObject;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public static ItemStack[] convertStringToItemStackArray(String data){
        // deserialize the object
        try {
            byte b[] = data.getBytes();
            ByteArrayInputStream bi = new ByteArrayInputStream(b);
            ObjectInputStream si = new ObjectInputStream(bi);
            ItemStack[] obj = (ItemStack[]) si.readObject();
            return obj;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
