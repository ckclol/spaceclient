package space.cmd;

import space.cmd.impl.*;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import space.ClientMain;

import java.util.ArrayList;
import java.util.List;

import space.cmd.Command;

public class CommandManager {

	private static final String PREFIX = "/";
	
	private static CommandManager instance;
	
	private static List<Command> commands = new ArrayList<Command>();
	
	public static CommandManager getInstance() {
		if(instance == null) {
			instance = new CommandManager();
		}
		return instance;
	}
	
	public CommandManager() {
		register(new Example());
		commands.add(new Example());
	}
	
	public void register(Command cmd) {
		commands.add(cmd);
	}
	
	public boolean tryExecute(String in) {
		
		for(Command c : commands) {
			if(in.split(" ")[0].equalsIgnoreCase(PREFIX + c.getName())) {
				c.execute(Minecraft.getMinecraft().thePlayer, getArgs(in));
				return true;
			}
		}
		
		return false;
	}

	public void onTab(String s, List<String> list) {
		
		for(Command cmd : commands) {
			if (CommandBase.doesStringStartWith(s, cmd.getName()))
	        {
	            list.add(cmd.getName());
	        }
		}
		
		
	}
	
	public static Command findCommand(String text) {
        final String[] split = seperatePrefix(text).split(" ");

        if (split.length <= 0)
            return null;


        return commands.stream()
                .filter(cmd -> cmd.getName().equalsIgnoreCase(split[0]))
                .findFirst()
                .orElse(null);
    }

	 public static String seperatePrefix(String text) {
	        if (!text.startsWith(PREFIX))
	            return PREFIX + text;

	        return text.substring(1);
	    }
	 
	 public static boolean isCommand(String text){
	        return findCommand(text) != null;
	    }
	 

	    public static List<String> getArgs(String text) {
	        if (!isCommand(text))
	            return new ArrayList<>();

	        final List<String> args = new ArrayList<>();

	        final String[] split = seperatePrefix(text).split(" ");

	        int beginIndex = 1;

	        for (int i = beginIndex; i < split.length; i++){
	            final String arg = split[i];

	            if (arg == null)
	                continue;

	            args.add(arg);
	        }

	        return args;
	    }

}
