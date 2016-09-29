/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.states;

import java.awt.Graphics;
import pokemon.Game;
import pokemon.Handler;
import pokemon.entities.creatures.Player;
import pokemon.entities.statics.Tree;
import pokemon.gfx.Assets;
import pokemon.tiles.Tile;
import pokemon.world.World;

public class GameState extends State {

   // private Player player;
    private World world;


    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "res/worlds/world1.txt");
        handler.setWorld(world);
       // player = new Player(handler, 928, 1824);
    }

    @Override
    public void tick() {
        world.tick();
      //  player.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
     //   player.render(g);
    }

}
