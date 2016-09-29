/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import pokemon.Game;
import pokemon.Handler;
import pokemon.gfx.Animation;
import pokemon.gfx.Assets;
import pokemon.inventory.Inventory;

public class Player extends Creature {

    //Animations
    private Animation animDown, animUp, animRight, animLeft;
    //
    private Inventory inventory;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 2;
        bounds.y = 18;
        bounds.width = 28;
        bounds.height = 22;

        //Animations
        animDown = new Animation(300, Assets.player_down);
        animUp = new Animation(300, Assets.player_up);
        animRight = new Animation(300, Assets.player_right);
        animLeft = new Animation(300, Assets.player_left);
        
        inventory = new Inventory(handler);
    }

    @Override
    public void tick() {

        //Animations
        animDown.tick();
        animUp.tick();
        animRight.tick();
        animLeft.tick();

        //Movement
        getInput();
        move();
        handler.getGameCamera().CenterOnEntity(this);
        //Inventory
        inventory.tick();
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up) {
            yMove = -speed;
        }
        if (handler.getKeyManager().down) {
            yMove = speed;
        }
        if (handler.getKeyManager().left) {
            xMove = -speed;
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        inventory.render(g);
    }

    public BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
            yMove = 0;
            return animLeft.getCurrentFrame();
        } else if (xMove > 0) {
            yMove = 0;
            return animRight.getCurrentFrame();
        } else if (yMove < 0) {
            xMove = 0;
            return animUp.getCurrentFrame();
        } else if (yMove > 0) {
            xMove = 0;
            return animDown.getCurrentFrame();
        } else {
            return Assets.playerfront;
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    

}
