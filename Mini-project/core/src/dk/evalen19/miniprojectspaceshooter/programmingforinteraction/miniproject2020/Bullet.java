package dk.evalen19.miniprojectspaceshooter.programmingforinteraction.miniproject2020;

import com.badlogic.gdx.math.Rectangle;


public class Bullet {
    protected Rectangle hitbox;

    public Bullet(){
        this.hitbox = new Rectangle();
    }

    public void setHitbox(int x, int y, int width, int height){
        this.hitbox.x = x;
        this.hitbox.y = y;
        this.hitbox.width = width;
        this.hitbox.height = height;
    }

}
