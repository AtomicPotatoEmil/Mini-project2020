package dk.evalen19.miniprojectspaceshooter.programmingforinteraction.miniproject2020;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class GameScreen implements Screen {
    GameState gameState;

    OrthographicCamera camera;
    SpriteBatch batch;

    PlayerShip playerShip;
    PlayerController playerController;


    PlayerBullet playerBullet;

    public GameScreen(GameState gameState){
        this.gameState = gameState;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1080, 1920);

        playerShip = new PlayerShip();
        playerShip.setPlayerImage(new Texture(Gdx.files.internal("playership.png")));
        playerShip.setPositionX(Gdx.graphics.getWidth()/2);
        playerShip.setPositionY(Gdx.graphics.getHeight()/2);

        playerController = new PlayerController();
        playerShip.makeBoostParticles();
        playerShip.makeExplosionParticles();

        playerBullet = new PlayerBullet(playerShip.getPositionX(), playerShip.getPositionY());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        camera.update();
        batch.setProjectionMatrix(camera.combined);




        playerController.updateAcceleration();


        playerShip.setHurtbox(150, 150);
        if (playerController.accelerationZ > 9){
            playerShip.movePositionY(200);
        }else if (playerController.accelerationZ < 8){
            playerShip.movePositionY(-200);
        }
        if (playerController.accelerationX > 1){
            playerShip.movePositionX(-300);
        }else if (playerController.accelerationX < 0){
            playerShip.movePositionX(300);
        }
        if (playerShip.getPositionX() < 0){
            playerShip.setPositionX(0);
        }
        if (playerShip.getPositionX() > 1080 - 150){
            playerShip.setPositionX(1080 - 150);
        }
        if (playerShip.getPositionY() < 0){
            playerShip.setPositionY(0);
        }
        if (playerShip.getPositionY() > 1920 - 150){
            playerShip.setPositionY(1920 -150);
        }
        if(Gdx.input.justTouched()){
            playerBullet.bullets.add(new PlayerBullet(playerShip.getPositionX(), playerShip.getPositionY()));
        }

        for (Iterator<PlayerBullet> iter = playerBullet.bullets.iterator(); iter.hasNext(); ) {
            PlayerBullet bullet = iter.next();
            bullet.updateBullet(1500);
            if (bullet.positionY > 1920){
                iter.remove();
            }
        }


        batch.begin();


        playerShip.updateBoostParticles(batch);
        for(PlayerBullet bullet: playerBullet.bullets){
            bullet.shootBullet(batch, 40, 70);
            System.out.println(playerBullet.bullets);
        }
        batch.draw(playerShip.getPlayerImage(), playerShip.getPositionX(), playerShip.getPositionY(), 150, 150 );

        if (playerShip.getAlive() == false) {
            playerShip.activateExplosion(batch);
        }


        batch.end();
    }

    @Override
    public void dispose() {

        batch.dispose();
    }



    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}
}
