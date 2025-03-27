package v002;

public class TresEnRaya {

    private Tablero tablero;
    private Jugador[] jugadores;
    private Turno turno;

    public TresEnRaya() {
        tablero = new Tablero();
        jugadores = new Jugador[2];
        jugadores[0] = new Jugador('x');
        jugadores[1] = new Jugador('o');
        turno = new Turno();
    }

    public void jugar() {

        do {
            tablero.mostrar();
            jugadores[turno.leToca()].jugar(tablero);
            turno.cambiar();
        } while(!tablero.hayTresEnRaya());
        
        tablero.mostrar();
        jugadores[turno.noLeToca()].celebrar();
    }
}