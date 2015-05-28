package com.therazzerapp.adminmenu.menus;

import com.therazzerapp.adminmenu.AdminMenu;
import net.canarymod.Canary;
import net.canarymod.api.chat.ChatComponent;
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
        ChatComponent cCText = f.newChatComponent("");

        for (Group group : Canary.usersAndGroups().getGroups()) {
            ChatComponent cCGroupText = f.newChatComponent("- " + group.getName());
            cCGroupText.getChatStyle().setColor(f.colorYellow());

            if(!AdminMenu.settings.isDisableHoverInfos()) {
                cCGroupText.getChatStyle().setChatHoverEvent(f.newHoverEvent(f.getShowText(), f.newChatComponent(tooltip + " §a" + group.getName())));

                if (AdminMenu.settings.isGroupInfos()) {

                    if (group.isDefaultGroup()) {
                        cCGroupText.getChatStyle().getChatHoverEvent().getValue()
                                .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_grp_isdefault", player.getLocale())));
                    }

                    if (group.getParent() != null) {
                        cCGroupText.getChatStyle().getChatHoverEvent().getValue()
                                .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_grp_parent", player.getLocale()) + " §a" + group.getParent().getName()));
                    }

                    if (group.getPrefix() != null || !group.getPrefix().isEmpty()) {
                        cCGroupText.getChatStyle().getChatHoverEvent().getValue()
                                .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_grp_prefix", player.getLocale()) + " §a" + group.getPrefix().replaceAll("§", "&")));
                    }

                    if (group.getChildren().size() != 0) {
                        String childrenList = "\n";
                        for (Group childs : group.getChildren()) {
                            childrenList += "    - §a" + childs.getName() + "\n";
                        }
                        cCGroupText.getChatStyle().getChatHoverEvent().getValue()
                                .appendSibling(f.newChatComponent("\n" + translator.localeTranslate("atl_grp_childs", player.getLocale()) + " " + childrenList.substring(0, childrenList.length() - 1)));
                    }

                }
            }
            cCGroupText.getChatStyle().setChatClickEvent(f.newClickEvent(f.getRunCommand(), '/' + command.replaceFirst("%g" , group.getName())));
            cCText.appendSibling(cCGroupText);
            cCText.appendText("\n");
        }
        if(cCText.getSiblings().size() < 1){
            return null;
        }
        cCText.getSiblings().get(cCText.getSiblings().size()-1).setText("");
        return cCText;
    }
}
