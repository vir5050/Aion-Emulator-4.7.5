/*
 * This file is part of Aion-Lightning <aion-lightning.org>.
 *
 * Aion-Lightning is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * Aion-Lightning is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Aion-Lightning.
 * If not, see <http://www.gnu.org/licenses/>.
 *
 * Credits goes to all Open Source Core Developer Groups listed below
 * Please do not change here something, ragarding the developer credits, except the "developed by XXXX".
 * Even if you edit a lot of files in this source, you still have no rights to call it as "your Core".
 * Everybody knows that this Emulator Core was developed by Aion Lightning 
 * @-Aion-Unique-
 * @-Aion-Lightning
 * @Aion-Engine
 * @Aion-Extreme
 * @Aion-NextGen
 * @Aion-Core Dev.
 *
 */
package com.aionemu.gameserver.world;

import com.aionemu.gameserver.instance.InstanceEngine;
import com.aionemu.gameserver.instance.handlers.InstanceHandler;

/**
 * @author ATracer
 */
public class WorldMapInstanceFactory {

	/**
	 * @param parent
	 * @param instanceId
	 * @return
	 */
	public static WorldMapInstance createWorldMapInstance(WorldMap parent, int instanceId) {
		return createWorldMapInstance(parent, instanceId, 0);
    }

    public static WorldMapInstance createEventWorldMapInstance(WorldMap parent, int instanceId, int eventHandlerId) {
        WorldMapInstance worldMapInstance = null;
        if (parent.getMapId() == WorldMapType.RESHANTA.getId()) {
            worldMapInstance = new WorldMap3DInstance(parent, instanceId);
        } else {
            worldMapInstance = new WorldMap2DInstance(parent, instanceId, 0);
        }
        InstanceHandler instanceHandler = InstanceEngine.getInstance().getNewEventInstanceHandler(eventHandlerId);
        worldMapInstance.setInstanceHandler(instanceHandler);
        return worldMapInstance;
	}

	public static WorldMapInstance createWorldMapInstance(WorldMap parent, int instanceId, int ownerId) {
		WorldMapInstance worldMapInstance = null;
		if (parent.getMapId() == WorldMapType.RESHANTA.getId()) {
			worldMapInstance = new WorldMap3DInstance(parent, instanceId);
		} else {
			worldMapInstance = new WorldMap2DInstance(parent, instanceId, ownerId);
		}
		InstanceHandler instanceHandler = InstanceEngine.getInstance().getNewInstanceHandler(parent.getMapId());
		worldMapInstance.setInstanceHandler(instanceHandler);
		return worldMapInstance;
	}
}
