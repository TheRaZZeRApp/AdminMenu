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

        Menu mainMenu = EliteLib.getMenuFactory().newMenu("adm_m_h_main", "adminmenu.menu.main", f.colorWhite(),translator);
        mainMenu.addEntry(getBreakLine());
        if (AdminMenu.settings.isPlayermenu()){
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_m_player_commands", "adminmenu.menu.player", f.colorYellow(), f.getShowText(), f.newChatComponent("hover_main_player_commands"),f.getRunCommand(), "/chatclick chatmenu adm_m_h_p",translator));
        }
        if (AdminMenu.settings.isServermenu()){
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_m_server_commands","adminmenu.menu.server", f.colorYellow(), f.getShowText(), f.newChatComponent("hover_main_server_commands"),f.getRunCommand(), "/chatclick chatmenu adm_m_h_s",translator));
        }
        if(AdminMenu.settings.isWorldmenu()){
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_m_world_commands","adminmenu.menu.world", f.colorYellow(), f.getShowText(), f.newChatComponent("hover_main_world_commands"),f.getRunCommand(), "/chatclick chatmenu adm_m_h_w",translator));
        }
        if(AdminMenu.settings.isGroupmenu()){
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_m_group_commands" ,"adminmenu.menu.group", f.colorYellow(), f.getShowText(), f.newChatComponent("hover_main_group_commands"),f.getRunCommand(), "/chatclick chatmenu adm_m_h_g",translator));
        }
        EliteLib.getMenuManager().addMenu(addNavigation(mainMenu,translator));

        /////////////////////////////////////////////////////
        //                    Player Menu                  //
        /////////////////////////////////////////////////////

        if (AdminMenu.settings.isPlayermenu()){
            //Player menu part 1
            Menu player_00 = EliteLib.getMenuFactory().newMenu("adm_m_h_p", "adminmenu.menu.player_00", f.colorWhite(),translator);
            player_00.addEntry(getBreakLine());
            player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_kick", "adminmenu.menu.player.kick", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_kick_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_p_kick", translator));
            player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_ban","adminmenu.menu.player.ban", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_ban_hover"), f.getRunCommand(),"/chatclick chatmenu adm_m_h_p_ban" , translator));
            player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_gm","adminmenu.menu.player.gamemode", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_gm_hover"), f.getRunCommand(),"/chatclick chatmenu adm_m_h_p_gm" , translator));
            player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_kill","adminmenu.menu.player.kill", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_kill_hover"), f.getRunCommand(),"/acb true atl_h_p_kill adm_m_h_p true kill %p" , translator));
            player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_mute","adminmenu.menu.player.mute", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_mute_hover"), f.getRunCommand(),"/acb true atl_h_p_mute adm_m_h_p true mute %p" , translator));
            player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_gi","adminmenu.menu.player.give", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_gi_hover"), f.getRunCommand(),"/chatclick chatmenu adm_m_h_p_gi" , translator));
            player_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_tp","adminmenu.menu.player.tp", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_tp_hover"), f.getRunCommand(),"/chatclick chatmenu adm_m_h_p_tp" , translator));
            EliteLib.getMenuManager().addMenu(addNavigation(player_00, translator,"adminmenu.menu.player_01", "/chatclick chatmenu adm_m_h_p_01",null,null));

            //Player menu part 2
            Menu player_01 = EliteLib.getMenuFactory().newMenu("adm_m_h_p_01", "adminmenu.menu.player_01", f.colorWhite(),translator);
            player_01.addEntry(getBreakLine());
            player_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_op", "adminmenu.menu.player.op", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_op_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_p_op", translator));
            player_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_clr", "adminmenu.menu.player.clear", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_clr_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_p_clr", translator));
            player_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_xp", "adminmenu.menu.player.xp", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_xp_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_p_xp", translator));
            player_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_god", "adminmenu.menu.player.god", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_god_hover"), f.getRunCommand(), "/acb true atl_h_p_god adm_m_h_p_01 true god %p", translator));
            player_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_ef", "adminmenu.menu.player.effect", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_ef_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_p_ef", translator));
            player_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_lvl", "adminmenu.menu.player.lvl", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_lvl_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_p_lvl", translator));
            player_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_s", "adminmenu.menu.player.sound", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_s_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_p_s", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(player_01, translator, "adminmenu.menu.player_02", "/chatclick chatmenu adm_m_h_p_02", "adminmenu.menu.player_00", "/chatclick chatmenu adm_m_h_p"));

            //Player menu part 3
            Menu player_02 = EliteLib.getMenuFactory().newMenu("adm_m_h_p_02", "adminmenu.menu.player_02", f.colorWhite(),translator);
            player_02.addEntry(getBreakLine());
            player_02.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_ac", "adminmenu.menu.player.ac", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_ac_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_p_ac", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(player_02, translator, null,null, "adminmenu.menu.player_01", "/chatclick chatmenu adm_m_h_p_01"));

                //Kick menu
                Menu player_kick = EliteLib.getMenuFactory().newMenu("adm_m_h_p_kick", "adminmenu.menu.player.kick",f.colorWhite(),translator);
                player_kick.addEntry(getBreakLine());
                player_kick.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_kick_noreason", "adminmenu.player.kick.noreason",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_kick_noreason_hover"),f.getRunCommand(),"/acb true atl_h_p_kick adm_m_h_p_kick true kick %p",translator));
                player_kick.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_kick_reason", "adminmenu.player.kick.reason",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_kick_reason_hover"),f.getRunCommand(),"/acb true atl_h_p_kick adm_m_h_p_kick true kick %p %r",translator));
                player_kick.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_kick_customreason", "adminmenu.player.kick.customreason",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_kick_customreason_hover"),f.getSuggestCommand(),"/acb true atl_h_p_kick adm_m_h_p_kick true kick %p <reason>",translator));
                EliteLib.getMenuManager().addMenu(addNavigation(player_kick,translator,null,null,"adminmenu.menu.player_00","/chatclick chatmenu adm_m_h_p"));

                //Ban menu
                Menu player_ban = EliteLib.getMenuFactory().newMenu("adm_m_h_p_ban","adminmenu.menu.player.ban",f.colorWhite(),translator);
                player_ban.addEntry(getBreakLine());
                player_ban.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_ban_perm_noreason", "adminmenu.player.ban.perm.noreason", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_ban_perm_noreason_hover"), f.getRunCommand(), "/acb true atl_h_p_ban adm_m_h_p_ban true ban %p", translator));
                player_ban.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_ban_perm_reason", "adminmenu.player.ban.perm.reason",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_ban_reason_hover"),f.getRunCommand(),"/acb true atl_h_p_ban adm_m_h_p_ban true ban %p %re",translator));
                player_ban.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_ban_temp_noreason", "adminmenu.player.ban.temp.noreason",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_ban_noreason_hover"),f.getRunCommand(),"/acb true atl_h_p_ban adm_m_h_p_ban true ban %p noreason %t1",translator));
                player_ban.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_ban_temp_reason", "adminmenu.player.ban.temp.reason",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_ban_noreason_hover"),f.getRunCommand(),"/acb true atl_h_p_ban adm_m_h_p_ban true ban %p %re %t1",translator));
                player_ban.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_ban_unban", "adminmenu.player.ban.unban",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_ban_unban_hover"),f.getRunCommand(),"/acb true atl_h_p_ban adm_m_h_p_ban true unban %bp ",translator));
                EliteLib.getMenuManager().addMenu(addNavigation(player_ban,translator,null,null,"adminmenu.menu.player_00","/chatclick chatmenu adm_m_h_p"));

                //Gamemode menu
                Menu player_gamemode = EliteLib.getMenuFactory().newMenu("adm_m_h_p_gm","adminmenu.menu.player.gamemode",f.colorWhite(),translator);
                player_gamemode.addEntry(getBreakLine());
                player_gamemode.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_gm_surv","adminmenu.player.gamemode.survival",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_gm_surv_hover"),f.getRunCommand(),"/acb true atl_h_p_gm adm_m_h_p_gm true gamemode 0 %p",translator));
                player_gamemode.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_gm_crea","adminmenu.player.gamemode.creative",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_gm_crea_hover"),f.getRunCommand(),"/acb true atl_h_p_gm adm_m_h_p_gm true gamemode 1 %p",translator));
                player_gamemode.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_gm_adve","adminmenu.player.gamemode.adventure",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_gm_adve_hover"),f.getRunCommand(),"/acb true atl_h_p_gm adm_m_h_p_gm true gamemode 2 %p",translator));
                player_gamemode.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_gm_spec","adminmenu.player.gamemode.spectator",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_gm_spec_hover"),f.getRunCommand(),"/acb true atl_h_p_gm adm_m_h_p_gm true gamemode 3 %p",translator));
                EliteLib.getMenuManager().addMenu(addNavigation(player_gamemode,translator,null,null,"adminmenu.menu.player_00","/chatclick chatmenu adm_m_h_p"));

                //Op menu
                Menu player_op = EliteLib.getMenuFactory().newMenu("adm_m_h_p_op","adminmenu.menu.player.op",f.colorWhite(),translator);
                player_op.addEntry(getBreakLine());
                player_op.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_op_t","adminmenu.player.op.op",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_op_t_hover"),f.getRunCommand(),"/acb true atl_h_p_op adm_m_h_p_op true op %p",translator));
                player_op.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_op_f", "adminmenu.player.op.deop", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_op_f_hover"), f.getRunCommand(), "/acb true atl_h_p_op adm_m_h_p_op true deop %p", translator));
                EliteLib.getMenuManager().addMenu(addNavigation(player_op,translator,null,null,"adminmenu.menu.player_01","/chatclick chatmenu adm_m_h_p_01"));

                //XP menu
                Menu player_xp = EliteLib.getMenuFactory().newMenu("adm_m_h_p_xp","adminmenu.menu.player.xp",f.colorWhite(),translator);
                player_xp.addEntry(getBreakLine());
                player_xp.addEntry(EliteLib.getMenuFactory().newMenuEntry("100","adminmenu.player.xp.100",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_xp_100_hover"),f.getRunCommand(),"/acb true atl_h_p_xp adm_m_h_p_xp true xp 100 %p",translator));
                player_xp.addEntry(EliteLib.getMenuFactory().newMenuEntry("1000","adminmenu.player.xp.1000",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_xp_1000_hover"),f.getRunCommand(),"/acb true atl_h_p_xp adm_m_h_p_xp true xp 1000 %p",translator));
                player_xp.addEntry(EliteLib.getMenuFactory().newMenuEntry("10000","adminmenu.player.xp.100",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_xp_10000_hover"),f.getRunCommand(),"/acb true atl_h_p_xp adm_m_h_p_xp true xp 10000 %p",translator));
                player_xp.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_other","adminmenu.player.xp.other",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_xp_other_hover"),f.getRunCommand(),"/acb true atl_h_p_xp adm_m_h_p_xp true xp %a %p",translator));
                player_xp.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_custom","adminmenu.player.xp.custom",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_xp_custom_hover"),f.getRunCommand(),"/acb false atl_h_p_xp adm_m_h_p_xp true xp <amount> %p",translator));
                EliteLib.getMenuManager().addMenu(addNavigation(player_xp,translator,null,null,"adminmenu.menu.player_01","/chatclick chatmenu adm_m_h_p_01"));

                //Level menu
                Menu player_level = EliteLib.getMenuFactory().newMenu("adm_m_h_p_lvl","adminmenu.menu.player.lvl",f.colorWhite(),translator);
                player_level.addEntry(getBreakLine());
                player_level.addEntry(EliteLib.getMenuFactory().newMenuEntry("10","adminmenu.player.lvl.10",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_lvl_10_hover"),f.getRunCommand(),"/acb true atl_h_p_lvl adm_m_h_p_lvl true xp 10L %p",translator));
                player_level.addEntry(EliteLib.getMenuFactory().newMenuEntry("100","adminmenu.player.lvl.100",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_lvl_100_hover"),f.getRunCommand(),"/acb true atl_h_p_lvl adm_m_h_p_lvl true xp 100L %p",translator));
                player_level.addEntry(EliteLib.getMenuFactory().newMenuEntry("1000","adminmenu.player.lvl.1000",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_lvl_1000_hover"),f.getRunCommand(),"/acb true atl_h_p_lvl adm_m_h_p_lvl true xp 1000L %p",translator));
                player_level.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_other","adminmenu.player.lvl.other",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_lvl_other_hover"),f.getRunCommand(),"/acb true atl_h_p_lvl adm_m_h_p_lvl true xp %aL %p",translator));
                player_level.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_custom","adminmenu.player.lvl.custom",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_lvl_custom_hover"),f.getRunCommand(),"/acb false atl_h_p_lvl adm_m_h_p_lvl true xp <amount>L %p",translator));
                EliteLib.getMenuManager().addMenu(addNavigation(player_level,translator,null,null,"adminmenu.menu.player_01","/chatclick chatmenu adm_m_h_p_01"));

                //TP menu
                Menu player_tp = EliteLib.getMenuFactory().newMenu("adm_m_h_p_tp","adminmenu.menu.player.tp",f.colorWhite(),translator);
                player_tp.addEntry(getBreakLine());
                player_tp.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_tp_here","adminmenu.player.tp.here",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_tp_here_hover"),f.getRunCommand(),"/acb true atl_h_p_tp adm_m_h_p_tp true tp %p %c",translator));
                player_tp.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_tp_toplayer","adminmenu.player.tp.toplayer",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_tp_toplayer_hover"),f.getRunCommand(),"/acb true atl_h_p_tp adm_m_h_p_tp true tp %c %p",translator));
                player_tp.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_tp_playertoplayer","adminmenu.player.tp.playertoplayer",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_tp_playertoplayer_hover"),f.getRunCommand(),"/acb true atl_h_p_tp adm_m_h_p_tp true tp %p %p",translator));
                player_tp.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_tp_xyz","adminmenu.player.tp.xyz",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_tp_xyz_hover"),f.getRunCommand(),"/acb true atl_h_p_tp adm_m_h_p_tp true tp %c <x> <y> <z>",translator));
                player_tp.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_tp_spawn","adminmenu.player.tp.spawn",f.colorYellow(),f.getShowText(),f.newChatComponent("i_p_tp_spawn_hover"),f.getRunCommand(),"/spawn",translator));
                EliteLib.getMenuManager().addMenu(addNavigation(player_tp, translator, null, null, "adminmenu.menu.player_00", "/chatclick chatmenu adm_m_h_p"));

                //Clear menu
                Menu player_clear = EliteLib.getMenuFactory().newMenu("adm_m_h_p_clr","adminmenu.menu.player.clear",f.colorWhite(),translator);
                player_clear.addEntry(getBreakLine());
                player_clear.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_clr_pcomplete", "adminmenu.player.clear.pcomplete", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_clr_pcomplete_hover"), f.getRunCommand(), "/acb true atl_h_p_clr adm_m_h_p_clr true clear %p", translator));
                player_clear.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_clr_pselected", "adminmenu.player.clear.pselected", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_clr_pselected_hover"), f.getRunCommand(), "/acb true atl_h_p_clr adm_m_h_p_clr true clear %p %pi %a1",translator));
                player_clear.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_clr_ocomplete", "adminmenu.player.clear.ocomplete", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_clr_ocomplete_hover"), f.getRunCommand(), "/acb true atl_h_p_clr adm_m_h_p_clr true clear %c",translator));
                EliteLib.getMenuManager().addMenu(addNavigation(player_clear, translator, null, null, "adminmenu.menu.player_01", "/chatclick chatmenu adm_m_h_p_01"));

                //Give menu
                Menu player_give = EliteLib.getMenuFactory().newMenu("adm_m_h_p_gi","adminmenu.menu.player.give",f.colorWhite(),translator);
                player_give.addEntry(getBreakLine());
                player_give.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_gi_otheritem", "adminmenu.player.give.other.item", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_gi_otheritem_hover"), f.getRunCommand(), "/acb true atl_h_p_gi adm_m_h_p_gi true give %p %i1 %a", translator));
                player_give.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_gi_otherblock", "adminmenu.player.give.other.block", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_gi_otherblock_hover"), f.getRunCommand(), "/acb true atl_h_p_gi adm_m_h_p_gi true give %p %b1 %a", translator));
                player_give.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_gi_item", "adminmenu.player.give.self.item", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_gi_item_hover"), f.getRunCommand(), "/acb true atl_h_p_gi adm_m_h_p_gi true give %c %i1 %a", translator));
                player_give.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_gi_block", "adminmenu.player.give.self.block", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_gi_block_hover"), f.getRunCommand(), "/acb true atl_h_p_gi adm_m_h_p_gi true give %c %b1 %a", translator));
                EliteLib.getMenuManager().addMenu(addNavigation(player_give, translator, null, null, "adminmenu.menu.player_00", "/chatclick chatmenu adm_m_h_p"));

                //Effect menu
                Menu player_effect = EliteLib.getMenuFactory().newMenu("adm_m_h_p_ef","adminmenu.menu.player.effect",f.colorWhite(),translator);
                player_effect.addEntry(getBreakLine());
                player_effect.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_effect_give", "adminmenu.player.effect.give", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_effect_give_hover"), f.getRunCommand(), "/acb true atl_h_p_ef adm_m_h_p_ef true effect %p %ef %t2", translator));
                player_effect.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_effect_givea", "adminmenu.player.effect.give.advanced", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_effect_givea_hover"), f.getRunCommand(), "/acb true atl_h_p_ef adm_m_h_p_ef true effect %p %ef %t2 %a2 %tf", translator));
                player_effect.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_effect_clear", "adminmenu.player.effect.clear", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_effect_clear_hover"), f.getRunCommand(), "/acb true atl_h_p_ef adm_m_h_p_ef true effect %p clear", translator));
                EliteLib.getMenuManager().addMenu(addNavigation(player_effect, translator, null, null, "adminmenu.menu.player_01", "/chatclick chatmenu adm_m_h_p_01"));

                //Achievement menu
                Menu player_achievement = EliteLib.getMenuFactory().newMenu("adm_m_h_p_ac","adminmenu.menu.player.achievement",f.colorWhite(),translator);
                player_achievement.addEntry(getBreakLine());
                player_achievement.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_achievement_give", "adminmenu.player.achievement.give", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_achievement_give_hover"), f.getRunCommand(), "/acb true atl_h_p_ac adm_m_h_p_ac true achievement give %ac %p", translator));
                player_achievement.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_achievement_god", "adminmenu.player.achievement.god", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_achievement_god_hover"), f.getRunCommand(), "/acb true atl_h_p_ac adm_m_h_p_ac true achievement give * %p", translator));
                player_achievement.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_achievement_take", "adminmenu.player.achievement.take", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_achievement_take_hover"), f.getRunCommand(), "/acb true atl_h_p_ac adm_m_h_p_ac true achievement take %ac %p", translator));
                player_achievement.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_achievement_clear", "adminmenu.player.achievement.clear", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_achievement_clear_hover"), f.getRunCommand(), "/acb true atl_h_p_ac adm_m_h_p_ac true achievement take * %p", translator));
                EliteLib.getMenuManager().addMenu(addNavigation(player_achievement, translator, null, null, "adminmenu.menu.player_02", "/chatclick chatmenu adm_m_h_p_02"));

                //Sound menu
                Menu player_sound = EliteLib.getMenuFactory().newMenu("adm_m_h_p_s","adminmenu.menu.player.sound",f.colorWhite(),translator);
                player_sound.addEntry(getBreakLine());
                player_sound.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_sound_player", "adminmenu.player.sound.player", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_sound_player_hover"), f.getRunCommand(), "/acb true atl_h_p_s adm_m_h_p_s true playsound %so %p", translator));
                player_sound.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_p_sound_all", "adminmenu.player.sound.all", f.colorYellow(), f.getShowText(), f.newChatComponent("i_p_sound_all_hover"), f.getRunCommand(), "/acb true atl_h_p_s adm_m_h_p_s true playsound %so @a", translator));
                EliteLib.getMenuManager().addMenu(addNavigation(player_sound, translator, null, null, "adminmenu.menu.player_01", "/chatclick chatmenu adm_m_h_p_01"));
        }

        /////////////////////////////////////////////////////
        //                   Server Menu                   //
        /////////////////////////////////////////////////////

        if (AdminMenu.settings.isServermenu()) {
            //Server menu part 1
            Menu server_00 = EliteLib.getMenuFactory().newMenu("adm_m_h_s", "adminmenu.menu.server_00", f.colorWhite(), translator);
            server_00.addEntry(getBreakLine());
            server_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_s_stop", "adminmenu.server.stop", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_stop_hover"), f.getRunCommand(), "/stop", translator));
            server_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_s_reloadconfigs", "adminmenu.server.reloadconfigs", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_reloadconfigs_hover"), f.getRunCommand(), "/reload", translator));
            server_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_s_whl", "adminmenu.server.whitelist", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_whl_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_s_whl", translator));
            server_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_s_res", "adminmenu.server.reservelist", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_res_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_s_res", translator));
            server_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_s_t", "adminmenu.server.timeout", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_t_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_s_t", translator));
            server_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_s_world", "adminmenu.server.world", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_w_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_s_w", translator));
            server_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_s_plugin", "adminmenu.server.plugin", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_plugin_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_s_p", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(server_00, translator, "adminmenu.menu.server_01", "/chatclick chatmenu adm_m_h_s_01", null, null));

            //Server menu part 2
            Menu server_01 = EliteLib.getMenuFactory().newMenu("adm_m_h_s_01", "adminmenu.menu.server_01", f.colorWhite(), translator);
            server_01.addEntry(getBreakLine());
            server_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_s_d", "adminmenu.server.debug", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_d_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_s_d", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(server_01, translator, null, null, "adminmenu.menu.server_00", "/chatclick chatmenu adm_m_h_s"));

            //Whitelist menu
            Menu server_whitelist = EliteLib.getMenuFactory().newMenu("adm_m_h_s_whl", "adminmenu.menu.server.whitelist", f.colorWhite(), translator);
            server_whitelist.addEntry(getBreakLine());
            server_whitelist.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_addplayer", "adminmenu.server.whitelist.add", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_whl_add_hover"), f.getSuggestCommand(), "/whitelist add <player>", translator));
            server_whitelist.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_removeplayer", "adminmenu.server.whitelist.remove", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_whl_remove_hover"), f.getRunCommand(), "/acb true atl_h_s_whl adm_m_h_s_whl true whitelist remove %w", translator));
            server_whitelist.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_listplayer", "adminmenu.server.whitelist.list", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_whl_list_hover"), f.getRunCommand(), "/acb true atl_h_s_whl_l adm_m_h_s_whl true msg %w", translator));
            server_whitelist.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_reload", "adminmenu.server.whitelist.reload", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_whl_reload_hover"), f.getRunCommand(), "/whitelist reload", translator));
            server_whitelist.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_turnon", "adminmenu.server.whitelist.turnon", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_whl_turnon_hover"), f.getRunCommand(), "/whitelist on", translator));
            server_whitelist.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_turnoff", "adminmenu.server.whitelist.turnoff", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_whl_turnoff_hover"), f.getRunCommand(), "/whitelist off", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(server_whitelist, translator, null, null, "adminmenu.menu.server_00", "/chatclick chatmenu adm_m_h_s"));

            //Reservelist mennu
            Menu server_reservelist = EliteLib.getMenuFactory().newMenu("adm_m_h_s_res", "adminmenu.menu.server.reservelist", f.colorWhite(), translator);
            server_reservelist.addEntry(getBreakLine());
            server_reservelist.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_addplayer", "adminmenu.server.reservelist.add", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_res_add_hover"), f.getSuggestCommand(), "/reservelist add <player>", translator));
            server_reservelist.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_removeplayer", "adminmenu.server.reservelist.remove", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_res_remove_hover"), f.getRunCommand(), "/acb true atl_h_s_res adm_m_h_s_res true reservelist remove %r", translator));
            server_reservelist.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_listplayer", "adminmenu.server.reservelist.list", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_res_list_hover"), f.getRunCommand(), "/acb true atl_h_s_res adm_m_h_s_res true msg %r", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(server_reservelist, translator, null, null, "adminmenu.menu.server_00", "/chatclick chatmenu adm_m_h_s"));

            //Timeout menu
            Menu server_timeout = EliteLib.getMenuFactory().newMenu("adm_m_h_s_t", "adminmenu.menu.server.timeout", f.colorWhite(), translator);
            server_timeout.addEntry(getBreakLine());
            server_timeout.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_s_afktimeout", "adminmenu.server.timeout.set", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_afktimeout_hover"), f.getSuggestCommand(), "/setidletimeout <minutes>", translator));
            server_timeout.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_turnoff", "adminmenu.server.timeout.turnoff", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_afktimeout_disable_hover"), f.getRunCommand(), "/setidletimeout 0", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(server_timeout, translator, null, null, "adminmenu.menu.server_00", "/chatclick chatmenu adm_m_h_s"));

            //Createworld menu
            Menu server_world = EliteLib.getMenuFactory().newMenu("adm_m_h_s_w", "adminmenu.menu.server.world", f.colorWhite(), translator);
            server_world.addEntry(getBreakLine());
            server_world.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_s_w_create", "adminmenu.server.world.create", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_w_create_hover"), f.getSuggestCommand(), "/world create <worldName>", translator));
            server_world.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_s_w_delete", "adminmenu.server.world.create", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_w_delete_hover"), f.getRunCommand(), "/acb true atl_h_s_wd adm_m_h_s_w true world delete %wo", translator));
            server_world.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_s_w_load", "adminmenu.server.world.load", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_w_load_hover"), f.getSuggestCommand(), "/world load <worldName>", translator));
            server_world.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_s_w_unload", "adminmenu.server.world.unload", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_w_unload_hover"), f.getSuggestCommand(), "/world unload <worldName>", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(server_world, translator, null, null, "adminmenu.menu.server_00", "/chatclick chatmenu adm_m_h_s"));

            //Debugmode menu
            Menu server_debug = EliteLib.getMenuFactory().newMenu("adm_m_h_s_d", "adminmenu.menu.server.debug", f.colorWhite(), translator);
            server_debug.addEntry(getBreakLine());
            server_debug.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_s_d_start", "adminmenu.server.debug.start", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_d_start_hover"), f.getRunCommand(), "/debug start", translator));
            server_debug.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_s_d_stop", "adminmenu.server.debug.stop", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_d_stop_hover"), f.getRunCommand(), "/debug stop", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(server_debug, translator, null, null, "adminmenu.menu.server_01", "/chatclick chatmenu adm_m_h_s_01"));

            //Plugin menu
            Menu server_plugin = EliteLib.getMenuFactory().newMenu("adm_m_h_s_p", "adminmenu.menu.server.plugin", f.colorWhite(), translator);
            server_plugin.addEntry(getBreakLine());
            server_plugin.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_s_p_disable", "adminmenu.server.plugin.disable", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_p_disable_hover"), f.getRunCommand(), "/acb true atl_h_s_p adm_m_h_s_p true disableplugin %pl", translator));
            server_plugin.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_s_p_enable", "adminmenu.server.plugin.enable", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_p_enable_hover"), f.getRunCommand(), "/acb true atl_h_s_p adm_m_h_s_p true enableplugin %pl", translator));
            server_plugin.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_s_p_reload", "adminmenu.server.plugin.reload", f.colorYellow(), f.getShowText(), f.newChatComponent("i_s_p_reload_hover"), f.getRunCommand(), "/acb true atl_h_s_p adm_m_h_s_p true reloadplugin %pl", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(server_plugin, translator, null, null, "adminmenu.menu.server_00", "/chatclick chatmenu adm_m_h_s"));
        }
        /////////////////////////////////////////////////////
        //                    World Menu                   //
        /////////////////////////////////////////////////////

        if(AdminMenu.settings.isWorldmenu()) {

            //World menu part 1
            Menu world_00 = EliteLib.getMenuFactory().newMenu("adm_m_h_w", "adminmenu.menu.world_00", f.colorWhite(), translator);
            world_00.addEntry(getBreakLine());
            world_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_time", "adminmenu.world.time", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_time_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_time", translator));
            world_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_weather", "adminmenu.world.weather", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_weather_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_weather", translator));
            world_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_setspawn", "adminmenu.world.setspawn", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_setspawn_hover"), f.getRunCommand(), "/setspawn", translator));
            world_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_saveworld", "adminmenu.world.saveworld", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_saveworld_hover"), f.getRunCommand(), "/save-all", translator));
            world_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_autosave", "adminmenu.world.autosave", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_autosave_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_autosave", translator));
            world_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_kill", "adminmenu.world.kill", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_kill", translator));
            world_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_firespread", "adminmenu.world.firespread", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_firespread_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_firespread", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(world_00, translator, "adminmenu.menu.world_01", "/chatclick chatmenu adm_m_h_w_01", null, null));

            //World menu part 2
            Menu world_01 = EliteLib.getMenuFactory().newMenu("adm_m_h_w_01", "adminmenu.menu.world_01", f.colorWhite(), translator);
            world_01.addEntry(getBreakLine());
            world_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_entitydrops", "adminmenu.world.entitydrops", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_entitydrops_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_entitydrops", translator));
            world_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_mobloot", "adminmenu.world.mobloot", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_mobloot_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_mobloot", translator));
            world_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_daylightcycle", "adminmenu.world.daylightcycle", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_daylightcycle_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_daylightcycle", translator));
            world_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_mobspawning", "adminmenu.world.mobspawning", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_mobspawning_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_mobspawning", translator));
            world_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_blockdrops", "adminmenu.world.blockdrops", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_blockdrops_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_blockdrops", translator));
            world_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_keepinventory", "adminmenu.world.keepinventory", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_keepinventory_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_keepinventory", translator));
            world_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_mobgriefing", "adminmenu.world.mobgriefing", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_mobgriefing_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_mobgriefing", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(world_01, translator, "adminmenu.menu.world_02", "/chatclick chatmenu adm_m_h_w_02", "adminmenu.menu.world_00", "/chatclick chatmenu adm_m_h_w"));

            //World menu part 3
            Menu world_02 = EliteLib.getMenuFactory().newMenu("adm_m_h_w_02", "adminmenu.menu.world_02", f.colorWhite(), translator);
            world_02.addEntry(getBreakLine());
            world_02.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_logadmincommands", "adminmenu.world.logadmincommands", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_logadmincommands_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_logadmincommands", translator));
            world_02.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_naturalregeneration", "adminmenu.world.naturalregeneration", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_naturalregeneration_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_naturalregeneration", translator));
            world_02.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_tickspeed", "adminmenu.world.tickspeed", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_tickspeed_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_tickspeed", translator));
            world_02.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_reducedebuginfo", "adminmenu.world.reducedebuginfo", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_reducedebuginfo_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_reducedebuginfo", translator));
            world_02.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_commandfeedback", "adminmenu.world.commandfeedback", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_commandfeedback_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_commandfeedback", translator));
            world_02.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_showdeathmessages", "adminmenu.world.showdeathmessages", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_showdeathmessages_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_showdeathmessages", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(world_02, translator, null, null, "adminmenu.menu.world_01", "/chatclick chatmenu adm_m_h_w_01"));

            //Time menu
            Menu world_time = EliteLib.getMenuFactory().newMenu("adm_m_h_w_time", "adminmenu.menu.world.time", f.colorWhite(), translator);
            world_time.addEntry(getBreakLine());
            world_time.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_time_morning", "adminmenu.world.time.morning", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_time_morning_hover"), f.getRunCommand(), "/time set 0", translator));
            world_time.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_time_midday", "adminmenu.world.time.midday", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_time_midday_hover"), f.getRunCommand(), "/time set 6000", translator));
            world_time.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_time_evening", "adminmenu.world.time.evening", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_time_evening_hover"), f.getRunCommand(), "/time set 12000", translator));
            world_time.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_time_night", "adminmenu.world.time.night", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_time_night_hover"), f.getRunCommand(), "/time set 18000", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(world_time, translator, null, null, "adminmenu.menu.world_00", "/chatclick chatmenu adm_m_h_w"));

            //Weather menu
            Menu world_weather = EliteLib.getMenuFactory().newMenu("adm_m_h_w_weather", "adminmenu.menu.world.weather", f.colorWhite(), translator);
            world_weather.addEntry(getBreakLine());
            world_weather.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_weather_sun", "adminmenu.world.weather.sun", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_weather_sun_hover"), f.getRunCommand(), "/weather clear", translator));
            world_weather.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_weather_rain", "adminmenu.world.weather.rain", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_weather_rain_hover"), f.getRunCommand(), "/weather rain", translator));
            world_weather.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_weather_thunder", "adminmenu.world.weather.thunder", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_weather_thunder_hover"), f.getRunCommand(), "/weather thunder", translator));
            world_weather.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_weather_toggle", "adminmenu.world.weather.toggle", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_weather_toggle_hover"), f.getRunCommand(), "/toggledownfall", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(world_weather, translator, null, null, "adminmenu.menu.world_00", "/chatclick chatmenu adm_m_h_w"));

            //Autosave menu
            Menu world_autosave = EliteLib.getMenuFactory().newMenu("adm_m_h_w_autosave", "adminmenu.menu.world.autosave", f.colorWhite(), translator);
            world_autosave.addEntry(getBreakLine());
            world_autosave.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_turnon", "adminmenu.world.autosave.turnon", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_autosave_turnon_hover"), f.getRunCommand(), "/save-on", translator));
            world_autosave.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_turnoff", "adminmenu.world.autosave.turnoff", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_autosave_turnoff_hover"), f.getRunCommand(), "/save-off", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(world_autosave, translator, null, null, "adminmenu.menu.world_00", "/chatclick chatmenu adm_m_h_w"));

            //Kill menu
            Menu world_kill = EliteLib.getMenuFactory().newMenu("adm_m_h_w_kill", "adminmenu.menu.world.kill", f.colorWhite(), translator);
            world_kill.addEntry(getBreakLine());
            world_kill.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_kill_everything", "adminmenu.world.kill.everything", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_everything_hover"), f.getRunCommand(), "/kill @e", translator));
            world_kill.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_kill_almosteverything", "adminmenu.world.kill.almosteverything", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_almosteverything_hover"), f.getRunCommand(), "/kill @e[type=!Player]", translator));
            world_kill.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_kill_player", "adminmenu.world.kill.player", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_player_hover"), f.getRunCommand(), "/kill @a", translator));
            world_kill.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_kill_items", "adminmenu.world.kill.items", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_items_hover"), f.getRunCommand(), "/kill @e[type=Item]", translator));
            world_kill.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_kill_monster", "adminmenu.world.kill.monster", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_kill_monster_00", translator));
            world_kill.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_kill_animal", "adminmenu.world.kill.animals", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_animal_hover"), f.getRunCommand(), "/chatclick chatmenu adm_m_h_w_kill_animals_00", translator));
            world_kill.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_kill_villager", "adminmenu.world.kill.villager", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_villager_hover"), f.getRunCommand(), "/kill @e[type=Villager]", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(world_kill, translator, null, null, "adminmenu.menu.world_00", "/chatclick chatmenu adm_m_h_w"));

                Menu world_kill_monster_00 = EliteLib.getMenuFactory().newMenu("adm_m_h_w_kill_monster_00", "adminmenu.menu.world.kill.monster_00", f.colorWhite(), translator);
                world_kill_monster_00.addEntry(getBreakLine());
                world_kill_monster_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_everything", "adminmenu.world.kill.monster.everything", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_everything_hover"), f.getRunCommand(), "/killallamonsters", translator));
                world_kill_monster_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Skeleton", "adminmenu.world.kill.monster.skeleton", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_skeleton_hover"), f.getRunCommand(), "/kill @e[type=Skeleton]", translator));
                world_kill_monster_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Zombie", "adminmenu.world.kill.monster.zombie", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_zombie_hover"), f.getRunCommand(), "/kill @e[type=Zombie]", translator));
                world_kill_monster_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Creeper", "adminmenu.world.kill.monster.creeper", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_creeper_hover"), f.getRunCommand(), "/kill @e[type=Creeper]", translator));
                world_kill_monster_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Spider", "adminmenu.world.kill.monster.spider", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_spider_hover"), f.getRunCommand(), "/kill @e[type=Spider]", translator));
                world_kill_monster_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Slime", "adminmenu.world.kill.monster.slime", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_slime_hover"), f.getRunCommand(), "/kill @e[type=Slime]", translator));
                world_kill_monster_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Ghast", "adminmenu.world.kill.monster.ghast", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_ghast_hover"), f.getRunCommand(), "/kill @e[type=Ghast]", translator));
                EliteLib.getMenuManager().addMenu(addNavigation(world_kill_monster_00, translator, "adminmenu.menu.world.kill.monster_01", "/chatclick chatmenu adm_m_h_w_kill_monster_01", "adminmenu.menu.world.kill", "/chatclick chatmenu adm_m_h_w_kill"));

                Menu world_kill_monster_01 = EliteLib.getMenuFactory().newMenu("adm_m_h_w_kill_monster_01", "adminmenu.menu.world.kill.monster_01", f.colorWhite(), translator);
                world_kill_monster_01.addEntry(getBreakLine());
                world_kill_monster_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Pig Zombie", "adminmenu.world.kill.monster.pigzombie", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_pigzombie_hover"), f.getRunCommand(), "/kill @e[type=PigZombie]", translator));
                world_kill_monster_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Enderman", "adminmenu.world.kill.monster.enderman", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_enderman_hover"), f.getRunCommand(), "/kill @e[type=Enderman]", translator));
                world_kill_monster_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Cave Spider", "adminmenu.world.kill.monster.cavespider", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_cavespider_hover"), f.getRunCommand(), "/kill @e[type=CaveSpider]", translator));
                world_kill_monster_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Silverfish", "adminmenu.world.kill.monster.silverfish", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_silverfish_hover"), f.getRunCommand(), "/kill @e[type=Silverfish]", translator));
                world_kill_monster_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Blaze", "adminmenu.world.kill.monster.blaze", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_blaze_hover"), f.getRunCommand(), "/kill @e[type=Blaze]", translator));
                world_kill_monster_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Lava Slime", "adminmenu.world.kill.monster.lavaslime", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_lavaslime_hover"), f.getRunCommand(), "/kill @e[type=LavaSlime]", translator));
                world_kill_monster_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Ender Dragon", "adminmenu.world.kill.monster.enderdragon", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_enderdragon_hover"), f.getRunCommand(), "/kill @e[type=EnderDragon]", translator));
                EliteLib.getMenuManager().addMenu(addNavigation(world_kill_monster_01, translator, "adminmenu.menu.world.kill.monster_02", "/chatclick chatmenu adm_m_h_w_kill_monster_02", "adminmenu.menu.world.kill.monster_00", "/chatclick chatmenu adm_m_h_w_kill_monster_00"));

                Menu world_kill_monster_02 = EliteLib.getMenuFactory().newMenu("adm_m_h_w_kill_monster_02", "adminmenu.menu.world.kill.monster_02", f.colorWhite(), translator);
                world_kill_monster_02.addEntry(getBreakLine());
                world_kill_monster_02.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Wither", "adminmenu.world.kill.monster.wither", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_wither_hover"), f.getRunCommand(), "/kill @e[type=Wither]", translator));
                world_kill_monster_02.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Witch", "adminmenu.world.kill.monster.witch", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_witch_hover"), f.getRunCommand(), "/kill @e[type=Witch]", translator));
                world_kill_monster_02.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Endermite", "adminmenu.world.kill.monster.endermite", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_endermite_hover"), f.getRunCommand(), "/kill @e[type=Endermite]", translator));
                world_kill_monster_02.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Guardian", "adminmenu.world.kill.monster.guardian", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_guardian_hover"), f.getRunCommand(), "/kill @e[type=Guardian]", translator));
                world_kill_monster_02.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Killer Rabbit", "adminmenu.world.kill.monster.killerrabbit", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_monster_killerrabbit_hover"), f.getRunCommand(), "/kill @e[type=Rabbit]", translator));
                EliteLib.getMenuManager().addMenu(addNavigation(world_kill_monster_02, translator, null, null, "adminmenu.menu.world.kill.monster_01", "/chatclick chatmenu adm_m_h_w_kill_monster_01"));

                Menu world_kill_animals_00 = EliteLib.getMenuFactory().newMenu("adm_m_h_w_kill_animals_00", "adminmenu.menu.world.kill.animals_00", f.colorWhite(), translator);
                world_kill_animals_00.addEntry(getBreakLine());
                world_kill_animals_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_everything", "adminmenu.world.kill.animals.everything", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_animals_everything_hover"), f.getRunCommand(), "/killallanimals", translator));
                world_kill_animals_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Pig", "adminmenu.world.kill.animals.pig", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_animals_pig_hover"), f.getRunCommand(), "/kill @e[type=Pig]", translator));
                world_kill_animals_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Sheep", "adminmenu.world.kill.animals.sheep", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_animals_sheep_hover"), f.getRunCommand(), "/kill @e[type=Sheep]", translator));
                world_kill_animals_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Cow", "adminmenu.world.kill.animals.cow", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_animals_cow_hover"), f.getRunCommand(), "/kill @e[type=Cow]", translator));
                world_kill_animals_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Chicken", "adminmenu.world.kill.animals.chicken", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_animals_chicken_hover"), f.getRunCommand(), "/kill @e[type=Chicken]", translator));
                world_kill_animals_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Squid", "adminmenu.world.kill.animals.squid", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_animals_squid_hover"), f.getRunCommand(), "/kill @e[type=Squid]", translator));
                world_kill_animals_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Wolf", "adminmenu.world.kill.animals.wolf", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_animals_wolf_hover"), f.getRunCommand(), "/kill @e[type=Wolf]", translator));
                EliteLib.getMenuManager().addMenu(addNavigation(world_kill_animals_00, translator, "adminmenu.menu.world.kill.animals_01", "/chatclick chatmenu adm_m_h_w_kill_animals_01", "adminmenu.menu.world.kill", "/chatclick chatmenu adm_m_h_w_kill"));

                Menu world_kill_animals_01 = EliteLib.getMenuFactory().newMenu("adm_m_h_w_kill_animals_01", "adminmenu.menu.world.kill.animals_01", f.colorWhite(), translator);
                world_kill_animals_01.addEntry(getBreakLine());
                world_kill_animals_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Bat", "adminmenu.world.kill.animals.bat", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_animals_bat_hover"), f.getRunCommand(), "/kill @e[type=Bat]", translator));
                world_kill_animals_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Mooshroom", "adminmenu.world.kill.animals.mooshroom", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_animals_mooshroom_hover"), f.getRunCommand(), "/kill @e[type=Mooshroom]", translator));
                world_kill_animals_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Snow Golem", "adminmenu.world.kill.animals.snowgolem", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_animals_snowgolem_hover"), f.getRunCommand(), "/kill @e[type=SnowGolem]", translator));
                world_kill_animals_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Ozelot", "adminmenu.world.kill.animals.ozelot", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_animals_ozelot_hover"), f.getRunCommand(), "/kill @e[type=Ozelot]", translator));
                world_kill_animals_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Iron Golem", "adminmenu.world.kill.animals.irongolem", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_animals_irongolem_hover"), f.getRunCommand(), "/kill @e[type=IronGolem]", translator));
                world_kill_animals_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Horse", "adminmenu.world.kill.animals.horse", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_animals_horse_hover"), f.getRunCommand(), "/kill @e[type=Horse]", translator));
                world_kill_animals_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("- Rabbit", "adminmenu.world.kill.animals.rabbit", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_kill_animals_rabbit_hover"), f.getRunCommand(), "/kill @e[type=Rabbit]", translator));
                EliteLib.getMenuManager().addMenu(addNavigation(world_kill_animals_01, translator, null, null,"adminmenu.menu.world.kill.animals_00", "/chatclick chatmenu adm_m_h_w_kill_animals_00"));

            //Firespread Menu
            Menu world_firespread = getGameruleMenu("adm_m_h_w_firespread", "adminmenu.menu.world.firespread", "adminmenu.world.firespread", "i_w_firespread_on", "i_w_firespread_off", "i_w_firespread_status", "doFireTick", "/chatclick chatmenu adm_m_h_w", "adminmenu.menu.world_00", translator);
            EliteLib.getMenuManager().addMenu(world_firespread);

            //Daylightcycle Menu
            Menu world_daylightcycle = getGameruleMenu("adm_m_h_w_daylightcycle", "adminmenu.menu.world.daylightcycle", "adminmenu.world.daylightcycle", "i_w_daylightcycle_on", "i_w_daylightcycle_off", "i_w_daylightcycle_status", "doDaylightCycle", "/chatclick chatmenu adm_m_h_w_01", "adminmenu.menu.world_01", translator);
            EliteLib.getMenuManager().addMenu(world_daylightcycle);

            //Entitydrops Menu
            Menu world_entitydrops = getGameruleMenu("adm_m_h_w_entitydrops", "adminmenu.menu.world.entitydrops", "adminmenu.world.entitydrops", "i_w_entitydrops_on", "i_w_entitydrops_off", "i_w_entitydrops_status", "doEntityDrops", "/chatclick chatmenu adm_m_h_w_01", "adminmenu.menu.world_01", translator);
            EliteLib.getMenuManager().addMenu(world_entitydrops);

            //Mobloot Menu
            Menu world_mobloot = getGameruleMenu("adm_m_h_w_mobloot", "adminmenu.menu.world.mobloot", "adminmenu.world.mobloot", "i_w_mobloot_on", "i_w_mobloot_off", "i_w_mobloot_status", "doMobLoot", "/chatclick chatmenu adm_m_h_w_01", "adminmenu.menu.world_01", translator);
            EliteLib.getMenuManager().addMenu(world_mobloot);

            //Mobspawning Menu
            Menu world_mobspawning = getGameruleMenu("adm_m_h_w_mobspawning", "adminmenu.menu.world.mobspawning", "adminmenu.world.mobspawning", "i_w_mobspawning_on", "i_w_mobspawning_off", "i_w_mobspawning_status", "doMobSpawning", "/chatclick chatmenu adm_m_h_w_01", "adminmenu.menu.world_01", translator);
            EliteLib.getMenuManager().addMenu(world_mobspawning);

            //Blockdrops Menu
            Menu world_blockdrops = getGameruleMenu("adm_m_h_w_blockdrops", "adminmenu.menu.world.blockdrops", "adminmenu.world.blockdrops", "i_w_blockdrops_on", "i_w_blockdrops_off", "i_w_blockdrops_status", "doTileDrops", "/chatclick chatmenu adm_m_h_w_01", "adminmenu.menu.world_01", translator);
            EliteLib.getMenuManager().addMenu(world_blockdrops);

            //Keepinventory Menu
            Menu world_keepinventory = getGameruleMenu("adm_m_h_w_keepinventory", "adminmenu.menu.world.keepinventory", "adminmenu.world.keepinventory", "i_w_keepinventory_on", "i_w_keepinventory_off", "i_w_keepinventory_status", "keepInventory", "/chatclick chatmenu adm_m_h_w_01", "adminmenu.menu.world_01", translator);
            EliteLib.getMenuManager().addMenu(world_keepinventory);

            //Mobgriefing Menu
            Menu world_mobgriefing = getGameruleMenu("adm_m_h_w_mobgriefing", "adminmenu.menu.world.mobgriefing", "adminmenu.world.mobgriefing", "i_w_mobgriefing_on", "i_w_mobgriefing_off", "i_w_mobgriefing_status", "mobGriefing", "/chatclick chatmenu adm_m_h_w_01", "adminmenu.menu.world_01", translator);
            EliteLib.getMenuManager().addMenu(world_mobgriefing);

            //Logadmincommands Menu
            Menu world_logadmincommands = getGameruleMenu("adm_m_h_w_logadmincommands", "adminmenu.menu.world.logadmincommands", "adminmenu.world.logadmincommands", "i_w_logadmincommands_on", "i_w_logadmincommands_off", "i_w_logadmincommands_status", "logAdminCommands", "/chatclick chatmenu adm_m_h_w_02", "adminmenu.menu.world_02", translator);
            EliteLib.getMenuManager().addMenu(world_logadmincommands);

            //Naturalregeneration Menu
            Menu world_naturalregeneration = getGameruleMenu("adm_m_h_w_naturalregeneration", "adminmenu.menu.world.naturalregeneration", "adminmenu.world.naturalregeneration", "i_w_naturalregeneration_on", "i_w_naturalregeneration_off", "i_w_naturalregeneration_status", "naturalRegeneration", "/chatclick chatmenu adm_m_h_w_02", "adminmenu.menu.world_02", translator);
            EliteLib.getMenuManager().addMenu(world_naturalregeneration);

            //Reducedebuginfo Menu
            Menu world_reducedebuginfo = getGameruleMenu("adm_m_h_w_reducedebuginfo", "adminmenu.menu.world.reducedebuginfo", "adminmenu.world.reducedebuginfo", "i_w_reducedebuginfo_on", "i_w_reducedebuginfo_off", "i_w_reducedebuginfo_status", "reducedDebugInfo", "/chatclick chatmenu adm_m_h_w_02", "adminmenu.menu.world_02", translator);
            EliteLib.getMenuManager().addMenu(world_reducedebuginfo);

            //Commandfeedback Menu
            Menu world_commandfeedback = getGameruleMenu("adm_m_h_w_commandfeedback", "adminmenu.menu.world.commandfeedback", "adminmenu.world.commandfeedback", "i_w_commandfeedback_on", "i_w_commandfeedback_off", "i_w_commandfeedback_status", "sendCommandFeedback", "/chatclick chatmenu adm_m_h_w_02", "adminmenu.menu.world_02", translator);
            EliteLib.getMenuManager().addMenu(world_commandfeedback);

            //Showdeathmessages Menu
            Menu world_showdeathmessages = getGameruleMenu("adm_m_h_w_showdeathmessages", "adminmenu.menu.world.showdeathmessages", "adminmenu.world.showdeathmessages", "i_w_showdeathmessages_on", "i_w_showdeathmessages_off", "i_w_showdeathmessages_status", "showDeathMessages", "/chatclick chatmenu adm_m_h_w_02", "adminmenu.menu.world_02", translator);
            EliteLib.getMenuManager().addMenu(world_showdeathmessages);

            //Randomtickspeed menu
            Menu world_tickspeed = EliteLib.getMenuFactory().newMenu("adm_m_h_w_tickspeed", "adminmenu.menu.world.tickspeed", f.colorWhite(), translator);
            world_tickspeed.addEntry(getBreakLine());
            world_tickspeed.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_tickspeed_default", "adminmenu.world.tickspeed.default", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_tickspeed_default_hover"), f.getRunCommand(), "/gamerule randomTickSpeed 3", translator));
            world_tickspeed.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_turnoff", "adminmenu.world.tickspeed.turnoff", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_tickspeed_turnoff_hover"), f.getRunCommand(), "/gamerule randomTickSpeed 0", translator));
            world_tickspeed.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_tickspeed_status", "adminmenu.world.tickspeed.status", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_tickspeed_status_hover"), f.getRunCommand(), "/gamerule randomTickSpeed", translator));
            world_tickspeed.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_w_tickspeed_set", "adminmenu.world.tickspeed.set", f.colorYellow(), f.getShowText(), f.newChatComponent("i_w_tickspeed_set_hover"), f.getRunCommand(), "/acb true atl_h_w_t adm_m_h_w_tickspeed false gamerule randomTickSpeed %a", translator));
            EliteLib.getMenuManager().addMenu(addNavigation(world_tickspeed, translator, null, null, "adminmenu.menu.world_02", "/chatclick chatmenu adm_m_h_w_02"));

        }

        /////////////////////////////////////////////////////
        //                    Group Menu                   //
        /////////////////////////////////////////////////////

        Menu group_00 = EliteLib.getMenuFactory().newMenu("adm_m_h_g", "adminmenu.menu.group_00", f.colorWhite(), translator);
        group_00.addEntry(getBreakLine());
        group_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_addplayer", "adminmenu.group.addplayer", f.colorYellow(), f.getShowText(), f.newChatComponent("i_g_addplayer_hover"), f.getRunCommand(), "/acb true atl_h_gp adm_m_h_g true playermod add %p %g", translator));
        group_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_removeplayer", "adminmenu.group.removeplayer", f.colorYellow(), f.getShowText(), f.newChatComponent("i_g_removeplayer_hover"), f.getRunCommand(), "/acb true atl_h_gp adm_m_h_g true playermod remove %p %g", translator));
        group_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_g_creategroup", "adminmenu.group.create", f.colorYellow(), f.getShowText(), f.newChatComponent("i_g_creategroup_hover"), f.getSuggestCommand(), "/groupmod add <name>", translator));
        group_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_g_deletegroup", "adminmenu.group.delete", f.colorYellow(), f.getShowText(), f.newChatComponent("i_g_deletegroup_hover"), f.getRunCommand(), "/acb true atl_h_gp adm_m_h_g true groupmod remove %g", translator));
        group_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_g_listgroup", "adminmenu.group.list", f.colorYellow(), f.getShowText(), f.newChatComponent("i_g_listgroup_hover"), f.getRunCommand(), "/groupmod list", translator));
        group_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_g_renamegroup", "adminmenu.group.rename", f.colorYellow(), f.getShowText(), f.newChatComponent("i_g_renamegroup_hover"), f.getRunCommand(), "/acb false atl_h_gp adm_m_h_g true groupmod rename %g <newName>", translator));
        group_00.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_g_permission_add", "adminmenu.group.permission.add", f.colorYellow(), f.getShowText(), f.newChatComponent("i_g_permission_add_hover"), f.getRunCommand(), "/acb false atl_h_gp adm_m_h_g true groupmod permission add %g <permission>", translator));

        EliteLib.getMenuManager().addMenu(addNavigation(group_00, translator, "adminmenu.menu.group_01", "/chatclick chatmenu adm_m_h_g_01", null,null));

        Menu group_01 = EliteLib.getMenuFactory().newMenu("adm_m_h_g_01", "adminmenu.menu.group_01", f.colorWhite(), translator);
        group_01.addEntry(getBreakLine());
        group_01.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_g_permission_remove", "adminmenu.group.permission.remove", f.colorYellow(), f.getShowText(), f.newChatComponent("i_g_permission_remove_hover"), f.getRunCommand(), "/acb true atl_h_gp adm_m_h_g_01 true groupmod permission remove %g %pg", translator));
        EliteLib.getMenuManager().addMenu(addNavigation(group_01, translator, null,null, "adminmenu.menu.group_00", "/chatclick chatmenu adm_m_h_g_00"));

    }

    public static ChatComponent getHyphen (String lang){
        return f.newChatComponent("- ").appendSibling(f.newChatComponent(lang));
    }

    public static Menu addNavigation(Menu menu,LocaleHelper translator,String permissionForward, String commandForward, String permissionBack, String commandBack){
        
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

    public static Menu addNavigation(Menu menu,LocaleHelper translator){
        menu.addEntry(getBreakLine());
        menu.addEntry(new Exit(translator).getItem());
        menu.addEntry(EliteLib.getMenuFactory().newBlankLine());
        return menu;
    }

    public static MenuEntry getBreakLine(){
        return EliteLib.getMenuFactory().newMenuEntry("============================");
    }

    public static Menu getGameruleMenu(String menuName, String menuPermission, String itemPermission, String onHover, String offHover, String statusHover, String gameRule, String commandBack, String permissionBack, LocaleHelper translator){
        Menu menu = EliteLib.getMenuFactory().newMenu(menuName,menuPermission, f.colorWhite(),translator);
        menu.addEntry(getBreakLine());
        menu.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_turnon", itemPermission + ".turnon", f.colorYellow(), f.getShowText(), f.newChatComponent(onHover + "_hover"), f.getRunCommand(), "/gamerule " + gameRule + " true", translator));
        menu.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_turnoff", itemPermission + ".turnoff", f.colorYellow(), f.getShowText(), f.newChatComponent(offHover + "_hover"), f.getRunCommand(), "/gamerule " + gameRule + " false", translator));
        menu.addEntry(EliteLib.getMenuFactory().newMenuEntry("i_c_status", itemPermission + ".status", f.colorYellow(), f.getShowText(), f.newChatComponent(statusHover + "_hover"), f.getRunCommand(), "/gamerule " + gameRule, translator));
        return addNavigation(menu,translator,null,null,permissionBack,commandBack);
    }
}
