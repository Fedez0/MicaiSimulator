import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class window extends JFrame implements ActionListener {
    private static final int resX = 1280;

    private static final int resY = 720;
    private JPanel vitaAttuale;

    private Micai mik;
    private JButton test;
    private JPanel playerPannel;
    private JPanel pannelMenu;
    private JButton btGioca;
    private  JButton btEsci;
    private JButton btMenu;
    private JPanel pannelHUD;


    public window(){
        // input
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);
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


        //titolo 0
        JLabel titolo=new JLabel("Micai Simulator");
        titolo.setFont(new Font("Courier",Font.BOLD,75));
        pannelMenu.add(titolo);
        titolo.setBounds(360,40,575,75);



        //Tasti menu ()
        btGioca=new JButton("Play!");
        btEsci=new JButton("Exit");
        JPanel menu=new JPanel();

        //menu (1)
        pannelMenu.add(menu);
        menu.setBounds(525,330,230,60);

        menu.setBackground(new Color(36,66,138));
        menu.add(btGioca);
        menu.add(btEsci);

        btEsci.addActionListener(this);
        btEsci.setPreferredSize(new Dimension(100,50));
        btGioca.addActionListener(this);
        btGioca.setPreferredSize(new Dimension(100,50));


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
        if(o==test){
            takeDmg(40,vitaAttuale);
        }

    }
    private void guiGioco(){



        //impostazione pannelHUD
        pannelHUD=new JPanel();
        add(pannelHUD);
        pannelHUD.setBackground(new Color(90,82,105));


        // input


        //bottone menu
        btMenu =new JButton("Menu");
        btMenu.setBounds(0,0,60,40);
        btMenu.setBackground(new Color(71,54,97));
        pannelHUD.setBounds(0,0,resX,resY);
        btMenu.addActionListener(this);
        pannelHUD.add(btMenu);

        //inserimento player
        playerPannel=new JPanel();
        pannelHUD.add(playerPannel);

        playerPannel.setBounds(630,290,20,40);
        mik=new Micai();
        mik.add(playerPannel);


        //Barra della vita
        JPanel vitaTotale=new JPanel();
        vitaTotale.setBackground(Color.gray);
        vitaTotale.setBounds(1080,0,200,20);
        vitaAttuale=new JPanel();
        vitaAttuale.setBounds(0,0,200,20);
        vitaAttuale.setBackground(Color.red);
        vitaTotale.add(vitaAttuale);
        pannelHUD.add(vitaTotale);


        test=new JButton("test danno");
        test.setBounds(400,0,200,40 );

        test.addActionListener(this);
        pannelHUD.add(test);




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



    private void takeDmg(int vitaTolta,JPanel vitaAttuale){
        if(vitaTolta>vitaAttuale.getWidth()){
            System.out.println("Coglione");
        }else{
            vitaAttuale.setBounds(0,0,vitaAttuale.getWidth()-vitaTolta,20);
            repaint();
        }

    }

    public class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
            if(KeyEvent.getKeyText(e.getKeyCode()).toString().equals("D")){
                if(playerPannel.getX()<1280-playerPannel.getWidth()*2){
                    playerPannel.setBounds(playerPannel.getX()+ mik.getSpeed(),playerPannel.getY(), playerPannel.getWidth(), playerPannel.getHeight());
                }

            }
            if(KeyEvent.getKeyText(e.getKeyCode()).toString().equals("W")){
                if(playerPannel.getY()>0) {
                    playerPannel.setBounds(playerPannel.getX(), playerPannel.getY() - mik.getSpeed(), playerPannel.getWidth(), playerPannel.getHeight());
                }
            }
            if(KeyEvent.getKeyText(e.getKeyCode()).toString().equals("A")){
                if(playerPannel.getX()>0){
                    playerPannel.setBounds(playerPannel.getX()-mik.getSpeed(),playerPannel.getY(), playerPannel.getWidth(), playerPannel.getHeight());
                }

            }
            if(KeyEvent.getKeyText(e.getKeyCode()).toString().equals("S")){
                if(playerPannel.getY()<720-playerPannel.getHeight()*2){
                    playerPannel.setBounds(playerPannel.getX(),playerPannel.getY()+mik.getSpeed(), playerPannel.getWidth(), playerPannel.getHeight());
                }

            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));





        }
    }
}