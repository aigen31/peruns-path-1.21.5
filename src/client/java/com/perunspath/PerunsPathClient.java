package com.perunspath;

import com.perunspath.items.TestItems;

import net.fabricmc.api.ClientModInitializer;

public class PerunsPathClient implements ClientModInitializer {
	public static final String MOD_ID = "peruns_path";

	@Override
	public void onInitializeClient() {
		TestItems.initialize();
	}
}