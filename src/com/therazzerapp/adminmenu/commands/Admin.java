package com.therazzerapp.adminmenu.commands;

import de.myelitecraft.elitelib.api.EliteLib;
import de.myelitecraft.elitelib.api.commands.Arg;
import de.myelitecraft.elitelib.api.commands.CommandMeta;
import de.myelitecraft.elitelib.api.commands.PlayerCommand;
import de.myelitecraft.elitelib.api.menu.Menu;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.commandsys.CommandOwner;
import net.visualillusionsent.utils.LocaleHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 08/04/2015
 * Time: 16:04 PM
 * Package: com.therazzerapp.adminmenu.commands
 * E-Mail: rezzer101@googlemail.com
 */

public class Admin extends PlayerCommand{

    private final List<Player> playersInMenu = new ArrayList<>();

    public Admin(CommandOwner owner, LocaleHelper translator) {
        super(new CommandMeta(new String[]{"admin","adminmenu","menuadmin"},new String[]{"adminmenu.command.admin"},"Opens the admin menu.", "/admin ",0,0), owner, translator);
    }

    @Override
    protected void execute(Player player, Map<Arg, String[]> map, String[] strings, boolean b) {
        playersInMenu.add(player);
        Menu main = EliteLib.getMenuManager().getMenu("adm_m_h_main");
        player.message("\n\n\n\n\n\n\n\n\n\n\n\n");
        main.showMenu(player);
    }
}
