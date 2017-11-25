package pruebas;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

public class ControlTeclas implements KeyListener {

    private static HashSet<Integer> teclasPresionadas;

    public ControlTeclas(){
        teclasPresionadas = new HashSet<Integer>();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        teclasPresionadas.add(e.getKeyCode());
        //System.out.println("tecla presionada");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclasPresionadas.remove(e.getKeyCode());
    }

    public static HashSet<Integer> getActiveKeys(){
        return teclasPresionadas;
    }
}
