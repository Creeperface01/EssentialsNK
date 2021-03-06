package cn.yescallop.essentialsnk.data;

import cn.nukkit.level.Location;
import lombok.Getter;

/**
 * @author CreeperFace
 */

@Getter
public class Warp extends Location {

    private final String name;
    private final String creator;
    private final String levelName;

    public Warp(String name, String creator, Location loc) {
        this(name, creator, loc.x, loc.y, loc.z, loc.yaw, loc.pitch, loc.level.getFolderName());
    }

    public Warp(String name, String creator, double x, double y, double z, double yaw, double pitch, String levelName) {
        super(x, y, z, yaw, pitch);
        this.name = name;
        this.creator = creator;
        this.levelName = levelName;
    }
}
