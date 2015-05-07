package com.therazzerapp.adminmenu;

import de.myelitecraft.elitelib.api.EliteLib;
import de.myelitecraft.elitelib.api.menu.Menu;
import net.canarymod.Canary;
import net.canarymod.api.factory.ChatComponentFactory;
import net.visualillusionsent.utils.LocaleHelper;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 02/05/2015
 * Time: 21:22 PM
 * Package: com.therazzerapp.adminmenu
 * E-Mail: rezzer101@googlemail.com
 */

public class CreateMenus {
    public static void initMenus (LocaleHelper translator){
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();

        //Main menu
        Menu mainMenu = EliteLib.getMenuFactory().newMenu("menu_headline_main", "adminmenu.menu.main", f.colorWhite(),translator);
        mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("============================"));
        if (AdminMenu.settings.isPlayermenu()){
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("item_name_main_player_commands", null, f.colorYellow(), f.getShowText(), f.newChatComponent("hover_main_player_commands"),f.getRunCommand(), "/chatclick chatmenu item_name_main_player_command",translator));
        }
        if (AdminMenu.settings.isServermenu()){
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("item_name_main_server_commands", null, f.colorYellow(), f.getShowText(), f.newChatComponent("hover_main_server_commands"),f.getRunCommand(), "/chatclick chatmenu item_name_main_player_command",translator));
        }
        if(AdminMenu.settings.isWorldmenu()){
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("item_name_main_world_commands", null, f.colorYellow(), f.getShowText(), f.newChatComponent("hover_main_world_commands"),f.getRunCommand(), "/chatclick chatmenu item_name_main_world_command",translator));
        }
        if(AdminMenu.settings.isGroupmenu()){
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("item_name_main_group_commands", null, f.colorYellow(), f.getShowText(), f.newChatComponent("hover_main_group_commands"),f.getRunCommand(), "/chatclick chatmenu item_name_main_group_command",translator));
        }
        mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("============================"));
        mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("extras_close","adminmenu.command.close",f.colorYellow(),f.getShowText(),f.newChatComponent("extras_close_hover"),f.getRunCommand(),"/adminmenu exit",translator));
        EliteLib.getMenuManager().addMenu(mainMenu);

        //Player menu part 1
        Menu player_00 = EliteLib.getMenuFactory().newMenu("item_name_main_player_command", "adminmenu.menu.main", f.colorWhite(),translator);
        player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("============================"));
        player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("item_name_player_kick","adminmenu.command.player",f.colorYellow(),f.getShowText(),f.newChatComponent("Test"),f.getRunCommand(),"/cbuilder true Player item_name_player_kick kick %p"));
        player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("============================"));
        EliteLib.getMenuManager().addMenu(player_00);
    }
}
