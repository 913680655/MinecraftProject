package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

import net.fabricmc.api.ClientModInitializer;

public class ExampleModClient implements ClientModInitializer {
	private static KeyBinding toggleHideArmorKey;

	@Override
	public void onInitializeClient() {
		// 注册快捷键：默认 H
		toggleHideArmorKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.modid.toggle_armor",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_H,
				"category.modid.main"
		));

		// 每帧检测按键
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (toggleHideArmorKey.wasPressed()) {
				// 翻转开关
				ExampleMod.hideArmor = !ExampleMod.hideArmor;
				// 给玩家发送提示
				client.player.sendMessage(
						Text.of("盔甲显示已切换为: " + (ExampleMod.hideArmor ? "隐藏" : "显示")),
						true
				);
			}
		});


		MethodLister.listMethods();
	}
}