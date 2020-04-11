package dk.evalen19.miniprojectspaceshooter.programmingforinteraction.miniproject2020;

import com.badlogic.gdx.Input;

import java.awt.*;

public class Bullet {
    protected Rectangle hitbox;
    private int positionX;
    private int positionY;

    public Bullet(){
        this.hitbox = new Rectangle();
    }

    public void setHitbox(int width, int height){
        this.hitbox.x = getPositionX();
        this.hitbox.y = getPositionY();
        this.hitbox.width = width;
        this.hitbox.height = height;
    }

    public void setPositionX(int x){
        this.positionX = x;
    }

    public int getPositionX(){
        return this.positionX;
    }

    public void setPositionY(int y){
        this.positionY = y;
    }

    public int getPositionY(){
        return this.positionY;
    }
}
