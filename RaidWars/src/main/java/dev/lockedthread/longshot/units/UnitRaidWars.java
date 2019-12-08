package dev.lockedthread.longshot.units;

import com.gameservergroup.gsgcore.commands.post.CommandPost;
import com.gameservergroup.gsgcore.units.Unit;
import dev.lockedthread.longshot.RaidWars;
import dev.lockedthread.longshot.enums.GameState;
import dev.lockedthread.longshot.enums.Message;
import dev.lockedthread.longshot.objs.Faction;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnitRaidWars extends Unit {

    @Getter
    private static GameState gameState;

    @Override
    public void setup() {
        UnitRaidWars.gameState = GameState.LOBBY;

        CommandPost.create()
                .builder()
                .handler(c -> {
                    CommandSender sender = c.getSender();
                    if (c.getRawArgs().length == 0) {
                        if (sender instanceof Player) {
                            Faction faction = getFaction((Player) sender);
                            if (faction != null) {
                                c.reply(faction.toString());
                            } else {
                                c.reply(Message.COMMAND_ONLY_NOT_PLAYING.getMessage());
                            }
                        } else {
                            c.reply(Message.COMMAND_ONLY_PLAYERS.getMessage());
                        }
                    }
                }).post(RaidWars.getInstance(), "f", "faction", "factions");

        CommandPost.create()
                .builder()
                .handler(c -> {

                }).post(RaidWars.getInstance(), "party", "p", "parties");
    }

    public void joinFaction(Player player, Faction faction) {
        faction.getPlayers().add(player);
    }

    public Faction getFaction(Player player) {
        return RaidWars.getInstance().getPlayerMap().get(player.getUniqueId());
    }

}
