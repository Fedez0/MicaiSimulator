import javax.swing.*;

abstract class Personaggio {
    protected int vita = 100;
    protected JPanel avatar;
    protected int speed= 10;


    protected int getSpeed() {
        return speed;
    }

    protected int getVita() {
        return vita;
    }
}
