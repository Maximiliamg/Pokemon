/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.inventory;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import pokemon.Handler;
import pokemon.entities.statics.Pokemon;

public class Inventory {

    private Handler handler;
    private boolean active = false;
    private ArrayList<Pokemon> inventoryPokemon;

    public Inventory(Handler handler) {
        this.handler = handler;
        inventoryPokemon = new ArrayList<Pokemon>();
    }

    public void tick() {
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_I)) {
            active = !active;
        }
        if (!active) {
            return;
        }
        
        System.out.println(inventoryPokemon.size());
    }

    public void render(Graphics g) {
        if (!active) {
            return;
        }
    }
    //Inventory Methods

    public void addPokemon(Pokemon pokemon) {
        inventoryPokemon.add(pokemon);
    }

    //Getters and Setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<Pokemon> getInventoryPokemon() {
        return inventoryPokemon;
    }

    public void setInventoryPokemon(ArrayList<Pokemon> inventoryPokemon) {
        this.inventoryPokemon = inventoryPokemon;
    }

}
