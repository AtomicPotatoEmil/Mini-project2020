package dk.evalen19.miniprojectspaceshooter.programmingforinteraction.miniproject2020;

import com.badlogic.gdx.Gdx;

public class PlayerController{

    public float accelerationZ;
    public float accelerationX;

    public void updateAcceleration(){
        accelerationZ = Gdx.input.getAccelerometerZ();
        accelerationX = Gdx.input.getAccelerometerX();
    }

}
