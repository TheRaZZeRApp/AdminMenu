package com.therazzerapp.adminmenu.config;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import de.myelitecraft.elitelib.api.EliteLib;
import de.myelitecraft.elitelib.api.config.ConfigSection;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
    public static void saveJsonFile(File file, JsonObject jsonObject) {
        try {
            try (JsonWriter jsonWriter = new JsonWriter(new FileWriter(file))) {
                jsonWriter.setIndent("    ");
                new Gson().toJson(jsonObject, jsonWriter);
                jsonWriter.flush();
            }
        } catch (IOException e) {
        }
    }

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


        JsonObject root = new JsonObject();

        root.addProperty("muteChatInMenu",true);
        root.addProperty("playermenu",true);
        root.addProperty("servermenu",true);
        root.addProperty("worldmenu",true);
        root.addProperty("groupmenu",true);
        root.addProperty("playerInfos",true);
        root.addProperty("worldInfos",true);
        root.addProperty("pluginInfos",true);
        root.addProperty("banInfos",true);
        root.addProperty("groupInfos",true);
        saveJsonFile(file,root);
    }

    public static void createBlockList(File file){
        de.myelitecraft.elitelib.api.config.Config config = EliteLib.getConfigManager().getConfig("JSON");
        ConfigSection root = config.load(file);
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

        root.setStringArray("blocks",blocks);
        config.save(root,file);
    }

    public static void createAmountList00(File file){
        de.myelitecraft.elitelib.api.config.Config config = EliteLib.getConfigManager().getConfig("JSON");
        ConfigSection root = config.load(file);
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
        root.setIntArray("amounts", amounts);
        config.save(root,file);
    }

    public static void createAmountList01(File file){
        de.myelitecraft.elitelib.api.config.Config config = EliteLib.getConfigManager().getConfig("JSON");
        ConfigSection root = config.load(file);
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
        root.setStringArray("amounts", amounts);
        config.save(root, file);
    }

    public static void createAmountList02(File file){
        de.myelitecraft.elitelib.api.config.Config config = EliteLib.getConfigManager().getConfig("JSON");
        ConfigSection root = config.load(file);
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
        root.setIntArray("amounts", amounts);
        config.save(root,file);
    }

    public static void createReasonList(File file){
        de.myelitecraft.elitelib.api.config.Config config = EliteLib.getConfigManager().getConfig("JSON");
        ConfigSection root = config.load(file);
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
        root.setStringArray("reasons", reasons);
        config.save(root,file);
    }


}
