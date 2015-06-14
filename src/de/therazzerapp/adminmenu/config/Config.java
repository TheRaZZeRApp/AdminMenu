package de.therazzerapp.adminmenu.config;

import de.myelitecraft.elitelib.api.EliteLib;
import de.myelitecraft.elitelib.api.config.ConfigSection;
import de.myelitecraft.elitelib.config.YAMLComment;
import de.myelitecraft.elitelib.config.YAMLConfigSection;
import net.canarymod.logger.Logman;

import java.io.File;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 02/05/2015
 * Time: 21:20 PM
 * Package: com.therazzerapp.adminmenu.config
 * E-Mail: rezzer101@googlemail.com
 */

public class Config {

    public static void createConfig(File file){
        de.myelitecraft.elitelib.api.config.Config config = EliteLib.getConfigManager().getConfig("YAML");
        YAMLConfigSection root = (YAMLConfigSection) config.load(file);
        root.addComments(new YAMLComment(new String[]{"This is the main AdminMenu config file.","==========================","Mute Chat While In Admin Menu","If this is true, you wont receive any messages from other players while in the admin menu.","If you exit the menu all messages will be restored.","Default: true"}));
        root.setBoolean("mute_chat_in_menu", true);
        root.addComments(new YAMLComment(new String[]{"=============","Enable Player Commands Menu","If this is true, the player commands menu will be enabled","Default: true"}));
        root.setBoolean("playermenu", true);
        root.addComments(new YAMLComment(new String[]{"=============","Enable Server Commands Menu","If this is true, the server commands menu will be enabled","Default: true"}));
        root.setBoolean("servermenu", true);
        root.addComments(new YAMLComment(new String[]{"=============","Enable World Commands Menu","If this is true, the world commands menu will be enabled","Default: true"}));
        root.setBoolean("worldmenu", true);
        root.addComments(new YAMLComment(new String[]{"=============","Enable Group Commands Menu","If this is true, the group commands menu will be enabled","Default: true"}));
        root.setBoolean("groupmenu", true);
        root.addComments(new YAMLComment(new String[]{"=============","Show Player Infos In Auto List","If this is true you will see player infos like ip and local as a hover text in the player selection menu.","Default: true"}));
        root.setBoolean("player_infos", true);
        root.addComments(new YAMLComment(new String[]{"=============","Show World Infos In Auto List","If this is true you will see world infos like player amount and type as a hover text in the world selection menu.","Default: true"}));
        root.setBoolean("world_infos", true);
        root.addComments(new YAMLComment(new String[]{"=============","Show Plugin Infos In Auto List","If this is true you will see plugin infos like version and author as a hover text in the plugin selection menu.","Default: true"}));
        root.setBoolean("plugin_infos", true);
        root.addComments(new YAMLComment(new String[]{"=============","Show Ban Infos In Auto List","If this is true you will see ban infos like banner and duration as a hover text in the player unban selection menu.","Default: true"}));
        root.setBoolean("ban_infos", true);
        root.addComments(new YAMLComment(new String[]{"=============","Show Group Infos In Auto List","If this is true you will see group infos like parent and permissions as a hover text in the group selection menu.","Default: true"}));
        root.setBoolean("group_infos", true);
        root.addComments(new YAMLComment(new String[]{"=============","Show Empty Item In Auto List","If this is true you will see the empty item in an auto list if there is no menu entry.","Default: true"}));
        root.setBoolean("atl_empty_item", true);
        root.addComments(new YAMLComment(new String[]{"=============","Multi Language Reason","If this is true the ban and kick reasons will be translated if possible.","Default: true"}));
        root.setBoolean("multi_language_reasons", true);
        root.addComments(new YAMLComment(new String[]{"=============","Disable Hover Infos","If this is true you won't see any hover informations.","Default: false"}));
        root.setBoolean("disable_hover_infos", false);
        root.addComments(new YAMLComment(new String[]{"=============","Disable Extended Hover Infos","If this is true you only see the first line from a hover information.","Default: false"}));
        root.setBoolean("extended_hover_infos", true);
        config.save(root, file);
    }

    public static void createTimeList00(File file, Logman logman){
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
        createConfigSectionList(file,"time_00",time,logman);
    }

    public static void createTimeList01(File file, Logman logman){
        String[] time = {
                "Clear"
                ,"0"
                ,"1 Day"
                ,"86400"
                ,"5 Hours"
                ,"18000"
                ,"2 Hours"
                ,"7200"
                ,"1 Hour"
                ,"3600"
                ,"30 Minutes"
                ,"1800"
                ,"15 Minutes"
                ,"900"
                ,"10 Minutes"
                ,"600"
                ,"5 Minutes"
                ,"300"
                ,"1 Minute"
                ,"60"
                ,"30 Sec"
                ,"30"
                ,"10 Sec"
                ,"10"
        };
        createConfigSectionList(file,"time_01",time, logman);
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
        createStorageList(file,"amounts_00",amounts);
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
        createStorageList(file,"amounts_01",amounts);
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
        createStorageList(file, "amounts_02", amounts);
    }

    public static void createReasonList(File file){
        String[] reasons = {
                "Griefing"
                ,"Spamming"
                ,"Bad Language"
                ,"Promotion"
                ,"Foolishness"
                ,"Broken Rules"
                ,"Bad Name/Skins"
                ,"Others"
                ,"Female"       //I know i know
        };
        createStorageList(file,"reasons",reasons);
        String[] reasons_de = {
                "Griefing"
                ,"Spamming"
                ,"Vulgärsprache"
                ,"Werbung"
                ,"Dummheit"
                ,"Regeln Gebrochen"
                ,"Schlechter Name/Skin"
                ,"Sonstiges"
                ,"Männlich"       //Für die Fairness
        };
        createStorageList(file,"reasons_de_DE",reasons_de);
    }

    public static void createConfigSectionList(File file, String item, String[] strings, Logman logman){
        de.myelitecraft.elitelib.api.config.Config config = EliteLib.getConfigManager().getConfig("JSON");
        ConfigSection root = config.load(file);

        try{
            for (int x = 0; x < strings.length; x += 2){
                ConfigSection section = root.addConfigSectionArrayEntry(item);
                section.setString("item", strings[x]);
                section.setString("value", strings[x+1]);
            }
        } catch (ArrayIndexOutOfBoundsException ex){
            logman.error("File: " + file.getName() + " needs one more value!");
        }
        config.save(root,file);
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
