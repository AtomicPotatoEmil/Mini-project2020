package dk.evalen19.miniprojectspaceshooter.programmingforinteraction.miniproject2020;


import com.badlogic.gdx.Game;

public class GameState extends Game {


	
	@Override
	public void create () {

		this.setScreen(new GameScreen(this));
	}

	@Override
	public void render () {

		super.render();
	}
	
	@Override
	public void dispose () {

	}
}
