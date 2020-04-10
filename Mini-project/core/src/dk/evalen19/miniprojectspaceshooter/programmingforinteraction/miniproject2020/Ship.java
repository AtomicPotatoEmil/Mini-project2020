package dk.evalen19.miniprojectspaceshooter.programmingforinteraction.miniproject2020;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class Ship {

    protected Rectangle hurtbox;
    private float positionX;
    private float positionY;

    public Ship(){
        hurtbox = new Rectangle();
    }

    public void setHurtbox(int width, int height){
        this.hurtbox.x = getPositionX();
        this.hurtbox.y = getPositionY();
        this.hurtbox.width = width;
        this.hurtbox.height = height;
    }

    public void setPositionX(int x){
        this.positionX = x;
    }

    public void setPositionY(int y){
        this.positionY = y;
    }

    public float getPositionX(){
        return this.positionX;
    }

    public float getPositionY(){
        return this.positionY;
    }

    public void movePositionX(float speed){
        this.positionX += speed * Gdx.graphics.getDeltaTime();
    }

    public void movePositionY(float speed){
        this.positionY += speed * Gdx.graphics.getDeltaTime();
    }

}
