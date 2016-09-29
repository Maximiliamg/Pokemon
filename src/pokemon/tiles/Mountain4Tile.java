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
public class Mountain4Tile extends Tile{
    
    public Mountain4Tile(int id) {
        super(Assets.mountain4, id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
}
