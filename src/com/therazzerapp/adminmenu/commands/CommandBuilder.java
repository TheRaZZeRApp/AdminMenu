package com.therazzerapp.adminmenu.commands;

import com.therazzerapp.adminmenu.items.Back;
import com.therazzerapp.adminmenu.items.Exit;
import com.therazzerapp.adminmenu.items.Refresh;
import com.therazzerapp.adminmenu.menus.PlayerList;
import de.myelitecraft.elitelib.api.EliteLib;
import de.myelitecraft.elitelib.api.commands.Arg;
import de.myelitecraft.elitelib.api.commands.CommandMeta;
import de.myelitecraft.elitelib.api.commands.PlayerCommand;
import de.myelitecraft.elitelib.api.menu.Menu;
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

    private final String[] parameters = {"%p","%w","%r","%a","%a1","%a2","%ac","%so","%c","%t1","%t2","%i","%b","%b1","%pg","%pl","%g","%gp","%pi","%ef","%tf"};

    public CommandBuilder(CommandOwner owner, LocaleHelper translator) {
        super(new CommandMeta(new String[]{"commandbuilder", "cbuilder"}, new String[]{"adminmenu.command.commandbuilder"}, "Runs the command builder.", "/cbuilder <runCMD> <headline> <back> <refreshAble> <command> [%params]", 4), owner, translator);
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
                    para = strings[i];
                }
            }
        }

        player.message(command);

        if(para.equals("") && runCMD){
            player.executeCommand(new String[]{command});
        } else if (para.equals("")){
            player.chat(command);
        } else {

            ChatComponentFactory f = Canary.factory().getChatComponentFactory();
            player.message("\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + translator.localeTranslate(headline, player.getLocale()).replaceAll("_", " ") + "\n============================");

            player.sendChatComponent(getMenu(para, "commandbuilder " + runCMD + " " + headline + " " + back + " " + command));

            if(refreshAble){
                ChatComponent cCRefresh = f.newChatComponent(translator.localeTranslate("item_name_const_refresh",player.getLocale()));
                cCRefresh.getChatStyle().setColor(f.colorYellow());
                cCRefresh.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), "/commandbuilder " + runCMD + " " + headline + " " + back + " " + refreshAble + " " + command));
                cCRefresh.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(),f.newChatComponent(translator.localeTranslate("item_name_const_refresh_hover", player.getLocale()))));
                player.sendChatComponent(cCRefresh);
            }

            ChatComponent cCBack = f.newChatComponent(translator.localeTranslate("item_name_const_back", player.getLocale()));
            cCBack.getChatStyle().setColor(f.colorYellow());
            cCBack.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), "/chatclick chatmenu " + back));
            cCBack.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(),f.newChatComponent(translator.localeTranslate("item_name_const_back_hover", player.getLocale()))));
            player.sendChatComponent(cCBack);

            player.message("============================");

            ChatComponent cCExit = f.newChatComponent(translator.localeTranslate("item_name_const_close", player.getLocale()));
            cCExit.getChatStyle().setColor(f.colorYellow());
            cCExit.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), "/adminmenu exit"));
            cCExit.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(),f.newChatComponent(translator.localeTranslate("item_name_const_exit_hover", player.getLocale()))));
            player.sendChatComponent(cCExit);

            player.message("\n");
        }

    }

    private ChatComponent getMenu(String para, String command){

        if(para.equals(parameters[0])){
            return PlayerList.getBody("Click to choose a player",command);
        }


        return null;

    }
}
