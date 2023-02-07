import javax.swing.*;

abstract class Personaggio {
    protected int vita = 100;
    protected JPanel avatar;
    protected float speed= 100;


    protected float getSpeed() {
        return speed;
    }

    protected int getVita() {
        return vita;
    }
}
