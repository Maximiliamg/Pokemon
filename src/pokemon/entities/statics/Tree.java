/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.entities.statics;

import java.awt.Color;
import java.awt.Graphics;
import jdk.internal.dynalink.beans.StaticClass;
import pokemon.Handler;
import pokemon.gfx.Assets;
import pokemon.tiles.Tile;


public class Tree extends StaticEntity{

    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
        
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = width*2-20;
        bounds.height = width*2-20;
    }

    @Override
    public void tick() {
       
    }

    @Override
    public void render(Graphics g) {
     g.drawImage(Assets.emoji, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width*2, width*2, null);
     
//     g.setColor(Color.red);
//     g.drawRect((int)(x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width*2-10, width*2-10);
    }
    
}
