/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.tiles;

import java.awt.image.BufferedImage;
import pokemon.gfx.Assets;

public class MountainEntranceTile extends Tile {

    public MountainEntranceTile(int id) {
        super(Assets.mountainentrance, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
