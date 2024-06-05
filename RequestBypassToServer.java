import net.sf.l2j.Skin.handler.CustomBypassHandler;
 import net.sf.l2j.gameserver.communitybbs.CommunityBoard;
 import net.sf.l2j.gameserver.data.ItemTable;
+import net.sf.l2j.gameserver.data.SkillTable;
 import net.sf.l2j.gameserver.data.cache.HtmCache;
 import net.sf.l2j.gameserver.data.manager.HeroManager;
 import net.sf.l2j.gameserver.data.xml.AdminData;
@@ -26,6 +27,7 @@
 import net.sf.l2j.gameserver.handler.IBypassHandler;
 import net.sf.l2j.gameserver.handler.IVoicedCommandHandler;
 import net.sf.l2j.gameserver.handler.VoicedCommandHandler;
+import net.sf.l2j.gameserver.handler.itemhandlers.BuffsCustom;
 import net.sf.l2j.gameserver.model.World;
 import net.sf.l2j.gameserver.model.WorldObject;
 import net.sf.l2j.gameserver.model.actor.Npc;
@@ -94,6 +96,13 @@
 
 			ach.useAdminCommand(_command, player);
 		}
+		else if (_command.startsWith("buffCommand") && BuffsCustom.check(player))
+		{
+			String idBuff = _command.substring(12);
+			int parseIdBuff = Integer.parseInt(idBuff);
+			SkillTable.getInstance().getInfo(parseIdBuff, SkillTable.getInstance().getMaxLevel(parseIdBuff)).getEffects(player, player);
+			BuffsCustom.sendHtml(player);
+		}
 		else if (_command.startsWith("player_help "))
 		{
 			final String path = _command.substring(12);
