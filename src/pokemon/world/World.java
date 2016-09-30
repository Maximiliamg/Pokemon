/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.world;

import java.awt.Graphics;
import java.util.Random;
import pokemon.Game;
import pokemon.Handler;
import pokemon.attacks.Attack;
import pokemon.attacks.AttackManager;
import pokemon.entities.EntityManager;
import pokemon.entities.creatures.Player;
import pokemon.entities.statics.Pokemon;
import pokemon.entities.statics.Tree;
import pokemon.tiles.Tile;
import pokemon.utils.Utils;

public class World {

    private Handler handler;
    private int width, height;
    private int SpawnX, SpawnY;
    private int[][] tiles;
    public int randX, randY;
    //Entities
    private EntityManager entityManager;
    private AttackManager attackManager;
    Pokemon pokemon;

    public World(Handler handler, String path) {
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));
        attackManager = new AttackManager(handler);

        loadWorld(path);
        //Entity adding
        for (int i = 0; i < entityManager.pkNumber; i++) {
            randomSpawn();
            entityManager.addPokemons(new Pokemon(handler, randX, randY,
                    Utils.parseInt(entityManager.getPkData()[i][1]),
                    entityManager.getPkData()[i][0],
                    Utils.parseInt(entityManager.getPkData()[i][2]),
                    Utils.parseInt(entityManager.getPkData()[i][3]),
                    Utils.parseInt(entityManager.getPkData()[i][4]),
                    Utils.parseInt(entityManager.getPkData()[i][5])));
        }
        
        entityManager.getPlayer().setX(SpawnX);
        entityManager.getPlayer().setY(SpawnY);
        
    }

    public void tick() {
        entityManager.tick();
    }

    public void render(Graphics g) {

        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth() / Tile.TILEWIDTH + 1));
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, handler.getGameCamera().getyOffset() + handler.getHeight() / Tile.TILEHEIGHT + 1);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
        //Entities
        entityManager.render(g);
    }

    public Tile getTile(int x, int y) {

        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.fenceTile;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) {
            return Tile.fenceTile;
        }
        return t;
    }

    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        SpawnX = Utils.parseInt(tokens[2]);
        SpawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

    public void randomSpawn() {
        Random random = new Random();
        randX = random.nextInt(width) * 32;
        randY = random.nextInt(height) * 32;
        while (!validTile((int) randX, (int) randY)) {
            if (!validTile((int) randX, (int) randY)) {
                randX = random.nextInt(width) * 32;
                randY = random.nextInt(height) * 32;
            }
        }
    }

    public boolean validTile(int x, int y) {
        if (Tile.tiles[tiles[x / 32][y / 32]].isSpawneable() == true) {
            return true;
        }
        return false;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
