package com.therazzerapp.adminmenu.config;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.json.simple.JSONObject;

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
        JsonObject root = new JsonObject();
        root.addProperty("- Stone","minecraft:stone");
        root.addProperty("- Grass","minecraft:grass");
        root.addProperty("- Dirt","minecraft:dirt");
        root.addProperty("- Cobblestone","minecraft:cobblestone");
        root.addProperty("- Oak Wood Plank","minecraft:planks");
        root.addProperty("- Oak Wood","minecraft:log");
        root.addProperty("- Glass","minecraft:glass");
        root.addProperty("- White Wool","minecraft:wool");
        root.addProperty("- Stone Slab","minecraft:stone_slab");
        saveJsonFile(file,root);
    }

    public static JsonObject getBlockList(){
        return readJsonFile(new File("./config/AdminMenu/ATL/blockList.json"));
    }
}
