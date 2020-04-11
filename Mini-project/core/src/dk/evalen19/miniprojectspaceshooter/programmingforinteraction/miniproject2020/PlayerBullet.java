package dk.evalen19.miniprojectspaceshooter.programmingforinteraction.miniproject2020;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;


public class PlayerBullet extends Bullet {

    public int positionX;
    public int positionY;

    protected Texture playerBulletImage;
    protected ArrayList<PlayerBullet> bullets;

    public PlayerBullet(int x, int y){
        this.positionX = x;
        this.positionY = y;
        playerBulletImage = new Texture(Gdx.files.internal("playerbullet.png"));
        bullets = new ArrayList<PlayerBullet>();

    }

    public void updateBullet(int speed){
        this.positionY += speed * Gdx.graphics.getDeltaTime();
        if (positionY > 1920){
            playerBulletImage.dispose();
        }
    }

        public void shootBullet(SpriteBatch batch, int width, int height){
        batch.draw(playerBulletImage, positionX + 20, positionY + 60, width, height);
        setHitbox(positionX + 20, positionY + 60, width, height);
        batch.draw(playerBulletImage, positionX + 90, positionY + 60, width, height);
        setHitbox(positionX + 90, positionY + 60, width, height);

    }



}
