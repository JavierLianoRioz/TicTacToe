package lianoJavier;

public class Jugador {

        final int[] COORDENADA_BASE = {0,0};

        private String nombre;
        private int simbolo;
        private int fichasEnMano;

        public Jugador(String nombre, int simbolo) {
                this.nombre = nombre;
                this.simbolo = simbolo;
        }

        public boolean noTieneFichas() {
                return fichasEnMano == 0;
        }

        public Coordenada getJugada(Tablero tablero) {
                Coordenada jugada = new Coordenada(0,0);
                jugada.setFila(jugada.pedir(tablero, new int[]{COORDENADA_BASE[0], tablero.getFilas()}));
                jugada.setColumna(jugada.pedir(tablero, new int[]{COORDENADA_BASE[1], tablero.getColumnas()}));
                return jugada;
        }



        public int getFichasEnMano() {
                return fichasEnMano;
        }

        public void setFichasEnMano(int fichasPorJugador) {
                this.fichasEnMano = fichasPorJugador;
        }

        public int getSimbolo() {
                return simbolo;
        }

        public String getNombre() {
                return nombre;
        }

}
