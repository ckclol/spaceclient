package client.cmd.impl;

import client.cmd.Command;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.ChatComponentText;

import java.util.List;

public class Example extends Command {

		public Example() {
			super("test", "uwu", null);
		}

		public void execute(EntityPlayerSP sender, List<String> args) {
			System.out.println("It worked!");
			for(String s : args) {
				System.out.print(s + ",");
			}
		}
}