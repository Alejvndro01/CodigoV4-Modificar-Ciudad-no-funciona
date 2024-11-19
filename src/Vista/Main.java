package Vista;

import Controlador.Controlador;


public class Main {

    public static void main(String[] args) {
        Ventana ventana=new Ventana();
        Controlador con=new Controlador(ventana);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }    
}
