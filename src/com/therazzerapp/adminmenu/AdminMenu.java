package com.therazzerapp.adminmenu;

import com.therazzerapp.adminmenu.commands.Admin;
import com.therazzerapp.adminmenu.commands.CommandBuilder;
import com.therazzerapp.adminmenu.config.Config;
import de.myelitecraft.elitelib.api.EliteLib;
import de.myelitecraft.elitelib.api.commands.CommandManager;
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

        CreateMenus.initMenus(translator);
        EliteLib.getCommandManager().registerCommand(this,new Admin(this, translator));
        EliteLib.getCommandManager().registerCommand(this,new CommandBuilder(this,translator));

        return true;
    }

    @Override
    public void disable() {

    }
}
