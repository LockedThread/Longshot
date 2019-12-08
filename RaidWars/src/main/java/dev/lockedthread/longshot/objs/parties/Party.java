package dev.lockedthread.longshot.objs.parties;

import dev.lockedthread.longshot.RaidWars;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Party {

    private final List<Player> players;

    public Party(Player leader) {
        (this.players = new ArrayList<>()).add(leader);
    }

    public void addPlayer(Player player) {
        players.add(player);
        RaidWars.getInstance().getPartyMap().put(player.getUniqueId(), this);
    }

    /**
     * @param player the player to remove
     * @return whether or not to disband the party
     */
    public boolean removePlayer(Player player) {
        final boolean leader = isLeader(player);
        players.remove(player);
        RaidWars.getInstance().getPartyMap().remove(player.getUniqueId(), this);
        return leader;
    }

    public Player getLeader() {
        return players.get(0);
    }

    public boolean isLeader(Player player) {
        return getLeader().getUniqueId().equals(player.getUniqueId());
    }
}
