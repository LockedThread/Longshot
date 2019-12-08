package dev.lockedthread.longshot;

import com.gameservergroup.gsgcore.plugin.Module;
import dev.lockedthread.longshot.enums.FactionColor;
import dev.lockedthread.longshot.objs.Faction;
import dev.lockedthread.longshot.objs.parties.Party;
import dev.lockedthread.longshot.units.UnitRaidWars;
import lombok.Getter;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class RaidWars extends Module {

    @Getter
    private static RaidWars instance;

    private final EnumMap<FactionColor, Faction> factionMap = new EnumMap<>(FactionColor.class);
    private final Map<UUID, Faction> playerMap = new HashMap<>();
    private final Map<UUID, Party> partyMap = new HashMap<>();

    @Override
    public void enable() {
        instance = this;

        saveDefaultConfig();

        Faction.loadFactionsConfig();

        registerUnits(new UnitRaidWars());
    }

    @Override
    public void disable() {
        instance = null;
    }
}
