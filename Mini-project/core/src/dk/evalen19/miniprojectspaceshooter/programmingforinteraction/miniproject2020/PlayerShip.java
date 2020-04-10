package dk.evalen19.miniprojectspaceshooter.programmingforinteraction.miniproject2020;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayerShip extends Ship {
    private Texture playerImage;
    private boolean alive = true;
    protected ParticleEffect boostEffect;
    protected ParticleEffect playerExplosion;

    public PlayerShip(){
        boostEffect = new ParticleEffect();
        playerExplosion = new ParticleEffect();
    }

    public void setAlive(boolean status){
        this.alive = status;
    }

    public boolean getAlive(){
        return this.alive;
    }

    public void setPlayerImage(Texture path){
        this.playerImage = path;
    }

    public Texture getPlayerImage(){
        return this.playerImage;
    }

    public void makeBoostParticles(){
        boostEffect.load(Gdx.files.internal("PlayerShipBoost.particle"), Gdx.files.internal(""));
        boostEffect.getEmitters().first().getAngle().setHigh(450);
        boostEffect.start();
    }

    public void updateBoostParticles(SpriteBatch batch){
        boostEffect.update(Gdx.graphics.getDeltaTime());
        boostEffect.setPosition(getPositionX() + 85, getPositionY() + 50);
        boostEffect.draw(batch);
    }


    public void makeExplosionParticles(){
        playerExplosion.load(Gdx.files.internal("PlayerExplosion.particle"), Gdx.files.internal(""));
        playerExplosion.setPosition(1080 * 3, 1920 * 3);
        playerExplosion.getEmitters().first().getXScale().setHigh(150);
        playerExplosion.start();
    }

    public void activateExplosion(SpriteBatch batch){
        boostEffect.dispose();
        playerImage.dispose();
        playerExplosion.update(Gdx.graphics.getDeltaTime());
        playerExplosion.setPosition(getPositionX() + 85, getPositionY() + 60);
        playerExplosion.draw(batch);
    }



}
