/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.states;

import java.awt.Color;
import java.awt.Graphics;
import pokemon.Game;
import pokemon.Handler;
import pokemon.gfx.Assets;
import pokemon.ui.ClickListener;
import pokemon.ui.UIImageButton;
import pokemon.ui.UIManager;
import pokemon.ui.UITextLable;

public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        //handler.getMouseManager().setUIManager(uiManager);
        
        uiManager.addObject(new UITextLable(100, 100, 100, 100, "PRESS ENTER TO START", 32));
        
        
    }

    @Override
    public void tick() {
        if (handler.getKeyManager().enter) {
            State.setState(handler.getGame().selectionState);
        }
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }

}
