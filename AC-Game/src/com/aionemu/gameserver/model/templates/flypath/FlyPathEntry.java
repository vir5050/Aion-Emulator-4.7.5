/**
 * This file is part of Aion-Lightning <aion-lightning.org>.
 *
 *  Aion-Lightning is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Aion-Lightning is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details. *
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Aion-Lightning.
 *  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 * Credits goes to all Open Source Core Developer Groups listed below
 * Please do not change here something, regarding the developer credits, except the "developed by XXXX".
 * Even if you edit a lot of files in this source, you still have no rights to call it as "your Core".
 * Everybody knows that this Emulator Core was developed by Aion Lightning 
 * @-Aion-Unique-
 * @-Aion-Lightning
 * @Aion-Engine
 * @Aion-Extreme
 * @Aion-NextGen
 * @Aion-Core Dev.
 */
package com.aionemu.gameserver.model.templates.flypath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author KID
 */
@XmlRootElement(name = "flypath_location")
@XmlAccessorType(XmlAccessType.NONE)
public class FlyPathEntry {

    @XmlAttribute(name = "id", required = true)
    private short id;
    @XmlAttribute(name = "sx", required = true)
    private float startX;
    @XmlAttribute(name = "sy", required = true)
    private float startY;
    @XmlAttribute(name = "sz", required = true)
    private float startZ;
    @XmlAttribute(name = "sworld", required = true)
    private int sworld;
    @XmlAttribute(name = "ex", required = true)
    private float endX;
    @XmlAttribute(name = "ey", required = true)
    private float endY;
    @XmlAttribute(name = "ez", required = true)
    private float endZ;
    @XmlAttribute(name = "eworld", required = true)
    private int eworld;
    @XmlAttribute(name = "time", required = true)
    private float time;

    public short getId() {
        return id;
    }

    public float getStartX() {
        return startX;
    }

    public float getStartY() {
        return startY;
    }

    public float getStartZ() {
        return startZ;
    }

    public float getEndX() {
        return endX;
    }

    public float getEndY() {
        return endY;
    }

    public float getEndZ() {
        return endZ;
    }

    public int getStartWorldId() {
        return sworld;
    }

    public int getEndWorldId() {
        return eworld;
    }

    public int getTimeInMs() {
        return (int) (time * 1000);
    }
}
