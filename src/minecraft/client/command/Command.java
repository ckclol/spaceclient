package client.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


import com.google.common.collect.ImmutableList;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Represents a Command, which executes various tasks upon user input
 */
public abstract class Command {
    private final String name;
    private String nextLabel;
    private String label;
    private List<String> aliases;
    private List<String> activeAliases;
    private CommandMap commandMap = null;
    protected String description = "";
    protected String usageMessage;
    private String permission;
    private String permissionMessage;

    protected Command(String name) {
        this(name, "", "/" + name, new ArrayList<String>());
    }

    protected Command(String name, String description, String usageMessage, List<String> aliases) {
        this.name = name;
        this.nextLabel = name;
        this.label = name;
        this.description = description;
        this.usageMessage = usageMessage;
        this.aliases = aliases;
        this.activeAliases = new ArrayList<String>(aliases);
    }

    public abstract boolean execute(CommandSender sender, String commandLabel, String[] args);

    @Deprecated
    public List<String> tabComplete(CommandSender sender, String[] args) {
        return null;
    }

    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {

        if (args.length == 0) {
            return ImmutableList.of();
        }

        String lastWord = args[args.length - 1];

        EntityPlayer senderPlayer = sender instanceof EntityPlayer ? (EntityPlayer) sender : null;

        ArrayList<String> matchedPlayers = new ArrayList<String>();
		return matchedPlayers;

        }
    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public boolean register(CommandMap commandMap) {
        if (allowChangesFrom(commandMap)) {
            this.commandMap = commandMap;
            return true;
        }

        return false;
    }

    protected abstract boolean allowChangesFrom(CommandMap commandMap2);

    public boolean unregister(CommandMap commandMap) {
        if (allowChangesFrom(commandMap)) {
            this.commandMap = null;
            this.activeAliases = new ArrayList<String>(this.aliases);
            this.label = this.nextLabel;
            return true;
        }

        return false;
    }

    public List<String> getAliases() {
        return activeAliases;
    }

    public String getPermissionMessage() {
        return permissionMessage;
    }

    public String getDescription() {
        return description;
    }

    public String getUsage() {
        return usageMessage;
    }

    public Command setDescription(String description) {
        this.description = description;
        return this;
    }

    public Command setPermissionMessage(String permissionMessage) {
        this.permissionMessage = permissionMessage;
        return this;
    }

    public Command setUsage(String usage) {
        this.usageMessage = usage;
        return this;
    }

    public static void broadcastCommandMessage(CommandSender source, String message) {
        broadcastCommandMessage(source, message, true);
    }

    public static void broadcastCommandMessage(CommandSender source, String message, boolean sendToSource) {
        String result = source.getName() + ": " + message;
    }

    @Override
    public String toString() {
        return getClass().getName() + '(' + name + ')';
    }
}