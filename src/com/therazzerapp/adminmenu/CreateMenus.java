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
        Menu mainMenu = EliteLib.getMenuFactory().newMenu("adm_m_h_main", "adminmenu.menu.main", f.colorWhite(),translator);
        mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("============================"));
        if (AdminMenu.settings.isPlayermenu()){
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("item_name_main_player_commands", null, f.colorYellow(), f.getShowText(), f.newChatComponent("hover_main_player_commands"),f.getRunCommand(), "/chatclick chatmenu adm_m_h_p",translator));
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
        Menu player_00 = EliteLib.getMenuFactory().newMenu("adm_m_h_p", "adminmenu.menu.player_00", f.colorWhite(),translator);
        player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("============================"));
        player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_kick", "adminmenu.menu.player.kick", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_kick_hover"), f.getRunCommand(),"/chatclick chatmenu adm_m_h_p_kick" , translator));
        player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_ban", "adminmenu.menu.player.ban", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_ban_hover"), f.getRunCommand(),"/chatclick chatmenu adm_m_h_p_ban" , translator));
        player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_gm", "adminmenu.menu.player.gamemode", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_gm_hover"), f.getRunCommand(),"/chatclick chatmenu adm_m_h_p_gm" , translator));
        player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_op", "adminmenu.menu.player.op", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_op_hover"), f.getRunCommand(),"/chatclick chatmenu adm_m_h_p_op" , translator));

        EliteLib.getMenuManager().addMenu(addEnd(player_00, translator, "adminmenu.menu.player_01", "/chatclick chatmenu adm_m_h_p_01", "adminmenu.menu.main", "/chatclick chatmenu adm_m_h_main"));

            //Kick menu
            Menu player_kick = EliteLib.getMenuFactory().newMenu("adm_m_h_p_kick", "adminmenu.menu.player.kick",f.colorWhite(),translator);
            player_kick.addEntry(EliteLib.getMenuFactory().newMenuEntry("============================"));
            player_kick.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_kick_noreason", "adminmenu.player.kick.noreason",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_kick_noreason_hover"),f.getRunCommand(),"/cbuilder true atl_h_p_kick adm_m_h_p_kick true kick %p",translator));
            player_kick.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_kick_reason", "adminmenu.player.kick.reason",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_kick_reason_hover"),f.getRunCommand(),"/cbuilder true atl_h_p_kick adm_m_h_p_kick true kick %p %r",translator));
            player_kick.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_kick_customreason", "adminmenu.player.kick.customreason",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_kick_customreason_hover"),f.getSuggestCommand(),"/cbuilder true atl_h_p_kick adm_m_h_p_kick true kick %p <reason>",translator));
            EliteLib.getMenuManager().addMenu(addEnd(player_kick,translator,null,null,"adminmenu.menu.player_00","/chatclick chatmenu adm_m_h_p"));

            //Ban menu
            Menu player_ban = EliteLib.getMenuFactory().newMenu("adm_m_h_p_ban","adminmenu.menu.player.ban",f.colorWhite(),translator);
            player_ban.addEntry(EliteLib.getMenuFactory().newMenuEntry("============================"));
            player_ban.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_ban_perm_noreason", "adminmenu.player.ban.perm.noreason",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_ban_perm_noreason_hover"),f.getRunCommand(),"/cbuilder true atl_h_p_ban adm_m_h_p_ban true ban %p",translator));
            player_ban.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_ban_perm_reason", "adminmenu.player.ban.perm.reason",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_ban_reason_hover"),f.getSuggestCommand(),"/cbuilder true atl_h_p_ban adm_m_h_p_ban true ban %p <reason>",translator));
            player_ban.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_ban_temp_noreason", "adminmenu.player.ban.temp.noreason",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_ban_noreason_hover"),f.getRunCommand(),"/cbuilder true atl_h_p_ban adm_m_h_p_ban true ban %p noreason %t1",translator));
            player_ban.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_ban_temp_reason", "adminmenu.player.ban.temp.reason",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_ban_noreason_hover"),f.getSuggestCommand(),"/cbuilder true atl_h_p_ban adm_m_h_p_ban true ban %p <reason> %t1",translator));
            EliteLib.getMenuManager().addMenu(addEnd(player_ban,translator,null,null,"adminmenu.menu.player_00","/chatclick chatmenu adm_m_h_p"));

            //Gamemode menu
            Menu player_gamemode = EliteLib.getMenuFactory().newMenu("adm_m_h_p_gm","adminmenu.menu.player.gamemode",f.colorWhite(),translator);
            player_gamemode.addEntry(EliteLib.getMenuFactory().newMenuEntry("============================"));
            player_gamemode.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_gm_surv","adminmenu.player.gamemode.survival",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_gm_surv_hover"),f.getRunCommand(),"/cbuilder true atl_h_p_gm adm_m_h_p_gm true gamemode 0 %p",translator));
            player_gamemode.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_gm_crea","adminmenu.player.gamemode.creative",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_gm_crea_hover"),f.getRunCommand(),"/cbuilder true atl_h_p_gm adm_m_h_p_gm true gamemode 1 %p",translator));
            player_gamemode.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_gm_adve","adminmenu.player.gamemode.adventure",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_gm_adve_hover"),f.getRunCommand(),"/cbuilder true atl_h_p_gm adm_m_h_p_gm true gamemode 2 %p",translator));
            player_gamemode.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_gm_spec","adminmenu.player.gamemode.spectator",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_gm_spec_hover"),f.getRunCommand(),"/cbuilder true atl_h_p_gm adm_m_h_p_gm true gamemode 3 %p",translator));
            EliteLib.getMenuManager().addMenu(addEnd(player_gamemode,translator,null,null,"adminmenu.menu.player_00","/chatclick chatmenu adm_m_h_p"));

            //Op menu
            Menu player_op = EliteLib.getMenuFactory().newMenu("adm_m_h_p_op","adminmenu.menu.player.op",f.colorWhite(),translator);
            player_op.addEntry(EliteLib.getMenuFactory().newMenuEntry("============================"));
            player_op.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_op_t","adminmenu.player.op.op",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_op_t_hover"),f.getRunCommand(),"/cbuilder true atl_h_p_op adm_m_h_p_op true op %p",translator));
            player_op.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_op_f","adminmenu.player.op.deop",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_op_f_hover"),f.getRunCommand(),"/cbuilder true atl_h_p_op adm_m_h_p_op true deop %p",translator));
            EliteLib.getMenuManager().addMenu(addEnd(player_op,translator,null,null,"adminmenu.menu.player_00","/chatclick chatmenu adm_m_h_p"));
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
