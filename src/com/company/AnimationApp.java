package com.company;

import javax.swing.*;
import java.awt.*;

public class AnimationApp extends JFrame {
    private Image[] images;
    private JLabel label;
    public void loadImages(){
        images = new Image[15];
        for (int i = 1; i < 16; i++){
            images[i-1] = new ImageIcon(i + ".jpg").getImage();
        }
    }

    public AnimationApp() throws HeadlessException {
        super("Animation");
        setLayout(null);
        setSize(700, 350);
        loadImages();
        label = new JLabel(new ImageIcon(images[0]));
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
