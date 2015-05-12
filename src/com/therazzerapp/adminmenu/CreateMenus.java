package com.therazzerapp.adminmenu;

import com.therazzerapp.adminmenu.items.Back;
import com.therazzerapp.adminmenu.items.BackToMainMenu;
import com.therazzerapp.adminmenu.items.Exit;
import com.therazzerapp.adminmenu.items.Forward;
import de.myelitecraft.elitelib.api.EliteLib;
import de.myelitecraft.elitelib.api.menu.Menu;
import de.myelitecraft.elitelib.api.menu.MenuEntry;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
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

    private static ChatComponentFactory f = Canary.factory().getChatComponentFactory();

    public static void initMenus (LocaleHelper translator){
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();


        /////////////////////////////////////////////////////
        //                    Main Menu                    //
        /////////////////////////////////////////////////////

        //Main menu
        Menu mainMenu = EliteLib.getMenuFactory().newMenu("adm_m_h_main", "adminmenu.menu.main", f.colorWhite(),translator);
        mainMenu.addEntry(getBreakLine());
        if (AdminMenu.settings.isPlayermenu()){
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_m_player_commands", "adminmenu.menu.player", f.colorYellow(), f.getShowText(), f.newChatComponent("hover_main_player_commands"),f.getRunCommand(), "/chatclick chatmenu adm_m_h_p",translator));
        }
        if (AdminMenu.settings.isServermenu()){
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_m_server_commands","adminmenu.menu.server", f.colorYellow(), f.getShowText(), f.newChatComponent("hover_main_server_commands"),f.getRunCommand(), "/chatclick chatmenu adm_m_h_s",translator));
        }
        if(AdminMenu.settings.isWorldmenu()){
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_m_world_commands","adminmenu.menu.world", f.colorYellow(), f.getShowText(), f.newChatComponent("hover_main_world_commands"),f.getRunCommand(), "/chatclick chatmenu adm_m_h_w",translator));
        }
        if(AdminMenu.settings.isGroupmenu()){
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_m_group_commands" ,"adminmenu.menu.group", f.colorYellow(), f.getShowText(), f.newChatComponent("hover_main_group_commands"),f.getRunCommand(), "/chatclick chatmenu adm_m_h_g",translator));
        }
        EliteLib.getMenuManager().addMenu(addNavigation(mainMenu,translator));

        /////////////////////////////////////////////////////
        //                    Player Menu                  //
        /////////////////////////////////////////////////////

        //Player menu part 1
        Menu player_00 = EliteLib.getMenuFactory().newMenu("adm_m_h_p", "adminmenu.menu.player_00", f.colorWhite(),translator);
        player_00.addEntry(getBreakLine());
        player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_kick", "adminmenu.menu.player.kick", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_kick_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_p_kick", translator));
        player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_ban","adminmenu.menu.player.ban", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_ban_hover"), f.getRunCommand(),"/chatclick chatmenu adm_m_h_p_ban" , translator));
        player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_gm","adminmenu.menu.player.gamemode", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_gm_hover"), f.getRunCommand(),"/chatclick chatmenu adm_m_h_p_gm" , translator));
        player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_kill","adminmenu.menu.player.kill", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_kill_hover"), f.getRunCommand(),"/acb true atl_h_p_kill adm_m_h_p true kill %p" , translator));
        player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_mute","adminmenu.menu.player.mute", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_mute_hover"), f.getRunCommand(),"/acb true atl_h_p_mute adm_m_h_p true mute %p" , translator));
        player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_gi","adminmenu.menu.player.give", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_gi_hover"), f.getRunCommand(),"/chatclick chatmenu adm_m_h_p_gi" , translator));
        player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_tp","adminmenu.menu.player.tp", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_tp_hover"), f.getRunCommand(),"/chatclick chatmenu adm_m_h_p_tp" , translator));
        EliteLib.getMenuManager().addMenu(addNavigation(player_00, translator,"adminmenu.menu.player_01", "/chatclick chatmenu adm_m_h_p_01",null,null));

        //Player menu part 2
        Menu player_01 = EliteLib.getMenuFactory().newMenu("adm_m_h_p_01", "adminmenu.menu.player_01", f.colorWhite(),translator);
        player_01.addEntry(getBreakLine());
        player_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_op", "adminmenu.menu.player.op", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_op_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_p_op", translator));
        player_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_clr", "adminmenu.menu.player.clear", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_clr_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_p_clr", translator));
        player_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_xp", "adminmenu.menu.player.xp", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_xp_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_p_xp", translator));
        player_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_god", "adminmenu.menu.player.god", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_god_hover"), f.getRunCommand(), "/acb true atl_h_p_god adm_m_h_p_01 true god %p", translator));
        player_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_ef", "adminmenu.menu.player.effect", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_ef_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_p_ef", translator));
        player_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_lvl", "adminmenu.menu.player.lvl", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_lvl_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_p_lvl", translator));
        player_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_s", "adminmenu.menu.player.sound", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_s_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_p_s", translator));
        EliteLib.getMenuManager().addMenu(addNavigation(player_01, translator, "adminmenu.menu.player_02", "/chatclick chatmenu adm_m_h_p_02", "adminmenu.menu.player_00", "/chatclick chatmenu adm_m_h_p"));

        //Player menu part 3
        Menu player_02 = EliteLib.getMenuFactory().newMenu("adm_m_h_p_02", "adminmenu.menu.player_02", f.colorWhite(),translator);
        player_02.addEntry(getBreakLine());
        player_02.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_ac", "adminmenu.menu.player.ac", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_ac_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_p_ac", translator));
        EliteLib.getMenuManager().addMenu(addNavigation(player_02, translator, null,null, "adminmenu.menu.player_01", "/chatclick chatmenu adm_m_h_p_01"));

            //Kick menu
            Menu player_kick = EliteLib.getMenuFactory().newMenu("adm_m_h_p_kick", "adminmenu.menu.player.kick",f.colorWhite(),translator);
            player_kick.addEntry(getBreakLine());
            player_kick.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_kick_noreason", "adminmenu.player.kick.noreason",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_kick_noreason_hover"),f.getRunCommand(),"/acb true atl_h_p_kick adm_m_h_p_kick true kick %p",translator));
            player_kick.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_kick_reason", "adminmenu.player.kick.reason",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_kick_reason_hover"),f.getRunCommand(),"/acb true atl_h_p_kick adm_m_h_p_kick true kick %p %r",translator));
            player_kick.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_kick_customreason", "adminmenu.player.kick.customreason",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_kick_customreason_hover"),f.getSuggestCommand(),"/acb true atl_h_p_kick adm_m_h_p_kick true kick %p <reason>",translator));
            EliteLib.getMenuManager().addMenu(addNavigation(player_kick,translator,null,null,"adminmenu.menu.player_00","/chatclick chatmenu adm_m_h_p"));

            //Ban menu
            Menu player_ban = EliteLib.getMenuFactory().newMenu("adm_m_h_p_ban","adminmenu.menu.player.ban",f.colorWhite(),translator);
            player_ban.addEntry(getBreakLine());
            player_ban.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_ban_perm_noreason", "adminmenu.player.ban.perm.noreason", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_ban_perm_noreason_hover"), f.getRunCommand(), "/acb true atl_h_p_ban adm_m_h_p_ban true ban %p", translator));
            player_ban.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_ban_perm_reason", "adminmenu.player.ban.perm.reason",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_ban_reason_hover"),f.getSuggestCommand(),"/acb true atl_h_p_ban adm_m_h_p_ban true ban %p <reason>",translator));
            player_ban.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_ban_temp_noreason", "adminmenu.player.ban.temp.noreason",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_ban_noreason_hover"),f.getRunCommand(),"/acb true atl_h_p_ban adm_m_h_p_ban true ban %p noreason %t1",translator));
            player_ban.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_ban_temp_reason", "adminmenu.player.ban.temp.reason",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_ban_noreason_hover"),f.getSuggestCommand(),"/acb true atl_h_p_ban adm_m_h_p_ban true ban %p <reason> %t1",translator));
        player_ban.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_ban_unban", "adminmenu.player.ban.unban",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_ban_unban_hover"),f.getRunCommand(),"/acb true atl_h_p_ban adm_m_h_p_ban true unban %bp ",translator));
        EliteLib.getMenuManager().addMenu(addNavigation(player_ban,translator,null,null,"adminmenu.menu.player_00","/chatclick chatmenu adm_m_h_p"));

            //Gamemode menu
            Menu player_gamemode = EliteLib.getMenuFactory().newMenu("adm_m_h_p_gm","adminmenu.menu.player.gamemode",f.colorWhite(),translator);
            player_gamemode.addEntry(getBreakLine());
            player_gamemode.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_gm_surv","adminmenu.player.gamemode.survival",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_gm_surv_hover"),f.getRunCommand(),"/acb true atl_h_p_gm adm_m_h_p_gm true gamemode 0 %p",translator));
            player_gamemode.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_gm_crea","adminmenu.player.gamemode.creative",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_gm_crea_hover"),f.getRunCommand(),"/acb true atl_h_p_gm adm_m_h_p_gm true gamemode 1 %p",translator));
            player_gamemode.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_gm_adve","adminmenu.player.gamemode.adventure",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_gm_adve_hover"),f.getRunCommand(),"/acb true atl_h_p_gm adm_m_h_p_gm true gamemode 2 %p",translator));
            player_gamemode.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_gm_spec","adminmenu.player.gamemode.spectator",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_gm_spec_hover"),f.getRunCommand(),"/acb true atl_h_p_gm adm_m_h_p_gm true gamemode 3 %p",translator));
            EliteLib.getMenuManager().addMenu(addNavigation(player_gamemode,translator,null,null,"adminmenu.menu.player_00","/chatclick chatmenu adm_m_h_p"));

            //Op menu
            Menu player_op = EliteLib.getMenuFactory().newMenu("adm_m_h_p_op","adminmenu.menu.player.op",f.colorWhite(),translator);
            player_op.addEntry(getBreakLine());
            player_op.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_op_t","adminmenu.player.op.op",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_op_t_hover"),f.getRunCommand(),"/acb true atl_h_p_op adm_m_h_p_op true op %p",translator));
            player_op.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_op_f", "adminmenu.player.op.deop", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_op_f_hover"), f.getRunCommand(), "/acb true atl_h_p_op adm_m_h_p_op true deop %p", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(player_op,translator,null,null,"adminmenu.menu.player_01","/chatclick chatmenu adm_m_h_p_01"));

            //XP menu
            Menu player_xp = EliteLib.getMenuFactory().newMenu("adm_m_h_p_xp","adminmenu.menu.player.xp",f.colorWhite(),translator);
            player_xp.addEntry(getBreakLine());
            player_xp.addEntry(EliteLib.getMenuFactory().newMenuEntry("100","adminmenu.player.xp.100",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_xp_100_hover"),f.getRunCommand(),"/acb true atl_h_p_xp adm_m_h_p_xp true xp 100 %p",translator));
            player_xp.addEntry(EliteLib.getMenuFactory().newMenuEntry("1000","adminmenu.player.xp.1000",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_xp_1000_hover"),f.getRunCommand(),"/acb true atl_h_p_xp adm_m_h_p_xp true xp 1000 %p",translator));
            player_xp.addEntry(EliteLib.getMenuFactory().newMenuEntry("10000","adminmenu.player.xp.100",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_xp_10000_hover"),f.getRunCommand(),"/acb true atl_h_p_xp adm_m_h_p_xp true xp 10000 %p",translator));
            player_xp.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_c_other","adminmenu.player.xp.other",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_xp_other_hover"),f.getRunCommand(),"/acb true atl_h_p_xp adm_m_h_p_xp true xp %a %p",translator));
            player_xp.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_c_custom","adminmenu.player.xp.custom",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_xp_custom_hover"),f.getRunCommand(),"/acb false atl_h_p_xp adm_m_h_p_xp true xp <amount> %p",translator));
            EliteLib.getMenuManager().addMenu(addNavigation(player_xp,translator,null,null,"adminmenu.menu.player_01","/chatclick chatmenu adm_m_h_p_01"));

            //Level menu
            Menu player_level = EliteLib.getMenuFactory().newMenu("adm_m_h_p_lvl","adminmenu.menu.player.lvl",f.colorWhite(),translator);
            player_level.addEntry(getBreakLine());
            player_level.addEntry(EliteLib.getMenuFactory().newMenuEntry("10","adminmenu.player.lvl.10",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_lvl_10_hover"),f.getRunCommand(),"/acb true atl_h_p_lvl adm_m_h_p_lvl true xp 10L %p",translator));
            player_level.addEntry(EliteLib.getMenuFactory().newMenuEntry("100","adminmenu.player.lvl.100",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_lvl_100_hover"),f.getRunCommand(),"/acb true atl_h_p_lvl adm_m_h_p_lvl true xp 100L %p",translator));
            player_level.addEntry(EliteLib.getMenuFactory().newMenuEntry("1000","adminmenu.player.lvl.1000",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_lvl_1000_hover"),f.getRunCommand(),"/acb true atl_h_p_lvl adm_m_h_p_lvl true xp 1000L %p",translator));
            player_level.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_c_other","adminmenu.player.lvl.other",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_lvl_other_hover"),f.getRunCommand(),"/acb true atl_h_p_lvl adm_m_h_p_lvl true xp %aL %p",translator));
            player_level.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_c_custom","adminmenu.player.lvl.custom",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_lvl_custom_hover"),f.getRunCommand(),"/acb false atl_h_p_lvl adm_m_h_p_lvl true xp <amount>L %p",translator));
            EliteLib.getMenuManager().addMenu(addNavigation(player_level,translator,null,null,"adminmenu.menu.player_01","/chatclick chatmenu adm_m_h_p_01"));

            //TP menu
            Menu player_tp = EliteLib.getMenuFactory().newMenu("adm_m_h_p_tp","adminmenu.menu.player.tp",f.colorWhite(),translator);
            player_tp.addEntry(getBreakLine());
            player_tp.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_tp_here","adminmenu.player.tp.here",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_tp_here_hover"),f.getRunCommand(),"/acb true atl_h_p_tp adm_m_h_p_tp true tp %p %c",translator));
            player_tp.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_tp_toplayer","adminmenu.player.tp.toplayer",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_tp_toplayer_hover"),f.getRunCommand(),"/acb true atl_h_p_tp adm_m_h_p_tp true tp %c %p",translator));
            player_tp.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_tp_playertoplayer","adminmenu.player.tp.playertoplayer",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_tp_playertoplayer_hover"),f.getRunCommand(),"/acb true atl_h_p_tp adm_m_h_p_tp true tp %p %p",translator));
            player_tp.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_tp_xyz","adminmenu.player.tp.xyz",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_tp_xyz_hover"),f.getRunCommand(),"/acb true atl_h_p_tp adm_m_h_p_tp true tp %c <x> <y> <z>",translator));
            player_tp.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_tp_spawn","adminmenu.player.tp.spawn",f.colorYellow(),f.getShowText(),f.newChatComponent("itm_n_p_tp_spawn_hover"),f.getRunCommand(),"/spawn",translator));
            EliteLib.getMenuManager().addMenu(addNavigation(player_tp, translator, null, null, "adminmenu.menu.player_00", "/chatclick chatmenu adm_m_h_p"));

            //Clear menu
            Menu player_clear = EliteLib.getMenuFactory().newMenu("adm_m_h_p_clr","adminmenu.menu.player.clear",f.colorWhite(),translator);
            player_clear.addEntry(getBreakLine());
            player_clear.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_clr_pcomplete", "adminmenu.player.clear.pcomplete", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_clr_pcomplete_hover"), f.getRunCommand(), "/acb true atl_h_p_clr adm_m_h_p_clr true clear %p", translator));
            player_clear.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_clr_pselected", "adminmenu.player.clear.pselected", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_clr_pselected_hover"), f.getRunCommand(), "/acb true atl_h_p_clr adm_m_h_p_clr true clear %p %pi %a1",translator));
            player_clear.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_clr_ocomplete", "adminmenu.player.clear.ocomplete", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_clr_ocomplete_hover"), f.getRunCommand(), "/acb true atl_h_p_clr adm_m_h_p_clr true clear %c",translator));
            EliteLib.getMenuManager().addMenu(addNavigation(player_clear, translator, null, null, "adminmenu.menu.player_01", "/chatclick chatmenu adm_m_h_p_01"));

            //Give menu
            Menu player_give = EliteLib.getMenuFactory().newMenu("adm_m_h_p_gi","adminmenu.menu.player.give",f.colorWhite(),translator);
            player_give.addEntry(getBreakLine());
            player_give.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_give_otheritem", "adminmenu.player.give.other.item", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_give_otheritem_hover"), f.getRunCommand(), "/acb true atl_h_p_gi adm_m_h_p_gi true give %p %i %a", translator));
            player_give.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_give_otherblock", "adminmenu.player.give.other.block", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_give_otherblock_hover"), f.getRunCommand(), "/acb true atl_h_p_gi adm_m_h_p_gi true give %p %b1 %a", translator));
            player_give.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_give_item", "adminmenu.player.give.self.item", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_give_item_hover"), f.getRunCommand(), "/acb true atl_h_p_gi adm_m_h_p_gi true give %c %i %a", translator));
            player_give.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_give_block", "adminmenu.player.give.self.block", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_give_block_hover"), f.getRunCommand(), "/acb true atl_h_p_gi adm_m_h_p_gi true give %c %b1 %a", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(player_give, translator, null, null, "adminmenu.menu.player_00", "/chatclick chatmenu adm_m_h_p"));

            //Effect menu
            Menu player_effect = EliteLib.getMenuFactory().newMenu("adm_m_h_p_ef","adminmenu.menu.player.effect",f.colorWhite(),translator);
            player_effect.addEntry(getBreakLine());
            player_effect.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_effect_give", "adminmenu.player.effect.give", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_effect_give_hover"), f.getRunCommand(), "/acb true atl_h_p_ef adm_m_h_p_ef true effect %p %ef %t2", translator));
            player_effect.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_effect_givea", "adminmenu.player.effect.give.advanced", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_effect_givea_hover"), f.getRunCommand(), "/acb true atl_h_p_ef adm_m_h_p_ef true effect %p %ef %t2 %a2 %tf", translator));
            player_effect.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_effect_clear", "adminmenu.player.effect.clear", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_effect_clear_hover"), f.getRunCommand(), "/acb true atl_h_p_ef adm_m_h_p_ef true effect %p clear", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(player_effect, translator, null, null, "adminmenu.menu.player_01", "/chatclick chatmenu adm_m_h_p_01"));

            //Achievement menu
            Menu player_achievement = EliteLib.getMenuFactory().newMenu("adm_m_h_p_ac","adminmenu.menu.player.achievement",f.colorWhite(),translator);
            player_achievement.addEntry(getBreakLine());
            player_achievement.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_achievement_give", "adminmenu.player.achievement.give", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_achievement_give_hover"), f.getRunCommand(), "/acb true atl_h_p_ac adm_m_h_p_ac true achievement give %ac %p", translator));
            player_achievement.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_achievement_god", "adminmenu.player.achievement.god", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_achievement_god_hover"), f.getRunCommand(), "/acb true atl_h_p_ac adm_m_h_p_ac true achievement give * %p", translator));
            player_achievement.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_achievement_take", "adminmenu.player.achievement.take", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_achievement_take_hover"), f.getRunCommand(), "/acb true atl_h_p_ac adm_m_h_p_ac true achievement take %ac %p", translator));
            player_achievement.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_achievement_clear", "adminmenu.player.achievement.clear", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_achievement_clear_hover"), f.getRunCommand(), "/acb true atl_h_p_ac adm_m_h_p_ac true achievement take * %p", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(player_achievement, translator, null, null, "adminmenu.menu.player_02", "/chatclick chatmenu adm_m_h_p_02"));

            //Sound menu
            Menu player_sound = EliteLib.getMenuFactory().newMenu("adm_m_h_p_s","adminmenu.menu.player.sound",f.colorWhite(),translator);
            player_sound.addEntry(getBreakLine());
            player_sound.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_sound_player", "adminmenu.player.sound.player", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_sound_player_hover"), f.getRunCommand(), "/acb true atl_h_p_s adm_m_h_p_s true playsound %so %p", translator));
            player_sound.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_p_sound_all", "adminmenu.player.sound.all", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_p_sound_all_hover"), f.getRunCommand(), "/acb true atl_h_p_s adm_m_h_p_s true playsound %so @a", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(player_sound, translator, null, null, "adminmenu.menu.player_01", "/chatclick chatmenu adm_m_h_p_01"));

        /////////////////////////////////////////////////////
        //                   Server Menu                   //
        /////////////////////////////////////////////////////

        //Server menu part 1
        Menu server_00 = EliteLib.getMenuFactory().newMenu("adm_m_h_s","adminmenu.menu.server_00", f.colorWhite(),translator);
        server_00.addEntry(getBreakLine());
        server_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_s_stop", "adminmenu.server.stop", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_s_stop_hover"), f.getRunCommand(), "/stop", translator));
        server_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_s_reloadconfigs", "adminmenu.server.reloadconfigs", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_s_reloadconfigs_hover"), f.getRunCommand(), "/reload", translator));
        server_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_s_whl", "adminmenu.server.whitelist", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_s_whl_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_s_whl", translator));
        server_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_s_res", "adminmenu.server.reservelist", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_s_res_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_s_res", translator));
        EliteLib.getMenuManager().addMenu(addNavigation(server_00, translator, "adminmenu.menu.server_01", "/chatclick chatmenu adm_m_h_s_01", null,null));

        //Server menu part 2
        Menu server_01 = EliteLib.getMenuFactory().newMenu("adm_m_h_s_01","adminmenu.menu.server_01", f.colorWhite(),translator);
        server_01.addEntry(getBreakLine());
        EliteLib.getMenuManager().addMenu(addNavigation(server_01, translator, null, null, "adminmenu.menu.server_00","/chatclick chatmenu adm_m_h_s"));

            //Whitelist menu
            Menu server_whitelist = EliteLib.getMenuFactory().newMenu("adm_m_h_s_whl","adminmenu.menu.server.whitelist", f.colorWhite(),translator);
            server_whitelist.addEntry(getBreakLine());
            server_whitelist.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_c_addplayer", "adminmenu.server.whitelist.add", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_s_whl_add_hover"), f.getSuggestCommand(), "/whitelist add <player>", translator));
            server_whitelist.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_c_removeplayer", "adminmenu.server.whitelist.remove", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_s_whl_remove_hover"), f.getRunCommand(), "/acb true atl_h_s_whl adm_m_h_s_whl true whitelist remove %w", translator));
            server_whitelist.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_c_listplayer", "adminmenu.server.whitelist.list", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_s_whl_list_hover"), f.getRunCommand(), "/acb true atl_h_s_whl_l adm_m_h_s_whl true msg %w", translator));
            server_whitelist.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_c_reload", "adminmenu.server.whitelist.reload", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_s_whl_reload_hover"), f.getRunCommand(), "/whitelist reload", translator));
            server_whitelist.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_c_turnon", "adminmenu.server.whitelist.turnon", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_s_whl_turnon_hover"), f.getRunCommand(), "/whitelist on", translator));
            server_whitelist.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_c_turnoff", "adminmenu.server.whitelist.turnoff", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_s_whl_turnoff_hover"), f.getRunCommand(), "/whitelist off", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(server_whitelist, translator, null, null, "adminmenu.menu.server_00", "/chatclick chatmenu adm_m_h_s"));

            //Reservelist mennu
            Menu server_reservelist = EliteLib.getMenuFactory().newMenu("adm_m_h_s_res","adminmenu.menu.server.reservelist", f.colorWhite(),translator);
            server_reservelist.addEntry(getBreakLine());
            server_reservelist.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_c_addplayer", "adminmenu.server.reservelist.add", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_s_res_add_hover"), f.getSuggestCommand(), "/reservelist add <player>", translator));
            server_reservelist.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_c_removeplayer", "adminmenu.server.reservelist.remove", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_s_res_remove_hover"), f.getSuggestCommand(), "/acb true atl_h_s_res adm_m_h_s_res true reservelist remove %r", translator));
            server_reservelist.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_c_listplayer", "adminmenu.server.reservelist.list", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_s_res_list_hover"), f.getSuggestCommand(), "/acb true atl_h_s_res adm_m_h_s_res true msg %r", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(server_reservelist, translator, null, null, "adminmenu.menu.server_00", "/chatclick chatmenu adm_m_h_s"));

            //Timeout menu


        /////////////////////////////////////////////////////
        //                    World Menu                   //
        /////////////////////////////////////////////////////

        //World menu part 1
        Menu world_00 = EliteLib.getMenuFactory().newMenu("adm_m_h_w", "adminmenu.menu.world_00", f.colorWhite(), translator);
        world_00.addEntry(getBreakLine());
        world_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_w_firespread", "adminmenu.world.firespread", f.colorYellow(), f.getShowText(), f.newChatComponent("itm_n_w_firespread_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_firespread", translator));
        EliteLib.getMenuManager().addMenu(addNavigation(world_00, translator, "adminmenu.menu.world_01", "/chatclick chatmenu adm_m_h_w_01", null, null));

        //World menu part 2
        Menu world_01 = EliteLib.getMenuFactory().newMenu("adm_m_h_w_01", "adminmenu.menu.world_01", f.colorWhite(), translator);
        world_01.addEntry(getBreakLine());
        EliteLib.getMenuManager().addMenu(addNavigation(world_01, translator, "adminmenu.menu.world_02", "/chatclick chatmenu adm_m_h_w_02", "adminmenu.menu.world_00", "/chatclick chatmenu adm_m_h_w"));

        //World menu part 3
        Menu world_02 = EliteLib.getMenuFactory().newMenu("adm_m_h_w_02", "adminmenu.menu.world_02", f.colorWhite(), translator);
        world_02.addEntry(getBreakLine());
        EliteLib.getMenuManager().addMenu(addNavigation(world_02, translator, null, null, "adminmenu.menu.world_01", "/chatclick chatmenu adm_m_h_w_01"));

        //Firespread Menu
        Menu world_firespread = getGameruleMenu("adm_m_h_w_firespread", "adminmenu.menu.world.firespread", "adminmenu.world.firespread", "itm_n_w_firespread_on", "itm_n_w_firespread_off", "itm_n_w_firespread_status", "doFireTick", "/chatclick chatmenu adm_m_h_w", "adminmenu.menu.world_00", translator);
        EliteLib.getMenuManager().addMenu(world_firespread);

        //Daylightcycle Menu
        Menu world_daylightcycle = getGameruleMenu("adm_m_h_w_daylightcycle","adminmenu.menu.world.daylightcycle","adminmenu.world.daylightcycle","itm_n_w_daylightcycle_on","itm_n_w_daylightcycle_off","itm_n_w_daylightcycle_status","doDaylightCycle","/chatclick chatmenu adm_m_h_w_01","adminmenu.menu.world_01",translator);
        EliteLib.getMenuManager().addMenu(world_firespread);



    }

    private static ChatComponent getHyphen (String lang){
        return f.newChatComponent("- ").appendSibling(f.newChatComponent(lang));
    }

    private static Menu addNavigation(Menu menu,LocaleHelper translator,String permissionForward, String commandForward, String permissionBack, String commandBack){
        
        //Forward Buttons
        if(!(commandForward == null)){
            if(permissionForward == null){
                menu.addEntry(new Forward("",commandForward,translator).getItem());
            } else {
                menu.addEntry(new Forward(permissionForward,commandForward, translator).getItem());
            }
        }

        //Back buttons
        if(!(commandBack == null)){
            if(permissionBack == null){
                menu.addEntry(new Back("",commandBack,translator).getItem());
            } else {
                menu.addEntry(new Back(permissionBack,commandBack,translator).getItem());
            }
        }
        menu.addEntry(new BackToMainMenu(translator).getItem());
        menu.addEntry(getBreakLine());
        menu.addEntry(new Exit(translator).getItem());
        menu.addEntry(EliteLib.getMenuFactory().newBlankLine());
        return menu;
    }

    private static Menu addNavigation(Menu menu,LocaleHelper translator){
        menu.addEntry(getBreakLine());
        menu.addEntry(new Exit(translator).getItem());
        menu.addEntry(EliteLib.getMenuFactory().newBlankLine());
        return menu;
    }

    private static MenuEntry getBreakLine(){
        return EliteLib.getMenuFactory().newMenuEntry("============================");
    }

    private static Menu getGameruleMenu(String menuName, String menuPermission, String itemPermission, String onHover, String offHover, String statusHover, String gameRule, String commandBack, String permissionBack, LocaleHelper translator){
        Menu menu = EliteLib.getMenuFactory().newMenu(menuName,menuPermission, f.colorWhite(),translator);
        menu.addEntry(getBreakLine());
        menu.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_c_turnon", itemPermission + ".turnon", f.colorYellow(), f.getShowText(), f.newChatComponent(onHover + "_hover"), f.getRunCommand(), "/gamerule " + gameRule + " true", translator));
        menu.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_c_turnoff", itemPermission + ".turnoff", f.colorYellow(), f.getShowText(), f.newChatComponent(offHover + "_hover"), f.getRunCommand(), "/gamerule " + gameRule + " false", translator));
        menu.addEntry(EliteLib.getMenuFactory().newMenuEntry("itm_n_c_status", itemPermission + ".status", f.colorYellow(), f.getShowText(), f.newChatComponent(statusHover + "_hover"), f.getRunCommand(), "/gamerule " + gameRule, translator));
        return addNavigation(menu,translator,null,null,permissionBack,commandBack);
    }
}
