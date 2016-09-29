/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {

    private JFrame frame;
    private String titulo;
    private int width, height;
    private Canvas canvas;

    public Display(String titulo, int width, int height) {
        this.titulo = titulo;
        this.width = width;
        this.height = height;

        crearDisplay();
    }

    private void crearDisplay() {
        frame = new JFrame(titulo);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }
    
    

}
