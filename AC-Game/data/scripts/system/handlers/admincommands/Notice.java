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
package admincommands;

import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.utils.PacketSendUtility;
import com.aionemu.gameserver.utils.chathandlers.AdminCommand;
import com.aionemu.gameserver.world.World;

import java.util.Iterator;

/**
 * Admin notice command
 *
 * @author Jenose Updated By Darkwolf
 */
public class Notice extends AdminCommand {

    public Notice() {
        super("notice");
    }

    @Override
    public void execute(Player player, String... params) {

        String message = "";

        try {
            for (int i = 0; i < params.length; i++) {
                message += " " + params[i];
            }
        } catch (NumberFormatException e) {
            PacketSendUtility.sendMessage(player, "Parameters should be text or number !");
            return;
        }
        Iterator<Player> iter = World.getInstance().getPlayersIterator();

        while (iter.hasNext()) {
            PacketSendUtility.sendBrightYellowMessageOnCenter(iter.next(), "Information: " + message);
        }
    }

    @Override
    public void onFail(Player player, String message) {
        PacketSendUtility.sendMessage(player, "Syntax: //notice <message>");
    }
}
