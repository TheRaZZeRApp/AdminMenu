package com.therazzerapp.adminmenu.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import de.myelitecraft.elitelib.api.EliteLib;
import de.myelitecraft.elitelib.api.config.ConfigSection;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 02/05/2015
 * Time: 21:20 PM
 * Package: com.therazzerapp.adminmenu.config
 * E-Mail: rezzer101@googlemail.com
 */

public class Config {

    public static JsonObject readJsonFile(File file) {
        try {
            JsonElement parse;
            try (JsonReader jsonReader = new JsonReader(new FileReader(file))) {
                parse = new JsonParser().parse(jsonReader);
            }
            if (parse == null || parse.isJsonNull()) {
                parse = new JsonObject();
            }
            return parse.getAsJsonObject();
        } catch (IOException ex) {
            return new JsonObject();
        }
    }


    public static void createConfig(File file){
        de.myelitecraft.elitelib.api.config.Config config = EliteLib.getConfigManager().getConfig("JSON");
        ConfigSection root = config.load(file);
        root.setBoolean("muteChatInMenu", true);
        root.setBoolean("playermenu", true);
        root.setBoolean("servermenu", true);
        root.setBoolean("worldmenu", true);
        root.setBoolean("groupmenu", true);
        root.setBoolean("playerInfos", true);
        root.setBoolean("worldInfos", true);
        root.setBoolean("pluginInfos", true);
        root.setBoolean("banInfos", true);
        root.setBoolean("groupInfos", true);
        root.setBoolean("atlEmptyItem", true);
        config.save(root, file);
    }

    public static void createTimeList00(File file){
        String[] time = {
                "1 Year"
                ,"12 mo"
                ,"6 Months"
                ,"6 mo"
                ,"1 Moth"
                ,"1 mo"
                ,"2 Weeks"
                ,"2 w"
                ,"1 Week"
                ,"1 w"
                ,"3 Days"
                ,"3 d"
                ,"1 Day"
                ,"1 d"
                ,"12 Hours"
                ,"12 h"
                ,"1 Hour"
                ,"1 h"
                ,"30 Minutes"
                ,"30 min"
                ,"5 Minutes"
                ,"5 min"
                ,"1 Minute"
                ,"1 min"
        };
    }

    public static void createBlockList(File file){
        String[] blocks = {
                 "minecraft:stone"
                ,"minecraft:grass"
                ,"minecraft:dirt"
                ,"minecraft:cobblestone"
                ,"minecraft:planks"
                ,"minecraft:log"
                ,"minecraft:glass"
                ,"minecraft:wool"
                ,"minecraft:stone_slab"
        };
        createStorageList(file, "blocks", blocks);
    }

    public static void createItemList(File file){
        String[] items = {
                "minecraft:diamond_pickaxe"
                ,"minecraft:compass"
                ,"minecraft:sign"
                ,"minecraft:diamond_sword"
                ,"minecraft:flint_and_steel"
                ,"minecraft:torch"
                ,"minecraft:experience_bottle"
                ,"minecraft:piston"
                ,"minecraft:redstone"
        };
        createStorageList(file, "items", items);
    }

    public static void createAmountList00(File file){
        int[] amounts = {
                256
                ,128
                ,64
                ,32
                ,16
                ,8
                ,4
                ,2
                ,1
        };
        createStorageList(file,"amounts",amounts);
    }

    public static void createAmountList01(File file){
        String[] amounts = {
                "Complete"
                ,"128"
                ,"64"
                ,"32"
                ,"16"
                ,"8"
                ,"4"
                ,"2"
                ,"1"
        };
        createStorageList(file,"amounts",amounts);
    }

    public static void createAmountList02(File file){
        int[] amounts = {
                127
                ,64
                ,32
                ,16
                ,8
                ,4
                ,2
                ,1
        };
        createStorageList(file, "amounts", amounts);
    }

    public static void createReasonList(File file){
        String[] reasons = {
                "Griefing"
                ,"Spamming"
                ,"Bad Language"
                ,"Promotion"
                ,"Foolishness"
                ,"Breaking Rules"
                ,"Bad Name/Skins"
                ,"Others"
                ,"Female"
        };
        createStorageList(file,"reasons",reasons);
    }

    public static void createStorageList(File file, String item, String[] strings){
        de.myelitecraft.elitelib.api.config.Config config = EliteLib.getConfigManager().getConfig("JSON");
        ConfigSection root = config.load(file);
        root.setStringArray(item,strings);
        config.save(root,file);
    }

    public static void createStorageList(File file, String item, int[] amounts){
        de.myelitecraft.elitelib.api.config.Config config = EliteLib.getConfigManager().getConfig("JSON");
        ConfigSection root = config.load(file);
        root.setIntArray(item, amounts);
        config.save(root,file);
    }

}
