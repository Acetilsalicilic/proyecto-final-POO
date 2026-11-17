package servicios;

public interface ISujeto {
    public void suscribir(ISuscriptor s);
    public void desuscribir(ISuscriptor s);
    public void notificarTodos();
}
