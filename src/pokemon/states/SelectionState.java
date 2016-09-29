/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.states;

import java.awt.Graphics;
import pokemon.Handler;
import pokemon.gfx.Assets;
import pokemon.ui.ClickListener;
import pokemon.ui.UIImageButton;
import pokemon.ui.UIManager;


public class SelectionState extends State{
    
    private UIManager uiManager;

    public SelectionState(Handler handler) {
        super(handler);
        
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
        
        uiManager.addObject(new UIImageButton(58, 186, 64*2, 64*2, Assets.bulbasaur, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
                handler.getWorld().getEntityManager().getPlayer().getInventory().addPokemon(handler.getWorld().getEntityManager().getPokemons().get(1));
            }
        }));
        uiManager.addObject(new UIImageButton(186, 186, 64*2, 64*2, Assets.charmander, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
                handler.getWorld().getEntityManager().getPlayer().getInventory().addPokemon(handler.getWorld().getEntityManager().getPokemons().get(4));
            }
        }));
        uiManager.addObject(new UIImageButton(314, 186, 64*2, 64*2, Assets.squirtle, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
                handler.getWorld().getEntityManager().getPlayer().getInventory().addPokemon(handler.getWorld().getEntityManager().getPokemons().get(7));
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
    
}
