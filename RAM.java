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
        t = tamanoTotal;
        programasIniciales = new ArrayList<Programa>();
        colaProgramas = new ArrayList<Programa>();
        programasActuales = new ArrayList<Programa>();
    }

    public void ingresarProgramasIniciales(int opcion, ArrayList<Programa> programasI) {
        programasI.add(new Programa(opcion));
    }

    public ArrayList<Programa> getProgramasIniciales() {
        return programasIniciales;
    }

    public void ingresarprogramasCola(int opcion) {
        colaProgramas.add(new Programa(opcion));
    }

    public ArrayList<Programa> getProgramasCola() {
        return colaProgramas;
    }

    public void ingresarprogramasActuales(ArrayList<Programa> programasI, ArrayList<Programa> programasA) {
        for (int i = 0; i < programasI.size(); i++) {
            programa = programasI.get(i);
            int bloques = programa.bloques();

            for (int j = 0; j < bloques; j++) {
                programasA.add(programa);
            }
        }
    }

    public ArrayList<Programa> getProgramasActuales() {
        return programasActuales;
    }

    public int getmemoriaTotal() {
        return tamanoTotal;
    }

    public int memoriaDisponible(int tamanoTotal, int tamanoUso) {
        tamanoDisponible = tamanoTotal - tamanoUso;
        return tamanoDisponible;
    }

    public int memoriaUso(ArrayList<Programa> programasA) {
        tamanoUso = programasA.size();
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
