package com.pyrox.bolt.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pyrox.bolt.bolt;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = bolt.WIDTH;
		config.height = bolt.HEIGHT;
		config.title = bolt.TITLE;
		new LwjglApplication(new bolt(), config);
	}
}
