import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class window extends JFrame implements ActionListener {
    private JPanel pannelMenu;
    private JButton btGioca;
    private  JButton btEsci;
    public window(){
        setTitle("Micai Simulator");
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
        Object o= e.getSource();
        if(o==btEsci){
            setVisible(false);
            dispose();
        }
        if(o==btGioca){
            remove(pannelMenu);

            repaint();

        }
    }


}