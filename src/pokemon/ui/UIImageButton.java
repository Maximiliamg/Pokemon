/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {

    private BufferedImage[] images;
    private BufferedImage image;
    private ClickListener clicker;
    private boolean sw = true;

    public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
        super(x, y, width, height);
        sw = false;
        this.images = images;
        this.clicker = clicker;
        
    }

    public UIImageButton(float x, float y, int width, int height, BufferedImage image, ClickListener clicker) {
        super(x, y, width, height);
        sw = true;
        this.image = image;
        this.clicker = clicker;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        if (sw == false) {
            if (hovering) {
                g.drawImage(images[1], (int) x, (int) y, width, height, null);
            } else {
                g.drawImage(images[0], (int) x, (int) y, width, height, null);
            }
        }else{
            g.drawImage(image, (int) x, (int) y, width, height, null);
        }
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }

}
