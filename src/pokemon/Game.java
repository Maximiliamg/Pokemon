/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import pokemon.states.GameState;
import pokemon.states.MenuState;
import pokemon.states.SettingsState;
import pokemon.states.State;
import pokemon.gfx.Assets;
import pokemon.display.Display;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import pokemon.gfx.GameCamera;
import pokemon.input.KeyManager;
import pokemon.input.MouseManager;
import pokemon.states.SelectionState;

public class Game implements Runnable {

    private Display display;
    private int width, height;
    public String titulo;

    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    //States
    public State gameState;
    public State menuState;
    public State settingsState;
    public State selectionState;
    
    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;
    
    //Camera
    private GameCamera gameCamera;
    
    //Handler
    private Handler handler;

    public Game(String titulo, int width, int height) {
        this.height = height;
        this.width = width;
        this.titulo = titulo;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    private void init() {
        display = new Display(titulo, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        
        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);

        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        settingsState = new SettingsState(handler);
        selectionState = new SelectionState(handler);

        State.setState(menuState);
    }

    private void tick() {
        keyManager.Tick();
        if (State.getState() != null) {
            State.getState().tick();
        }
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        g.clearRect(0, 0, width, height);
        //Pinta
        
        if (State.getState() != null) {
            State.getState().render(g);
        }

        //Deja de pintar
        bs.show();
        g.dispose();
    }

    public void run() {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames:" + ticks);
                ticks = 0;
                timer = 0;

            }

        }

        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (running == false) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
