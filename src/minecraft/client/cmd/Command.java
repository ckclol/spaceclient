package client.cmd;

import net.minecraft.client.entity.EntityPlayerSP;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public abstract class Command {

    private final String name;
    private final String desc;

    private CommandExecutor executor;

    public Command(String name, String desc, CommandExecutor executor){
        this.name = name;
        this.desc = desc;

        this.executor = executor;
    }


    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(CommandExecutor executor) {
        this.executor = executor;
    }

    public abstract void execute(EntityPlayerSP sender, List<String> args);

    	
}