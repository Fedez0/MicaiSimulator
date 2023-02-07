import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class window extends JFrame implements ActionListener {
    private static final int resX = 1280;

    private static final int resY = 720;

    private JPanel pannelMenu;
    private JButton btGioca;
    private  JButton btEsci;
    private JButton btMenu;
    private JPanel pannelHUD;
    public window(){
        setTitle("Micai Simulator");
        impostaFinestra();
        gui();
        impostaLookAndFeel();
        setVisible(true);
    }
    private void gui(){

        //impostazioni della finestra


        //finisci


        pannelMenu =new JPanel();
        add(pannelMenu);
        pannelMenu.setLayout(null);


        pannelMenu.setBackground(new Color(83,125,224));


        //titolo
        JLabel titolo=new JLabel("Micai Simulator");
        titolo.setFont(new Font("Courier",Font.BOLD,75));
        pannelMenu.add(titolo);
        titolo.setBounds(375,0,1240,150);



        //Tasti menu
        btGioca=new JButton("Play!");
        btEsci=new JButton("Exit");
        JPanel menu=new JPanel();
        pannelMenu.add(menu);
        menu.setBounds(550,300,175,40);

        menu.setBackground(new Color(36,66,138));
        menu.add(btGioca);
        menu.add(btEsci);

        btEsci.addActionListener(this);
        btGioca.addActionListener(this);
        //icona

        repaint();

    }
    private void impostaLookAndFeel() {
        try {
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
        } catch (Exception e) {}
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object o= e.getSource();
        if(o==btEsci){
            setVisible(false);
            dispose();
        }
        if(o==btGioca){
            remove(pannelMenu);
            guiGioco();
            repaint();
        }
        if(o== btMenu){
            remove(pannelHUD);
            add(pannelMenu);
            repaint();
        }
    }
    private void guiGioco(){
        //impostazione pannelHUD
        pannelHUD=new JPanel();
        add(pannelHUD);
        pannelHUD.setBackground(new Color(90,82,105));

        //bottone menu
        btMenu =new JButton("Menu");
        btMenu.setBounds(0,0,60,40);
        pannelHUD.setBounds(0,0,resX,resY);
        btMenu.addActionListener(this);
        pannelHUD.add(btMenu);


    }
    private void impostaFinestra(){
        setResizable(false);
        setSize(new Dimension(resX,resY));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //background
        Image background =Toolkit.getDefaultToolkit().getImage("C:\\Users\\Windows\\Pictures\\Saved Pictures\\avatar\\7e197f016c320b0ea20409ab0d848824.jpg");

        Image icon=Toolkit.getDefaultToolkit().getImage("C:\\Users\\Windows\\Pictures\\Saved Pictures\\avatar\\7e197f016c320b0ea20409ab0d848824.jpg");
        setIconImage(icon);
    }

}