import javax.swing.*;
import java.awt.*;

public class Micai extends Personaggio {
    private int dmg=1;
    private double hp=100;

    public Micai(){
        avatar=new JPanel();

    }
    public void add(JPanel p){
        p.add(avatar);
        avatar.setBackground(Color.red);
        avatar.setBounds(0,0,20,40);

    }

    public int getDmg() {
        return dmg;
    }
}
