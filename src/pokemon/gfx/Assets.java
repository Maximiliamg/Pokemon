/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.gfx;

import java.awt.image.BufferedImage;
import pokemon.entities.EntityManager;

public class Assets {

    public static final int width = 15, height = 20, TILEWIDTH = 32, TILEHEIGHT = 32, PKWIDTH = 64, PKHEIGHT = 64;
    public static BufferedImage playerfront, playerback, playerleft, playerright, grass, rock, mountainentrance, fence,
            mountain1, mountain2, mountain3, mountain4, mountain5, sand, water, emoji, bulbasaur, charmander, squirtle;
    public static BufferedImage[] player_down, player_up, player_right, player_left, pokemons;

    public static void init() {
        SpriteSheet player = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));
        SpriteSheet objects = new SpriteSheet(ImageLoader.loadImage("/textures/tiles.png"));
        SpriteSheet pokemon = new SpriteSheet(ImageLoader.loadImage("/PokemonTexture/Pokemons.png"));
        SpriteSheet initial = new SpriteSheet(ImageLoader.loadImage("/PokemonTexture/initials.png"));

        //Player
        playerfront = player.crop(width, 0, width, height);
        playerback = player.crop(width, height, width, height);
        playerleft = player.crop(width, height * 2, width, height);
        playerright = player.crop(width, height * 3, width, height);

        player_down = new BufferedImage[4];
        for (int i = 0; i < 4; i++) {
            player_down[i] = player.crop(width * i, 0, width, height);
        }

        player_up = new BufferedImage[4];
        for (int i = 0; i < 4; i++) {
            player_up[i] = player.crop(width * i, height, width, height);
        }

        player_left = new BufferedImage[4];
        for (int i = 0; i < 4; i++) {
            player_left[i] = player.crop(width * i, height * 2, width, height);
        }

        player_right = new BufferedImage[4];
        for (int i = 0; i < 4; i++) {
            player_right[i] = player.crop(width * i, height * 3, width, height);
        }

        //Map
        grass = objects.crop(0, 0, TILEWIDTH, TILEHEIGHT);
        rock = objects.crop(0, TILEHEIGHT, TILEWIDTH, TILEHEIGHT);
        mountainentrance = objects.crop(TILEWIDTH, 0, TILEWIDTH, TILEHEIGHT);
        fence = objects.crop(2 * TILEWIDTH, 0, TILEWIDTH, TILEHEIGHT);
        mountain1 = objects.crop(TILEWIDTH, TILEHEIGHT, TILEWIDTH, TILEHEIGHT);
        mountain2 = objects.crop(2 * TILEWIDTH, TILEHEIGHT, TILEWIDTH, TILEHEIGHT);
        mountain3 = objects.crop(0, 2 * TILEHEIGHT, TILEWIDTH, TILEHEIGHT);
        mountain4 = objects.crop(TILEWIDTH, 2 * TILEHEIGHT, TILEWIDTH, TILEHEIGHT);
        mountain5 = objects.crop(2 * TILEWIDTH, 2 * TILEHEIGHT, TILEWIDTH, TILEHEIGHT);
        sand = objects.crop(0, 3 * TILEHEIGHT, TILEWIDTH, TILEHEIGHT);
        water = objects.crop(TILEWIDTH, 3 * TILEHEIGHT, TILEWIDTH, TILEHEIGHT);

        //Objects
        //Pokemons
        pokemons = new BufferedImage[11];
        for (int i = 0; i < pokemons.length; i++) {
            pokemons[i] = pokemon.crop(0, PKHEIGHT * i, PKWIDTH, PKHEIGHT);
        }
        bulbasaur = initial.crop(0, 0, PKWIDTH, PKHEIGHT);
        charmander = initial.crop(0, PKHEIGHT, PKWIDTH, PKHEIGHT);
        squirtle = initial.crop(0, PKHEIGHT * 2, PKWIDTH, PKHEIGHT);

    }

}
