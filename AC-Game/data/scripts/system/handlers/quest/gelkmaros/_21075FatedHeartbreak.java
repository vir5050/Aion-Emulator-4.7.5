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
package quest.gelkmaros;

import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.questEngine.handlers.QuestHandler;
import com.aionemu.gameserver.model.DialogAction;
import com.aionemu.gameserver.questEngine.model.QuestEnv;
import com.aionemu.gameserver.questEngine.model.QuestState;
import com.aionemu.gameserver.questEngine.model.QuestStatus;

/**
 * @author Cheatkiller
 *
 */
public class _21075FatedHeartbreak extends QuestHandler {

    private final static int questId = 21075;
    private int rewardIndex;

    public _21075FatedHeartbreak() {
        super(questId);
    }

    public void register() {
        qe.registerQuestNpc(799409).addOnQuestStart(questId);
        qe.registerQuestNpc(799409).addOnTalkEvent(questId);
        qe.registerQuestNpc(798392).addOnTalkEvent(questId);
        qe.registerQuestNpc(799410).addOnTalkEvent(questId);
        qe.registerQuestNpc(204138).addOnTalkEvent(questId);
    }

    @Override
    public boolean onDialogEvent(QuestEnv env) {
        Player player = env.getPlayer();
        QuestState qs = player.getQuestStateList().getQuestState(questId);
        DialogAction dialog = env.getDialog();
        int targetId = env.getTargetId();

        if (qs == null || qs.getStatus() == QuestStatus.NONE) {
            if (targetId == 799409) {
                if (dialog == DialogAction.QUEST_SELECT) {
                    return sendQuestDialog(env, 4762);
                } else {
                    return sendQuestStartDialog(env);
                }
            }
        } else if (qs.getStatus() == QuestStatus.START) {
            if (targetId == 798392) {
                if (dialog == DialogAction.QUEST_SELECT) {
                    return sendQuestDialog(env, 1011);
                } else if (dialog == DialogAction.SETPRO1) {
                    giveQuestItem(env, 182207917, 1);
                    return defaultCloseDialog(env, 0, 1);
                } else if (dialog == DialogAction.SETPRO2) {
                    giveQuestItem(env, 182207917, 1);
                    return defaultCloseDialog(env, 0, 2);
                }
            } else if (targetId == 799410) {
                if (dialog == DialogAction.QUEST_SELECT) {
                    if (qs.getQuestVarById(0) == 1) {
                        return sendQuestDialog(env, 1352);
                    }
                } else if (dialog == DialogAction.SET_SUCCEED) {
                    removeQuestItem(env, 182207917, 1);
                    return defaultCloseDialog(env, 1, 1, true, false);
                }
            } else if (targetId == 204138) {
                if (dialog == DialogAction.QUEST_SELECT) {
                    if (qs.getQuestVarById(0) == 2) {
                        return sendQuestDialog(env, 1693);
                    }
                } else if (dialog == DialogAction.SET_SUCCEED) {
                    rewardIndex = 1;
                    removeQuestItem(env, 182207917, 1);
                    return defaultCloseDialog(env, 2, 2, true, false);
                }
            }
        } else if (qs.getStatus() == QuestStatus.REWARD) {
            if (targetId == 799409) {
                if (dialog == DialogAction.USE_OBJECT) {
                    return sendQuestDialog(env, 10002);
                }
                return sendQuestEndDialog(env, rewardIndex);
            }
        }
        return false;
    }
}
