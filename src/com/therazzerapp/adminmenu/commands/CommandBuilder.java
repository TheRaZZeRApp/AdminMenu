package com.therazzerapp.adminmenu.commands;

import com.therazzerapp.adminmenu.menus.*;
import de.myelitecraft.elitelib.api.commands.Arg;
import de.myelitecraft.elitelib.api.commands.CommandMeta;
import de.myelitecraft.elitelib.api.commands.PlayerCommand;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.commandsys.CommandOwner;
import net.visualillusionsent.utils.LocaleHelper;

import java.util.Map;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 03/05/2015
 * Time: 16:20 PM
 * Package: com.therazzerapp.adminmenu.commands
 * E-Mail: rezzer101@googlemail.com
 */

public class CommandBuilder extends PlayerCommand {

    //                                    0     1    2   3     4     5     6      7    8   9     10     11   12   13    14    15    16   17    18    19    20   21    22     23
    private final String[] parameters = {"%p","%w","%r","%a","%a1","%a2","%ac","%so","%c","%t1","%t2","%i","%b","%b1","%pg","%pl","%g","%gp","%pi","%ef","%tf","%bp","%wo","%re"};

    public CommandBuilder(CommandOwner owner, LocaleHelper translator) {
        super(new CommandMeta(new String[]{"commandbuilder", "cbuilder", "acb"}, new String[]{"adminmenu.command.commandbuilder"}, "Runs the command builder.", "/cbuilder <runCMD> <headline> <back> <refreshAble> <command> [%params]", 4), owner, translator);
    }

    @Override
    protected void execute(Player player, Map<Arg, String[]> map, String[] strings, boolean b) {

        boolean runCMD = false;
        String para = "";
        String headline = strings[1];
        String back = strings[2];
        String command = "";
        boolean refreshAble = false;

        if(strings[0].equals("true")){
            runCMD = true;
        }

        if(strings[3].equals("true")){
            refreshAble = true;
        }


        for (int i = 4; i < strings.length; i++) {
            command += strings[i] + " ";
            for (int j = 0; j < parameters.length; j++) {
                if(strings[i].equals(parameters[j]) && para.equals("")){
                    para = parameters[j];
                    break;
                }
            }
            if(para.equals("")) {
                for (int j = 0; j < parameters.length; j++) {
                    if (strings[i].startsWith(parameters[j]) && para.equals("")){
                        para = parameters[j];
                        break;
                    }
                }
            }
        }


        if (para.equals(parameters[8])){
            command = command.replaceFirst(parameters[8],player.getName());
            player.executeCommand(new String[]{"acb " + runCMD + " " + headline + " " + back + " " + refreshAble + " " + command});
            return;
        }

        if(para.isEmpty() && runCMD){
            player.executeCommand(new String[]{command});
        } else if (para.isEmpty()){
            ChatComponentFactory f = Canary.factory().getChatComponentFactory();

            ChatComponent cCText = f.newChatComponent(translator.localeTranslate("cbuilder_generatedtext",player.getLocale()) + "\n============================\n");

            ChatComponent cCCommand = f.newChatComponent("/" + command);
            cCCommand.getChatStyle().setChatClickEvent(f.newClickEvent(f.getSuggestCommand(),"/" + command));
            cCCommand.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(translator.localeTranslate("cbuilder_runcommand", player.getLocale()))));
            cCCommand.getChatStyle().setColor(f.colorYellow());
            player.sendChatComponent(cCText.appendSibling(cCCommand));
        } else {

            ChatComponentFactory f = Canary.factory().getChatComponentFactory();
            player.message("\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + translator.localeTranslate(headline, player.getLocale()) + "\n============================");

            player.sendChatComponent(getMenu(para, "acb " + runCMD + " " + headline + " " + back + " " + refreshAble + " " + command, player));

            if(refreshAble){
                ChatComponent cCRefresh = f.newChatComponent(translator.localeTranslate("i_c_refresh",player.getLocale()));
                cCRefresh.getChatStyle().setColor(f.colorYellow());
                cCRefresh.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), "/acb " + runCMD + " " + headline + " " + back + " " + refreshAble + " " + command));
                cCRefresh.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(),f.newChatComponent(translator.localeTranslate("i_c_refresh_hover", player.getLocale()))));
                player.sendChatComponent(cCRefresh);
            }

            ChatComponent cCBack = f.newChatComponent("<= " + translator.localeTranslate("i_c_back", player.getLocale()));
            cCBack.getChatStyle().setColor(f.colorYellow());
            cCBack.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), "/chatclick chatmenu " + back));
            cCBack.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(),f.newChatComponent(translator.localeTranslate("i_c_back_hover", player.getLocale()))));
            player.sendChatComponent(cCBack);

            player.message("============================");

            ChatComponent cCExit = f.newChatComponent(translator.localeTranslate("i_c_close", player.getLocale()));
            cCExit.getChatStyle().setColor(f.colorYellow());
            cCExit.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), "/admin exit"));
            cCExit.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(),f.newChatComponent(translator.localeTranslate("i_c_exit_hover", player.getLocale()))));
            player.sendChatComponent(cCExit);

            player.message("\n");
        }

    }

    private ChatComponent getMenu(String para, String command, Player player){

        if(para.equals(parameters[0])){
            return PlayerList.getBody(translator.localeTranslate("autolist_hover_player",player.getLocale()),command,player,translator);
        } else if (para.equals(parameters[1])){
            return WhiteList.getBody(translator.localeTranslate("autolist_hover_player",player.getLocale()),command,player,translator);
        } else if (para.equals(parameters[2])){
            return ReserveList.getBody(translator.localeTranslate("autolist_hover_player", player.getLocale()), command,player,translator);
        } else if (para.equals(parameters[3])){
            return AmountList00.getBody(translator.localeTranslate("autolist_hover_amount", player.getLocale()), command);
        } else if (para.equals(parameters[4])){
            return AmountList01.getBody(translator.localeTranslate("autolist_hover_amount", player.getLocale()), command);
        } else if (para.equals(parameters[5])){
            return AmountList02.getBody(translator.localeTranslate("autolist_hover_amount", player.getLocale()), command);
        } else if (para.equals(parameters[6])){
            return AchievementList.getBody(translator.localeTranslate("autolist_hover_achievement", player.getLocale()), command);
        } else if (para.equals(parameters[7])){
            return SoundList.getBody(translator.localeTranslate("autolist_hover_sound", player.getLocale()), command);
        } else if (para.equals(parameters[9])){
            return TimeList00.getBody(translator.localeTranslate("autolist_hover_time", player.getLocale()), command);
        } else if (para.equals(parameters[10])){
            return TimeList01.getBody(translator.localeTranslate("autolist_hover_time", player.getLocale()), command);
        } else if (para.equals(parameters[11])){
            //todo ka was das ist
        } else if (para.equals(parameters[12])){
            //todo ka was das ist
        } else if (para.equals(parameters[13])){
            return BlockList.getBody(translator.localeTranslate("autolist_hover_block", player.getLocale()), command);
        } else if (para.equals(parameters[14])){
            return GroupPermissionList.getBody(translator.localeTranslate("autolist_hover_permission", player.getLocale()), command);
        } else if (para.equals(parameters[15])){
            return PluginList.getBody(translator.localeTranslate("autolist_hover_plugins", player.getLocale()), command,player,translator);
        } else if (para.equals(parameters[16])){
            return GroupList.getBody(translator.localeTranslate("autolist_hover_group", player.getLocale()), command, player,translator);
        } else if (para.equals(parameters[17])){
            return PlayerGroupsList.getBody(translator.localeTranslate("autolist_hover_block", player.getLocale()), command);
        } else if (para.equals(parameters[18])){
            return BlockList.getBody(translator.localeTranslate("autolist_hover_group", player.getLocale()), command);
        } else if (para.equals(parameters[19])){
            return EffectList.getBody(translator.localeTranslate("autolist_hover_effect", player.getLocale()), command);
        } else if (para.equals(parameters[20])){
            return TrueFalseList.getBody(translator.localeTranslate("autolist_hover_tf", player.getLocale()), command,player,translator);
        } else if (para.equals(parameters[21])){
            return BannedPlayerList.getBody(translator.localeTranslate("autolist_hover_player", player.getLocale()), command, player,translator);
        } else if (para.equals(parameters[22])){
            return WorldList.getBody(translator.localeTranslate("autolist_hover_world", player.getLocale()), command, player,translator);
        } else if (para.equals(parameters[23])){
            return ReasonList.getBody(translator.localeTranslate("autolist_hover_reason", player.getLocale()), command, player);
        }

        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        return f.newChatComponent(translator.localeTranslate("error_cbuilder_unknownparameter",player.getLocale()));

    }
}
