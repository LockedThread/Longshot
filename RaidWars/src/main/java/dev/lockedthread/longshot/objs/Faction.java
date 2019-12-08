package dev.lockedthread.longshot.objs;

import dev.lockedthread.longshot.RaidWars;
import dev.lockedthread.longshot.enums.FactionColor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
public class Faction {

    private static int DEFAULT_POWER;
    private final Set<FactionPlayer> factionPlayers = new HashSet<>();
    private final int power;
    private final FactionColor factionColor;

    public Faction(FactionColor factionColor) {
        this.factionColor = factionColor;
        this.power = DEFAULT_POWER;
    }

    public static void loadFactionsConfig() {
        DEFAULT_POWER = RaidWars.getInstance().getConfig().getInt("factions.default-power");
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
