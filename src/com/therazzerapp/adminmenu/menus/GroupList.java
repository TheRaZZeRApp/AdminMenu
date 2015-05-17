package com.therazzerapp.adminmenu.menus;

import com.therazzerapp.adminmenu.AdminMenu;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
import net.canarymod.api.chat.ClickEvent;
import net.canarymod.api.chat.HoverEvent;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.factory.ChatComponentFactory;
import net.canarymod.user.Group;
import net.visualillusionsent.utils.LocaleHelper;

/**
 * Project: AdminMenu
 * User: Pual
 * Date: 05/05/2015
 * Time: 14:30 PM
 * Package: com.therazzerapp.adminmenu.menus
 * E-Mail: rezzer101@googlemail.com
 */

public class GroupList {
    public static ChatComponent getBody(String tooltip, String command, Player player, LocaleHelper translator) {
        ChatComponentFactory f = Canary.factory().getChatComponentFactory();
        ChatComponent text = f.newChatComponent("");

        int counter = 0;
        String newLine;
        for (Group group : Canary.usersAndGroups().getGroups()) {

            counter++;
            newLine = "\n";
            if (counter >= Canary.usersAndGroups().getGroups().length){
                newLine = "";
            }

            ChatComponent groupText = f.newChatComponent("- " + group.getName() + newLine);
            groupText.getChatStyle().setColor(f.colorYellow());

            groupText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip + " §a" + group.getName())));

            if(AdminMenu.settings.isGroupInfos()){

                if(group.isDefaultGroup()){
                    groupText.getChatStyle().getChatHoverEvent().getValue()
                            .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_grp_isdefault", player.getLocale())));
                }


                if(group.getParent() != null){
                    groupText.getChatStyle().getChatHoverEvent().getValue()
                            .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_grp_parent", player.getLocale()) + " §a" + group.getParent().getName()));
                }

                if(group.getPrefix() != null || !group.getPrefix().equals("")){
                    groupText.getChatStyle().getChatHoverEvent().getValue()
                            .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_grp_prefix", player.getLocale()) + " §a" + group.getPrefix().replaceAll("§","&")));
                }

                if(group.getChildren().size() != 0){
                    String childrenList = "\n";
                    int counter2 = 0;
                    String komma;
                    for (Group childs : group.getChildren()){
                        counter2++;
                        komma = "\n";
                        if(counter2 >= group.getChildren().size()){
                            komma = "";
                        }
                        childrenList += "    - §a" + childs.getName() + komma;
                    }
                    groupText.getChatStyle().getChatHoverEvent().getValue()
                            .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_grp_childs",player.getLocale()) + " " + childrenList));
                }

            }



            groupText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%g" , group.getName())));
            text.appendSibling(groupText);
        }

        return text;
    }
}
