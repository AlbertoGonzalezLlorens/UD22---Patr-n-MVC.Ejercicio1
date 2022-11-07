package mainApp;

import models.Modelo;
import views.Vista;
import controllers.Controlador;

public class App 
{
    public static void main( String[] args )
    {
        Modelo modelo = new Modelo();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(modelo,vista);
        controlador.iniciarVista();
    }
}
