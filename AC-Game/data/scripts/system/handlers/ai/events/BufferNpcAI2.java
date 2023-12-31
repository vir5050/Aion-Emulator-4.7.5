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
package ai.events;

import com.aionemu.gameserver.ai2.AIName;
import com.aionemu.gameserver.ai2.NpcAI2;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.network.aion.serverpackets.SM_DIALOG_WINDOW;
import com.aionemu.gameserver.skillengine.SkillEngine;
import com.aionemu.gameserver.utils.PacketSendUtility;

import java.util.Random;

/**
 * @author Master
 */
@AIName("bufnpc")
public class BufferNpcAI2 extends NpcAI2 {

	@Override
	protected void handleDialogStart(Player player) {
		PacketSendUtility.sendPacket(player, new SM_DIALOG_WINDOW(getObjectId(), 1011));
	}

	@Override
	public boolean onDialogSelect(Player player, int dialogId, int questId, int exp) {
		switch (dialogId) {
			case 10000: {
				int[] rr = { 2, 2, 1, 1, 1 };
				Random rand = new Random();

				int skillLevel = 1;
				getOwner().setTarget(player);

				int skillId1 = 20950; // Blessing of Rock I SKILLID:21282 21283
				int skillId2 = 20950; // Blessing of Health I

				if (rr[rand.nextInt(4)] == 2) {
					SkillEngine.getInstance().getSkill(getOwner(), skillId1, skillLevel, player).useWithoutPropSkill();
					SkillEngine.getInstance().getSkill(getOwner(), skillId2, skillLevel, player).useWithoutPropSkill();
				}
				else {
					if (rand.nextInt(1) == 0) {
						SkillEngine.getInstance().getSkill(getOwner(), skillId1, skillLevel, player).useWithoutPropSkill();
					}
					else {
						SkillEngine.getInstance().getSkill(getOwner(), skillId2, skillLevel, player).useWithoutPropSkill();
					}
				}
				break;
			}
		}
		return true;
	}
}
