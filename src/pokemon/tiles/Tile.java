/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

    //Static
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile mountainEntranceTile = new MountainEntranceTile(1);
    public static Tile rockTile = new RockTile(2);
    public static Tile fenceTile = new FenceTile(3);
    public static Tile mountain1Tile = new Mountain1Tile(4);
    public static Tile mountain2Tile = new Mountain2Tile(5);
    public static Tile mountain3Tile = new Mountain3Tile(6);
    public static Tile mountain4Tile = new Mountain4Tile(7);
    public static Tile mountain5Tile = new Mountain5Tile(10);
    public static Tile sandTile = new SandTile(9);
    public static Tile waterTile = new WaterTile(8);

    //Class
    public static final int TILEWIDTH = 32, TILEHEIGHT = 32;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid() {
        return false;
    }

    public int getId() {
        return id;
    }

}
