package dk.evalen19.miniprojectspaceshooter.programmingforinteraction.miniproject2020.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import dk.evalen19.miniprojectspaceshooter.programmingforinteraction.miniproject2020.GameState;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new GameState(), config);
	}
}
