package org.example;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Bot extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDABuilder.createDefault("MTE4OTMyOTA4ODIxMzY4ODM0MA.GVGXEz.rVNN3y3MqJmwZVp6XYZfW7b1KdY90vCrIwfIF0")
                .addEventListeners(new Bot())
                .setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.watching("PornHub"))
                .build();
    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        if (event.getMessageId().equals("1189332742572355625")) {
            String emojiName = event.getReaction().getEmoji().getName();
            Guild guild = event.getGuild();
            Member member = event.getMember();
            if (member != null) {
                Role role;
                switch (emojiName) {
                    case "\uD83E\uDD21":
                        role = guild.getRoleById("1189352024064671945");
                        break;
                    case "\uD83D\uDE08":
                        role = guild.getRoleById("1189360476073775255");
                        break;
                    case "\uD83E\uDD76":
                        role = guild.getRoleById("1189360562581295115");
                        break;
                    default:
                        return;
                }
                if (role != null) {
                    guild.addRoleToMember(member, role).queue();
                }
            }
        }
    }
}