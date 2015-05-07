package com.therazzerapp.adminmenu;

import com.therazzerapp.adminmenu.items.Back;
import com.therazzerapp.adminmenu.items.BackToMainMenu;
import com.therazzerapp.adminmenu.items.Exit;
import com.therazzerapp.adminmenu.items.Forward;
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
        Menu mainMenu = EliteLib.getMenuFactory().newMenu("adminmenu_menu_headline_main", "adminmenu.menu.main", f.colorWhite(),translator);
        mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("============================"));
        if (AdminMenu.settings.isPlayermenu()){
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("item_name_main_player_commands", null, f.colorYellow(), f.getShowText(), f.newChatComponent("hover_main_player_commands"),f.getRunCommand(), "/chatclick chatmenu adminmenu_menu_headline_player",translator));
        }
        if (AdminMenu.settings.isServermenu()){
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("item_name_main_server_commands", null, f.colorYellow(), f.getShowText(), f.newChatComponent("hover_main_server_commands"),f.getRunCommand(), "/chatclick chatmenu adminmenu_item_name_main_player_command",translator));
        }
        if(AdminMenu.settings.isWorldmenu()){
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("item_name_main_world_commands", null, f.colorYellow(), f.getShowText(), f.newChatComponent("hover_main_world_commands"),f.getRunCommand(), "/chatclick chatmenu adminmenu_item_name_main_world_command",translator));
        }
        if(AdminMenu.settings.isGroupmenu()){
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("item_name_main_group_commands", null, f.colorYellow(), f.getShowText(), f.newChatComponent("hover_main_group_commands"),f.getRunCommand(), "/chatclick chatmenu adminmenu_item_name_main_group_command",translator));
        }
        EliteLib.getMenuManager().addMenu(addEnd(mainMenu,translator));

        //Player menu part 1
        Menu player_00 = EliteLib.getMenuFactory().newMenu("adminmenu_menu_headline_player", "adminmenu.menu.player_00", f.colorWhite(),translator);
        player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("============================"));
        player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("item_name_player_kick", "adminmenu.menu.player", f.colorYellow(), f.getShowText(), f.newChatComponent("item_name_player_kick_hover"), f.getRunCommand(),"/chatclick chatmenu adminmenu_menu_headline_player_kick" , translator));
        EliteLib.getMenuManager().addMenu(addEnd(player_00, translator, "adminmenu.menu.player_01", "adminmenu_menu_headline_player_01", null, null));


            //Kick menu
            Menu player_kick = EliteLib.getMenuFactory().newMenu("adminmenu_menu_headline_player_kick", "adminmenu.menu.player_kick",f.colorWhite(),translator);
            player_kick.addEntry(EliteLib.getMenuFactory().newMenuEntry("============================"));
            player_kick.addEntry(EliteLib.getMenuFactory().newMenuEntry("item_name_player_kick_noreason", "adminmenu.player.kick.noreason",f.colorYellow(),f.getShowText(),f.newChatComponent("item_name_player_kick_noreason_hover"),f.getRunCommand(),"/cbuilder true autolist_headline_player_kick adminmenu_menu_headline_player_kick true kick %p",translator));
            player_kick.addEntry(EliteLib.getMenuFactory().newMenuEntry("item_name_player_kick_reason", "adminmenu.player.kick.reason",f.colorYellow(),f.getShowText(),f.newChatComponent("item_name_player_kick_reason_hover"),f.getRunCommand(),"/cbuilder true autolist_headline_player_kick adminmenu_menu_headline_player_kick true kick %p %r",translator));
            player_kick.addEntry(EliteLib.getMenuFactory().newMenuEntry("item_name_player_kick_customreason", "adminmenu.player.kick.customreason",f.colorYellow(),f.getShowText(),f.newChatComponent("item_name_player_kick_customreason_hover"),f.getSuggestCommand(),"/cbuilder true autolist_headline_player_kick adminmenu_menu_headline_player_kick true kick %p <reason>",translator));
            EliteLib.getMenuManager().addMenu(addEnd(player_kick,translator,null,null,"/chatclick chatmenu adminmenu_menu_headline_player_kick","adminmenu.menu.player_kick"));
    }

    private static Menu addEnd(Menu menu,LocaleHelper translator,String permissionForward, String commandForward, String permissionBack, String commandBack){
        if(!(commandForward == null)){
            if(permissionForward == null){
                menu.addEntry(new Forward("",commandForward,translator).getItem());
            } else {
                menu.addEntry(new Forward(permissionForward,commandForward, translator).getItem());
            }
        }

        if(!(commandBack == null)){
            if(permissionBack == null){
                menu.addEntry(new Back("",commandBack,translator).getItem());
            } else {
                menu.addEntry(new Back(permissionBack,commandBack,translator).getItem());
            }
        }
        menu.addEntry(new BackToMainMenu(translator).getItem());
        menu.addEntry(EliteLib.getMenuFactory().newMenuEntry("============================"));
        menu.addEntry(new Exit(translator).getItem());
        menu.addEntry(EliteLib.getMenuFactory().newBlankLine());
        return menu;
    }

    private static Menu addEnd(Menu menu,LocaleHelper translator){
        menu.addEntry(EliteLib.getMenuFactory().newMenuEntry("============================"));
        menu.addEntry(new Exit(translator).getItem());
        menu.addEntry(EliteLib.getMenuFactory().newBlankLine());
        return menu;
    }
}
