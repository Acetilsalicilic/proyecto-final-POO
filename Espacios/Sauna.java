package Espacios;
public class Sauna extends Espacio {
    private double temperaturaActual;
    private static double temperaturaMaxima = 80;
    private static double tiempoMax = 20;

    public Sauna(String nombre, int capacidad){
        super(nombre, capacidad);
        this.temperaturaActual=0;
    }

    public void setTemperaturaActual(double temperatura){
        this.temperaturaActual=temperatura;
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
