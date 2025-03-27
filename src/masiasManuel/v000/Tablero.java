package v000;

class Tablero {

    private char[][] casillas;

    public Tablero() {
        casillas = new char[3][3];

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = '_';
            }
        }
    }

    public void mostrar() {
        cleanScreen();
        System.out.println("  1 2 3");
        for (int i = 0; i < casillas.length; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < casillas[i].length; j++) {
                System.out.print(casillas[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void ponerFicha(Coordenada coordenada, char color) {
        casillas[coordenada.getFila() - 1][coordenada.getColumna() - 1] = color;
    }

    public void sacarFicha(Coordenada coordenada) {
        casillas[coordenada.getFila() - 1][coordenada.getColumna() - 1] = '_';
    }

    public boolean estaOcupado(Coordenada coordenada) {
        return casillas[coordenada.getFila() - 1][coordenada.getColumna() - 1] != '_';
    }

    public boolean estaCompleto(Jugador jugador) {
        int conteoFichas = 0;
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j] == jugador.color()) {
                    conteoFichas++;
                }
            }
        }
        return conteoFichas == 3;
    }

    public boolean hayTresEnRaya() {
        return this.hayTresEnRaya('x') || this.hayTresEnRaya('o');
    }

    private boolean hayTresEnRaya(char color) {
        int[] filas = new int[3];
        int[] columnas = new int[3];
        int diagonal = 0;
        int secundaria = 0;
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (color == casillas[i][j]) {
                    filas[i]++;
                    columnas[j]++;
                    diagonal = diagonal + ((i == j) ? 1 : 0);
                    secundaria = secundaria + ((i + j == 2) ? 1 : 0);

                    if (filas[i] == 3 || columnas[j] == 3 || diagonal == 3 || secundaria == 3) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public boolean estaVacio(Coordenada coordenada) {
        return !estaOcupado(coordenada);
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
