/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.entities.creatures;

import java.util.Random;
import pokemon.Game;
import pokemon.Handler;
import pokemon.entities.Entity;
import pokemon.entities.statics.Pokemon;
import pokemon.tiles.Tile;

public abstract class Creature extends Entity {

    protected int health;
    protected float speed;
    protected float xMove, yMove;
    public Pokemon pokemonInContact;

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 30,
            DEFAULT_CREATURE_HEIGHT = 40;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move() {
        if (!checkEntityCollisions(xMove, 0f)) {
            moveX();
        } else {
            pokemonInContact = checkPokemonCollision(xMove, yMove);
            System.out.println(pokemonInContact.name);
        }
        if (!checkEntityCollisions(0f, yMove)) {
            moveY();
        } else {
            pokemonInContact = checkPokemonCollision(xMove, yMove);
            System.out.println(pokemonInContact.name);

        }
    }

    public void moveX() {
        if (xMove > 0) {//Moving right

            int tx = (int) ((x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH);

            if (!collisionWithTile(tx, (int) ((y + bounds.y) / Tile.TILEHEIGHT))
                    && !collisionWithTile(tx, (int) ((y + bounds.y + bounds.height) / Tile.TILEHEIGHT))) {
                x += xMove;
            } else {
                x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
            }

        } else if (xMove < 0) {//Moving left
            int tx = (int) ((x + xMove + bounds.x) / Tile.TILEWIDTH);

            if (!collisionWithTile(tx, (int) ((y + bounds.y) / Tile.TILEHEIGHT))
                    && !collisionWithTile(tx, (int) ((y + bounds.y + bounds.height) / Tile.TILEHEIGHT))) {
                x += xMove;
            } else {
                x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
            }
        }
    }

    public void moveY() {
        if (yMove < 0) {// up
            int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

            if ((!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty))
                    && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            } else {
                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
            }
        } else if (yMove > 0) {// down
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

            if ((!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty))
                    && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            } else {
                y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
            }
        }
    }

    protected boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isSolid();
    }

    //Getters y Setters
    public float getxMove() {
        return xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public int getHealth() {
        return health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

}
