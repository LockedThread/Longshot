package dev.lockedthread.longshot.objs;

import java.util.HashMap;
import java.util.Map;

public class GameBoard {

    private static GameBoard instance;
    private final Map<Cube, Faction> cubeFactionMap = new HashMap<>();

    public static GameBoard getInstance() {
        return instance == null ? instance = new GameBoard() : instance;
    }

    public Faction getFaction(Cube cube) {
        return cubeFactionMap.get(cube);
    }

    public void addCubeClaim(Faction faction, Cube cube) {
        cubeFactionMap.put(cube, faction);
    }
}
