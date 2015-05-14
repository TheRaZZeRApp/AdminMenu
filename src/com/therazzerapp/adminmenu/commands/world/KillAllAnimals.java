package com.therazzerapp.adminmenu.commands.world;

import de.myelitecraft.elitelib.api.commands.Arg;
import de.myelitecraft.elitelib.api.commands.CommandMeta;
import de.myelitecraft.elitelib.api.commands.PlayerCommand;
import net.canarymod.api.entity.living.animal.EntityAnimal;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.commandsys.CommandOwner;
import net.visualillusionsent.utils.LocaleHelper;

import java.util.Map;


/**
 * Project: AdminMenue
 * User: Pual
 * Date: 05/02/2015
 * Time: 19:14 PM
 * Package: com.therazzerapp.adminmenue.commands.world
 */

public class KillAllAnimals extends PlayerCommand{

    public KillAllAnimals(CommandOwner owner, LocaleHelper translator) {
        super(new CommandMeta(new String[]{"killallanimals"},new String[]{"adminmenu.command.killallanimals"},"Kills all animals.", "/killallanimals",0,0), owner, translator);
    }

    @Override
    protected void execute(Player player, Map<Arg, String[]> map, String[] strings, boolean b) {
        for (EntityAnimal animal : player.getWorld().getAnimalList()){
            animal.kill();
        }
    }
}
