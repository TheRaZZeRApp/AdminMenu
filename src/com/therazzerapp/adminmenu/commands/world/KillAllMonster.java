package com.therazzerapp.adminmenu.commands.world;

import de.myelitecraft.elitelib.api.commands.Arg;
import de.myelitecraft.elitelib.api.commands.CommandMeta;
import de.myelitecraft.elitelib.api.commands.PlayerCommand;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.entity.living.monster.EntityMob;
import net.canarymod.commandsys.CommandOwner;
import net.visualillusionsent.utils.LocaleHelper;

import java.util.Map;

/**
 * Project: AdminMenue
 * User: Pual
 * Date: 05/02/2015
 * Time: 19:07 PM
 * Package: com.therazzerapp.adminmenue.commands.world
 */

public class KillAllMonster extends PlayerCommand{

    public KillAllMonster(CommandOwner owner, LocaleHelper translator) {
        super(new CommandMeta(new String[]{"killallamonsters"},new String[]{"adminmenu.command.killallamonsters"},"Kills every monster in the current world.", "/killallmonsters",0,0), owner, translator);
    }

    @Override
    protected void execute(Player player, Map<Arg, String[]> map, String[] strings, boolean b) {
        for (EntityMob mob : player.getWorld().getMobList()){
            mob.kill();
        }
    }
}
