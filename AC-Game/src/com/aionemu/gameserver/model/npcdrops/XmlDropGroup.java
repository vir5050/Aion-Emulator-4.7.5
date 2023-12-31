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
 
package com.aionemu.gameserver.model.npcdrops;

import com.aionemu.gameserver.model.Race;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author kosyachok
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlDropGroup {

  @XmlElement(name="drop")
  protected List<XmlDrop> drop;
  @XmlAttribute
  protected Race race = Race.PC_ALL;
  @XmlAttribute(name="use_category")
  protected Boolean useCategory = Boolean.valueOf(true);
  @XmlAttribute(name="name")
  protected String group_name;
  
  public List<XmlDrop> getDrop() {
    return this.drop;
  }
  
  public Race getRace() {
    return this.race;
  }
  
  public Boolean isUseCategory() {
    return this.useCategory;
  }
  
  public String getGroupName() {
    if (this.group_name == null) {
      return "";
    }
    return this.group_name;
  }
}
