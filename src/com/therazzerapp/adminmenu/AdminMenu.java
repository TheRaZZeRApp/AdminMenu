package com.therazzerapp.adminmenu;

import com.therazzerapp.adminmenu.commands.Admin;
import com.therazzerapp.adminmenu.commands.CommandBuilder;
import com.therazzerapp.adminmenu.commands.ExitMenu;
import com.therazzerapp.adminmenu.config.Config;
import com.therazzerapp.adminmenu.listener.BlankLineListener;
import de.myelitecraft.elitelib.api.EliteLib;
import de.myelitecraft.elitelib.api.config.ConfigSection;
import net.canarymod.plugin.Plugin;

import java.io.File;
import java.io.IOException;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 08/04/2015
 * Time: 15:30 PM
 * Package: com.therazzerapp.adminmenu
 * E-Mail: rezzer101@googlemail.com
 */

public class AdminMenu extends Plugin {

    private Translator translator;
    public static Settings settings;

    @Override
    public boolean enable() {

        File configDir = new File("./config/AdminMenu/");
        if(!configDir.exists()){
            configDir.mkdir();
        }

        File configFile = new File("./config/AdminMenu/config.json");
        if(!configFile.exists()){
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            getLogman().info("Config file created");
            Config.createConfig(configFile);
        }
        settings = new Settings(Config.readJsonFile(configFile));
        getLogman().info("Config loaded!");

        try{
            translator = new Translator(true, "./lang/AdminMenu", "en_US");
            getLogman().info("Language files loaded!");
        } catch (NullPointerException e){
            getLogman().error("No language files found, language is set to default (en_US)");
            translator = new Translator("en_US");
        }

        createATLConfigs();

        CreateMenus.initMenus(translator);
        EliteLib.getCommandManager().registerCommand(this, new Admin(this, translator));
        EliteLib.getCommandManager().registerCommand(this, new CommandBuilder(this,translator));
        EliteLib.getCommandManager().registerCommand(this, new ExitMenu(this,translator));

        registerListener(new BlankLineListener());

        return true;
    }

    @Override
    public void disable() {

    }

    private void createATLConfigs(){

        de.myelitecraft.elitelib.api.config.Config config = EliteLib.getConfigManager().getConfig("JSON");
        ConfigSection root;

        //ATL Configs
        File atlConfigDir = new File("./config/AdminMenu/ATL/");
        if(!atlConfigDir.exists()){
            atlConfigDir.mkdir();
        }

        //BlockList
        File atlBlockListConfig = new File("./config/AdminMenu/ATL/blockList.json");
        if(!atlBlockListConfig.exists()){
            try {
                atlBlockListConfig.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            getLogman().info("ATL block list created!");
            Config.createBlockList(atlBlockListConfig);
        }

        //ItemList
        File atlItemListConfig = new File("./config/AdminMenu/ATL/itemList.json");
        if(!atlItemListConfig.exists()){
            try {
                atlItemListConfig.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            getLogman().info("ATL item list created!");
            Config.createItemList(atlItemListConfig);
        }

        //TimeList00
        File atlTimeList00Config = new File("./config/AdminMenu/ATL/timeList.json");
        root = config.load(atlTimeList00Config);
        if(!atlTimeList00Config.exists() || !root.has("time_00")){
            try {
                atlTimeList00Config.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            getLogman().info("ATL time list created!");
            Config.createTimeList00(atlTimeList00Config);
        }

        //TimeList01
        root = config.load(atlTimeList00Config);
        if(!atlTimeList00Config.exists() || !root.has("time_01")){
            try {
                atlTimeList00Config.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            getLogman().info("ATL time 01 list created!");
            Config.createTimeList01(atlTimeList00Config);
        }

        //AmountList00
        File atlAmountList00Config = new File("./config/AdminMenu/ATL/amountList00.json");
        if(!atlAmountList00Config.exists()){
            try {
                atlAmountList00Config.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            getLogman().info("ATL amount list 00 created!");
            Config.createAmountList00(atlAmountList00Config);
        }

        //AmountList01
        File atlAmountList01Config = new File("./config/AdminMenu/ATL/amountList01.json");
        if(!atlAmountList01Config.exists()){
            try {
                atlAmountList01Config.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            getLogman().info("ATL amount list 01 created!");
            Config.createAmountList01(atlAmountList01Config);
        }

        //AmountList02
        File atlAmountList02Config = new File("./config/AdminMenu/ATL/amountList02.json");
        if(!atlAmountList02Config.exists()){
            try {
                atlAmountList02Config.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            getLogman().info("ATL amount list 02 created!");
            Config.createAmountList02(atlAmountList02Config);
        }

        //ReasonList
        File atlReasonListConfig = new File("./config/AdminMenu/ATL/reasonList.json");
        if(!atlReasonListConfig.exists()){
            try {
                atlReasonListConfig.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            getLogman().info("ATL reason list created!");
            Config.createReasonList(atlReasonListConfig);
        }
    }
}
