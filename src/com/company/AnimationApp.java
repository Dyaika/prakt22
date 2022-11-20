package com.company;

import javax.swing.*;
import java.awt.*;

public class AnimationApp extends JFrame {
    private ImageIcon[] images;
    private JPanel panel;
    private JLabel curImageLabel;
    private static int frame = 0;

    //грузим картинки в массив
    public void loadImages(){
        images = new ImageIcon[15];
        var cwd = System.getProperty("user.dir");
        for (int i = 1; i < 16; i++){
            images[i-1] = new ImageIcon(cwd + "/src/com/company/" + i + ".jpg");
        }
    }

    public AnimationApp() throws HeadlessException {
        super("Показываем картинку");

        loadImages();
        panel = new JPanel();
        loadImages();
        setSize(300, 300);
        curImageLabel = new JLabel(images[frame]);
        panel.add(curImageLabel);
        add(panel);
        // помещаем окно в центре экрана
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    //смена 1 кадра
    public void changeFrame(){
        frame++;
        if (frame>= 15){
            frame = 0;
        }
        curImageLabel.setIcon(images[frame]);
        repaint();
    }

    //анимация
    public void kino(){
        while (true){

            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            changeFrame();
        }
    }
}
