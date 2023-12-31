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
package com.aionemu.gameserver.network.aion.serverpackets;

import com.aionemu.gameserver.model.gameobjects.Item;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.model.templates.item.ItemTemplate;
import com.aionemu.gameserver.network.PacketLoggerService;
import com.aionemu.gameserver.network.aion.AionConnection;
import com.aionemu.gameserver.network.aion.AionServerPacket;
import com.aionemu.gameserver.network.aion.iteminfo.ItemInfoBlob;
import com.aionemu.gameserver.network.aion.iteminfo.ItemInfoBlob.ItemBlobType;
import com.aionemu.gameserver.services.item.ItemPacketService.ItemUpdateType;

/**
 * @author ATracer
 * @author -Nemesiss-
 */
public class SM_INVENTORY_UPDATE_ITEM extends AionServerPacket {

    private final Player player;
    private final Item item;
    private final ItemUpdateType updateType;

    public SM_INVENTORY_UPDATE_ITEM(Player player, Item item) {
        this(player, item, ItemUpdateType.DEC_ITEM_USE);
    }

    public SM_INVENTORY_UPDATE_ITEM(Player player, Item item, ItemUpdateType updateType) {
        this.player = player;
        this.item = item;
        this.updateType = updateType;
    }

    @Override
    protected void writeImpl(AionConnection con) {
    	PacketLoggerService.getInstance().logPacketSM(this.getPacketName());
        ItemTemplate itemTemplate = item.getItemTemplate();

        writeD(item.getObjectId());
        writeNameId(itemTemplate.getNameId());

        ItemInfoBlob itemInfoBlob;
        switch (updateType) {
            case EQUIP_UNEQUIP:
                itemInfoBlob = new ItemInfoBlob(player, item);
                itemInfoBlob.addBlobEntry(ItemBlobType.EQUIPPED_SLOT);
                break;
            case CHARGE:
                itemInfoBlob = new ItemInfoBlob(player, item);
                itemInfoBlob.addBlobEntry(ItemBlobType.CONDITIONING_INFO);
            default:
                itemInfoBlob = ItemInfoBlob.getFullBlob(player, item);
                break;
        }
        itemInfoBlob.writeMe(getBuf());

        if (updateType.isSendable()) {
            writeH(updateType.getMask());
        }
    }
}
