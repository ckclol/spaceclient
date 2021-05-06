package space.mod;

import space.hud.HUDManager;

public class ModInstances {

	private static ModCPS cps;
	private static ModExample exa;
	
	public static void register(HUDManager api) {
		exa = new ModExample();
		api.register(exa);
		cps = new ModCPS();
		api.register(cps);
	}

	public static ModCPS getModCPS() {
		return cps;
	}
	
	public static ModExample getModExample() {
		return exa;
	}
	
}
