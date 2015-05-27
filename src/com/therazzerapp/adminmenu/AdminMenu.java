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

        String dir = "./config/AdminMenu/ATL/";
        de.myelitecraft.elitelib.api.config.Config config = EliteLib.getConfigManager().getConfig("JSON");
        ConfigSection root;

        //ATL Configs
        File atlConfigDir = new File(dir);
        if(!atlConfigDir.exists()){
            atlConfigDir.mkdir();
        }

        //BlockList
        File atlBlockListConfig = new File(dir + "blockList.json");
        root = config.load(atlBlockListConfig);
        if(!atlBlockListConfig.exists()){
            try {
                atlBlockListConfig.createNewFile();
                getLogman().info("ATL: blockList.json created!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

            if(!root.has("blocks")){
                Config.createBlockList(atlBlockListConfig);
                getLogman().info("ATL: Section blocks has been added to blockList.json");
            }


        //ItemList
        File atlItemListConfig = new File(dir + "itemList.json");
        root = config.load(atlItemListConfig);
        if(!atlItemListConfig.exists()){
            try {
                atlItemListConfig.createNewFile();
                getLogman().info("ATL: itemList.json created!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!root.has("items")){
            Config.createItemList(atlItemListConfig);
            getLogman().info("ATL: Section items has been added to itemList.json");
            }

        //TimeList
        File atlTimeListConfig = new File(dir + "timeList.json");
        root = config.load(atlTimeListConfig);
        if(!atlTimeListConfig.exists()){
            try {
                atlTimeListConfig.createNewFile();
                getLogman().info("ATL: timeList.json created!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

            if(!root.has("time_00")){
                Config.createTimeList00(atlTimeListConfig, getLogman());
                getLogman().info("ATL: Section time_00 has been added to timeList.json");
            }

            if(!root.has("time_01")){
                Config.createTimeList01(atlTimeListConfig, getLogman());
                getLogman().info("ATL: Section time_01 has been added to timeList.json");
            }


        //AmountList
        File atlAmountListConfig = new File(dir + "amountList.json");
        root = config.load(atlAmountListConfig);
        if(!atlAmountListConfig.exists()){
            try {
                atlAmountListConfig.createNewFile();
                getLogman().info("ATL: amountList.json created!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!root.has("amounts_00")){
                Config.createAmountList00(atlAmountListConfig);
            getLogman().info("ATL: Section amount_00 has been added to amountList.json");
            }

            if(!root.has("amounts_01")){
                Config.createAmountList01(atlAmountListConfig);
                getLogman().info("ATL: Section amount_01 has been added to amountList.json");
            }

        if (!root.has("amounts_01")){
                Config.createAmountList02(atlAmountListConfig);
            getLogman().info("ATL: Section amount_02 has been added to amountList.json");
            }


        //ReasonList
        File atlReasonListConfig = new File(dir + "reasonList.json");
        root = config.load(atlReasonListConfig);
        if(!atlReasonListConfig.exists()){
            try {
                atlReasonListConfig.createNewFile();
                getLogman().info("ATL: reasonList.json created!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!root.has("reasons")){
                Config.createReasonList(atlReasonListConfig);
            getLogman().info("ATL: Section reasons has been added to reasonList.json");
            }
    }
}
