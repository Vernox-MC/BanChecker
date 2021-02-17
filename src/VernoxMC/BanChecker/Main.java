package VernoxMC.BanChecker;



import cn.nukkit.permission.BanEntry;
import cn.nukkit.permission.BanList;
import net.minidev.json.JSONObject;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;

import java.text.SimpleDateFormat;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

public class Main extends PluginBase {


  public void onEnable() {

    this.getLogger().info(TextFormat.GREEN + "Ban Checker Enabled");

  }

  public void onDisable() {

    this.getLogger().info(TextFormat.RED + "Ban Checker Disabled!");

  }


  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    {

      switch (cmd.getName()) {

        case "bcheck":
          if(args.length < 1){
            sender.sendMessage(TextFormat.GREEN + "You need to include a real username!");
            break;
          }
          String player = args[0];


          sender.sendMessage(TextFormat.GREEN + "Punishment Checker:");
          BanList banmanagement = sender.getServer().getNameBans();
          if(banmanagement.isBanned(player.toLowerCase())){
          LinkedHashMap<String, BanEntry> getentry = banmanagement.getEntires();
            BanEntry baninfo = getentry.get(player.toLowerCase());
            String reason = baninfo.getReason();
            String mod = baninfo.getSource();
            Date bannedon = baninfo.getCreationDate();
            sender.sendMessage(TextFormat.AQUA + "User: " + TextFormat.DARK_BLUE +  player);
            sender.sendMessage(TextFormat.RED + "Perm Banned: Yes" + "\n" + TextFormat.RED +"Banned By: "+ mod + "\n"+ TextFormat.RED +"Reason: " + reason + "\n" + TextFormat.RED  + "Banned On: " + bannedon);

        } else{
            sender.sendMessage(TextFormat.AQUA + player + TextFormat.DARK_BLUE +  " is not banned!");
          }
          break;
      }

      return true;

    }
  }
}