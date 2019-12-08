package dev.lockedthread.longshot.objs;

import dev.lockedthread.longshot.RaidWars;
import dev.lockedthread.longshot.enums.FactionColor;
import dev.lockedthread.longshot.objs.land.Square;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
public class Faction {

    private static int DEFAULT_POWER;

    private final Set<Player> players = new HashSet<>();
    private final List<Square> squares = new ArrayList<>();
    private final FactionColor factionColor;
    private int power;

    public Faction(FactionColor factionColor) {
        this.factionColor = factionColor;
        this.power = DEFAULT_POWER;
    }

    public static void loadFactionsConfig() {
        DEFAULT_POWER = RaidWars.getInstance().getConfig().getInt("factions.default-power");
    }

    public void stealFactionSquares(Faction faction) {
        this.squares.addAll(faction.getSquares());
        faction.getSquares().clear();
    }

    public boolean doesFactionOwnLocation(Location location) {
        for (Square ownedSquare : squares) {
            if (ownedSquare.isLocationInSquare(location)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Faction faction = (Faction) o;

        return this.factionColor == faction.factionColor;
    }

    @Override
    public int hashCode() {
        return factionColor.hashCode();
    }
}
