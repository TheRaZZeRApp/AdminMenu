package com.therazzerapp.adminmenu.commands;

import com.therazzerapp.adminmenu.items.Back;
import com.therazzerapp.adminmenu.items.Exit;
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
        super(new CommandMeta(new String[]{"commandbuilder","cbuilder"},new String[]{"adminmenu.command.commandbuilder"},"Runs the command builder.", "/cbuilder <runCMD> <headline> <back> <command> [%params]",4,0), owner, translator);
    }

    @Override
    protected void execute(Player player, Map<Arg, String[]> map, String[] strings, boolean b) {

        boolean runCMD = false;
        String para = "";
        String headline = strings[1];
        String back = strings[2];
        String command = "";

        if(strings[0].equals("true")){
            runCMD = true;
        }


        for (int i = 3; i < strings.length; i++) {
            command += strings[i] + " ";
            for (int j = 0; j < parameters.length; j++) {
                if(strings[i].equals(parameters[j]) && para.equals("")){
                    para = strings[i];
                }
            }
        }

        if(para.equals("") && runCMD){
            player.executeCommand(new String[]{command});
        } else if (para.equals("")){
            System.out.println(command);
            player.chat(command);
        } else {
            ChatComponentFactory f = Canary.factory().getChatComponentFactory();
            Menu mainMenu = EliteLib.getMenuFactory().newMenu(headline + " Menu", "adminmenu.menu.main", f.colorWhite());
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("============================"));
            player.sendChatComponent(getMenu(para, "/cbuilder " + runCMD + " " + headline + " " + back + " " + command));
            mainMenu.addEntry(EliteLib.getMenuFactory().newMenuEntry("============================"));
            mainMenu.addEntry(new Back("adminmenu.command.admin","/chatclick chatmenu " + back,translator).getItem());
            mainMenu.addEntry(new Exit("Click to exit the menu!",translator).getItem());
        }


    }

    private ChatComponent getMenu(String para, String command){

        if(para.equals(parameters[0])){
            return PlayerList.getBody("Click to choose a player",command);
        }


        return null;

    }
}
