/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.tiles;

import java.awt.image.BufferedImage;
import pokemon.gfx.Assets;

/**
 *
 * @author MAXIMILIAM GARCIA
 */
public class Mountain1Tile extends Tile{
    
    public Mountain1Tile(int id) {
        super(Assets.mountain1, id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
}
