package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class window extends JFrame implements ActionListener {
    private JPanel pannelMain;
    public window(){
        this.setTitle("Micai simulator");
        gui();
        impostaLookAndFeel();
        setVisible(true);
    }
    private void gui(){


        //impostazioni della finestra
        setResizable(false);
        setSize(new Dimension(1280,720));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //background
        Image background =Toolkit.getDefaultToolkit().getImage("C:\\Users\\Windows\\Pictures\\Saved Pictures\\avatar\\7e197f016c320b0ea20409ab0d848824.jpg");
        //finisci


        pannelMain=new JPanel();
        add(pannelMain);
        pannelMain.setLayout(null);


        pannelMain.setBackground(new Color(83,125,224));


        //titolo
        JLabel titolo=new JLabel("Micai simulator");
        titolo.setFont(new Font("Courier",Font.BOLD,100));
        pannelMain.add(titolo);
        titolo.setBounds(280,100,1240,150);



        //Tasti menu
        JButton btGioca=new JButton("Play!");
        JButton btEsci=new JButton("Exit");
        btGioca.setPreferredSize(new Dimension(100, 60));
        btEsci.setPreferredSize(new Dimension(100, 60));
        btGioca.setFont(new Font("Courier",Font.BOLD,20));
        btEsci.setFont(new Font("Courier",Font.BOLD,20));

        JPanel menu=new JPanel();
        pannelMain.add(menu);
        menu.setBounds(490,300,300,100);

        menu.setBackground(new Color(83,125,224));
        menu.add(btGioca);
        menu.add(btEsci);
        btGioca.play
        btEsci.addActionListener(this);
        //icona
        Image icon=Toolkit.getDefaultToolkit().getImage("C:\\Users\\Windows\\Pictures\\Saved Pictures\\avatar\\7e197f016c320b0ea20409ab0d848824.jpg");
        setIconImage(icon);

    }
    private void impostaLookAndFeel() {
        try {
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
        } catch (Exception e) {}
    }
    @Override
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        dispose();
    }

    public void play extends JButton(ActionEvent e){
        pannelMain=null;
    }
}
