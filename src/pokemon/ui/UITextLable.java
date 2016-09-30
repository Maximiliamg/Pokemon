/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.ui;

import java.awt.Font;
import java.awt.Graphics;


public class UITextLable extends UIObject{
    
    private String text;
    private int size;

    public UITextLable(float x, float y, int width, int height, String text, int size) {
        super(x * 32, y * 32, width, height);
        this.text = text;
        this.size = size;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, size));
        g.drawString(text,(int) x,(int) y);
        
    }

    @Override
    public void onClick() {
        
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
    
}
