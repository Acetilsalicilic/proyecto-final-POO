package Espacios;
import Calendario.*;

public abstract class Sauna extends Espacio {
    private double temperaturaActual;
    private static double temperaturaMaxima = 80;
    private static double tiempoMax = 20;

    public Sauna(String nombre, int capacidad, Horario horario){ 
        super(nombre, capacidad, horario); 
        this.temperaturaActual = 70.0;
    }

    public void setTemperaturaActual(double temperatura){
        if (temperatura <= temperaturaMaxima){ 
            this.temperaturaActual = temperatura; 
            System.out.println("Temperatura ajustada a " + temperatura + "°C"); 
        }else{
            System.out.println("No se puede superar la temperatura máxima de " + temperaturaMaxima + "°C");
        }
    }



    public double getTemperaturaActual(){
        return temperaturaActual;
    }

    public static double getTemperaturaMaxima(){
        return temperaturaMaxima;
    }

    public static double getTiempoMax(){
        return tiempoMax;
    }
}
