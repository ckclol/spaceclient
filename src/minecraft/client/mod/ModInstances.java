package client.mod;

import client.mod.hud.HUDManager;
import client.mod.impl.*;

public class ModInstances {
	
	private static ModExample example;

	
	public static void register(HUDManager api) {

		example = new ModExample();
		api.register(example);

	}
	
	public static ModExample getModExample() {
		return example;
	}
	
}
