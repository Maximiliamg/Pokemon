/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.entities.statics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import pokemon.Handler;
import pokemon.attacks.Attack;
import pokemon.attacks.AttackManager;
import pokemon.entities.creatures.Creature;
import pokemon.entities.statics.StaticEntity;
import pokemon.gfx.Assets;
import pokemon.utils.Utils;

public class Pokemon extends StaticEntity {

    protected int attack, defense, health, atk;
    private int code;
    public String name;
    private BufferedImage image;
    private AttackManager attackManager;

    public Pokemon(Handler handler, float x, float y, int code, String name, int attack, int defense, int health, int atk) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.code = code;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.name = name;
        this.atk = atk;
        attackManager = new AttackManager(handler);
        

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 64;
        bounds.height = 64;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        for (int i = 0; i < Assets.pokemons.length; i++) {
            if (i == code) {

                g.drawImage(Assets.pokemons[i], (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), Assets.PKWIDTH, Assets.PKHEIGHT, null);

            }
        }
        //g.setColor(Color.red);
        //g.drawRect((int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), 64, 64);
    }

    public Attack identifyAttack() {
        return attackManager.getAttacks().get(atk);
    }

    //Getters and Setters
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    
}
