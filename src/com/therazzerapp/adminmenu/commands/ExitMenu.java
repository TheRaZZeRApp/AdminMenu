package com.therazzerapp.adminmenu.commands;

import com.therazzerapp.adminmenu.AdminMenu;
import de.myelitecraft.elitelib.api.commands.Arg;
import de.myelitecraft.elitelib.api.commands.CommandMeta;
import de.myelitecraft.elitelib.api.commands.PlayerCommand;
import net.canarymod.Canary;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.commandsys.CommandOwner;
import net.visualillusionsent.utils.LocaleHelper;

import java.util.Map;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 02/05/2015
 * Time: 21:46 PM
 * Package: com.therazzerapp.adminmenu.commands
 * E-Mail: rezzer101@googlemail.com
 */

public class ExitMenu extends PlayerCommand{
    public ExitMenu(CommandOwner owner, LocaleHelper translator) {
        super(new CommandMeta(new String[]{"exit"},new String[]{"adminmenu.command.exit"},"Exit the admin menu.", "/admin exit",0,1,"admin"), owner, translator);
    }

    @Override
    protected void execute(Player player, Map<Arg, String[]> map, String[] strings, boolean b) {

        player.message("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        if(AdminMenu.settings.isMuteChatInMenu()){
            ChatComponentFactory f = Canary.factory().getChatComponentFactory();
            player.showTitle(f.newChatComponent(translator.localeTranslate("extras_chaton",player.getLocale())));
        }

    }
}
