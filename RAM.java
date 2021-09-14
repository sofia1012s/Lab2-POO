import java.util.ArrayList;

public class RAM {
    private Programa programa;
    private ArrayList<Programa> programasIniciales;
    private ArrayList<Programa> colaProgramas;
    private ArrayList<Programa> programasActuales;
    private int tipo; // SDR = 1, DDR = 2
    private int tamanoTotal; // cantidad en bloques
    private int tamanoDisponible;
    private int tamanoUso;

    private int ciclosReloj = 0;

    public RAM(int t) {
        t = tipo;
    }

    public ArrayList<Programa> ingresarProgramasIniciales(int opcion) {
        programasIniciales.add(new Programa(opcion));
        return programasIniciales;
    }

    public ArrayList<Programa> programasCola(int opcion) {
        colaProgramas.add(new Programa(opcion));
        return colaProgramas;
    }

    public ArrayList<Programa> programasActuales() {
        for (int i = 0; i < programasIniciales.size(); i++) {
            programa = programasIniciales.get(i);
            int bloques = programa.bloques();

            for (int j = 0; j < bloques; j++) {
                programasActuales.add(programa);
            }
        }
        return programasActuales;
    }

    public int memoriaTotal(int t) {
        t = tamanoTotal;
        return tamanoTotal;
    }

    public int memoriaDisponible() {
        tamanoDisponible = tamanoTotal - tamanoUso;
        return tamanoDisponible;
    }

    public int memoriaUso() {
        tamanoUso = programasActuales.size();
        return tamanoUso;
    }

    public int cicloReloj() {
        ciclosReloj++;

        // Actualiza los ciclos de reloj de cada programa activo y busca los que ya
        // finalizaron
        for (int i = 0; i < programasActuales.size(); i++) {
            programa = programasActuales.get(i);
            programa.ciclos();

            if (programa.getCiclos() > ciclosReloj) {
                programasActuales.remove(i);
            }
        }

        // Añado los programas en la cola
        if (tipo == 1) {
            if (tamanoTotal != tamanoUso) {
                for (int i = 0; i < colaProgramas.size(); i++) {
                    programa = colaProgramas.get(i);
                    int bloques = programa.bloques();

                    for (int j = 0; j < bloques; j++) {
                        colaProgramas.add(programa);
                    }
                }
            }

            else {
                // ya no añade los programas
            }

        }

        else if (tipo == 2) {
            for (int i = 0; i < colaProgramas.size(); i++) {
                programa = colaProgramas.get(i);
                int bloques = programa.bloques();

                for (int j = 0; j < bloques; j++) {
                    colaProgramas.add(programa);
                }
            }
        }

        return ciclosReloj;
    }
}
