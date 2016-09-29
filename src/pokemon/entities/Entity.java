/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import pokemon.Game;
import pokemon.Handler;
import pokemon.entities.statics.Pokemon;


public abstract class Entity {
    
    protected Handler handler;
    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;
    
     public Entity(Handler handler, float x, float y, int width, int height){
         this.handler = handler;
         this.x = x;
         this.y =y;
         this.width = width;
         this.height = height;
         
         bounds = new Rectangle(0, 0, width, height);
     }
     
     public abstract void tick();
     
     public abstract void render(Graphics g);
     
     public boolean checkEntityCollisions(float xOffset, float yOffset){
         for(Entity e : handler.getWorld().getEntityManager().getEntities()){
             if (e.equals(this)) {
                 continue;
             }
             if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
                 return true;
             }
         }
         for(Entity e : handler.getWorld().getEntityManager().getPokemons()){
             if (e.equals(this)) {
                 continue;
             }
             if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
                 return true;
             }
         }
         return false;
     }
     
     public Pokemon checkPokemonCollision(float xOffset, float yOffset){
         for(Entity e : handler.getWorld().getEntityManager().getPokemons()){
             if (e.equals(this)) {
                 continue;
             }
             if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
                 return (Pokemon) e;
             }
         }
         return null;
     }
     
     public Rectangle getCollisionBounds(float xOffset, float yOffset){
         return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
     }
     
     //GETTERS AND SETTERS

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
     
     
     
    
}
