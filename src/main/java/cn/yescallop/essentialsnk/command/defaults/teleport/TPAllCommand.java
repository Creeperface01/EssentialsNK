package cn.yescallop.essentialsnk.command.defaults.teleport;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import cn.yescallop.essentialsnk.EssentialsAPI;
import cn.yescallop.essentialsnk.command.CommandBase;

public class TPAllCommand extends CommandBase {

    public TPAllCommand(EssentialsAPI api) {
        super("tpall", api);
    }

    public boolean execute(CommandSender sender, String label, String[] args) {
        if (!this.testPermission(sender)) {
            return false;
        }
        Player player;
        if (args.length == 0) {
            if (!this.testIngame(sender)) {
                return false;
            }
            player = (Player) sender;
        } else if (args.length == 1) {
            player = api.getServer().getPlayer(args[0]);
            if (player == null) {
                sender.sendMessage(TextFormat.RED + lang.translateString("commands.generic.player.notfound", args[0]));
                return false;
            }
        } else {
            this.sendUsage(sender);
            return false;
        }
        for (Player p : api.getServer().getOnlinePlayers().values()) {
            if (p != player) {
                p.teleport(player);
                p.sendMessage(TextFormat.YELLOW + lang.translateString("commands.tpall.other", player.getDisplayName()));
            }
        }
        player.sendMessage(TextFormat.GREEN + lang.translateString("commands.tpall.success"));
        return true;
    }
}
