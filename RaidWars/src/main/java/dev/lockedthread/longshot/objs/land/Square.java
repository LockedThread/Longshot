package dev.lockedthread.longshot.objs.land;

import lombok.Data;
import org.bukkit.Location;
import org.bukkit.World;

@Data
public class Square {

    private final World world;
    private final int minX, minZ;
    private final int maxX, maxZ;

    public boolean isLocationInSquare(Location location) {
        if (location.getWorld().getName().equals(world.getName())) {
            if (location.getBlockX() >= minX && location.getBlockX() <= maxX) {
                if (location.getBlockZ() >= minZ && location.getBlockZ() <= minZ) {
                    return true;
                }
            }
        }
        return false;
    }
}
