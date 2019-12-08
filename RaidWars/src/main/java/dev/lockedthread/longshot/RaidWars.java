package dev.lockedthread.longshot;

import com.gameservergroup.gsgcore.plugin.Module;
import dev.lockedthread.longshot.objs.Faction;

public class RaidWars extends Module {

    private static RaidWars instance;

    public static RaidWars getInstance() {
        return instance;
    }

    @Override
    public void enable() {
        instance = this;

        saveDefaultConfig();

        Faction.loadFactionsConfig();
    }

    @Override
    public void disable() {
        instance = null;
    }
}
