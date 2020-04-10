package dk.evalen19.miniprojectspaceshooter.programmingforinteraction.miniproject2020;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import dk.evalen19.miniprojectspaceshooter.programmingforinteraction.miniproject2020.GameState;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new GameState(), config);
	}
}
