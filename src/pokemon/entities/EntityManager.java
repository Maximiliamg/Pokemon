/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import pokemon.Handler;
import pokemon.entities.creatures.Player;
import pokemon.entities.statics.Pokemon;
import pokemon.utils.Utils;

public class EntityManager {

    public int pkNumber;
    private String[][] pkData;
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;
    private ArrayList<Pokemon> pokemons;
    private Comparator<Entity> renderSorter = new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if (a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
                return -1;
            } else {
                return 1;
            }
        }

    };

    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        pokemons = new ArrayList<Pokemon>();
        entities = new ArrayList<Entity>();
        addEntity(player);
        loadPokemons();
    }

    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            e.tick();
        }
        entities.sort(renderSorter);
    }

    public void render(Graphics g) {
        for (Entity e : entities) {
            e.render(g);
        }
        for (Entity e : pokemons) {
            e.render(g);
        }
    }

    public void addPokemons(Pokemon e) {
        pokemons.add(e);
    }

    public void loadPokemons() {
        String file = Utils.loadFileAsString("res/PokemonData/pokemons.txt");
        String[] tokens = file.split("\\s+");
        pkNumber = Utils.parseInt(tokens[0]);
        pkData = new String[pkNumber][6];
        int t = 1;
        for (int i = 0; i < pkNumber; i++) {
            for (int j = 0; j < 6; j++) {
                pkData[i][j] = tokens[t];
                t++;
            }
        }
//        for (int i = 0; i < pkNumber; i++) {
//            for (int j = 0; j < 6; j++) {
//                System.out.println(pkData[i][j]);
//            }
//        }
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    //GETTERS AND SETTERS
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public String[][] getPkData() {
        return pkData;
    }

    public void setPkData(String[][] pkData) {
        this.pkData = pkData;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
    

}
