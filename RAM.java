
/******************************************************************************
 * RAM.java
 * 
 * @author Sofía Salguero
 * @version 17/09/2021 
 * Clase RAM, se encarga de realizar todas las acciones de la RAM y configurar 
 * sus parámetros
 ******************************************************************************/
import java.util.ArrayList;
import java.util.Set;

public class RAM {
    private Programa programa;
    private ArrayList<Programa> programasIniciales;
    private ArrayList<Programa> colaProgramas;
    private ArrayList<Programa> programasActuales;
    private int tamanoTotal; // cantidad en bloques
    private int tamanoDisponible;
    private int tamanoUso;

    /**
     * 
     * @param t
     */
    public RAM(int t) {
        t = tamanoTotal;
        programasIniciales = new ArrayList<Programa>();
        colaProgramas = new ArrayList<Programa>();
        programasActuales = new ArrayList<Programa>();
    }

    /**
     * @param opcion
     * @param programasI
     * @param programas
     */
    public void ingresarProgramasIniciales(int opcion, ArrayList<Programa> programasI, Set<String> programas) {
        programasI.add(new Programa(opcion, programas));
    }

    /**
     * @param opcion
     * @param programasC
     * @param programas
     */
    public void ingresarprogramasCola(int opcion, ArrayList<Programa> programasC, Set<String> programas) {
        programasC.add(new Programa(opcion, programas));
    }

    /**
     * @param programasI
     * @param programasA
     */
    public void ingresarprogramasActuales(ArrayList<Programa> programasI, ArrayList<Programa> programasA) {
        for (int i = 0; i < programasI.size(); i++) {
            programa = programasI.get(i);
            int bloques = programa.bloques();

            for (int k = 0; k < bloques; k++) {
                programasA.add(programa);
            }
        }
    }

    /**
     * @param tamanoTotal
     * @param tamanoUso
     * @return int
     */
    public int memoriaDisponible(int tamanoTotal, int tamanoUso) {
        tamanoDisponible = tamanoTotal - tamanoUso;
        return tamanoDisponible;
    }

    /**
     * @param programasA
     * @return int
     */
    public int memoriaUso(ArrayList<Programa> programasA) {
        tamanoUso = programasA.size();
        return tamanoUso;
    }

    /**
     * @param ciclosR
     * @param programasA
     * @param programasEliminados
     * @param tipo
     * @return int
     */
    public int cicloReloj(int ciclosR, ArrayList<Programa> programasA, Set<String> programasEliminados, int tipo) {
        if (tipo == 1) {
            ciclosR++;

        } else {
            ciclosR = ciclosR + 2;

        }

        for (int i = programasA.size() - 1; i > 0; i--) {
            Programa programa = programasA.get(i);
            int ciclos = programa.getCiclos();
            String nombre = programa.nombrePrograma();
            int ciclosRestante = ciclos - ciclosR;

            if (ciclosRestante == 0) {
                programasA.remove(i);
                programasEliminados.add(nombre);
            }
        }

        return ciclosR;
    }

    /**
     * @param programasC
     * @param programasA
     * @param programasCorriendo
     * @param programasCola
     */
    public void anadirProgramas(ArrayList<Programa> programasC, ArrayList<Programa> programasA,
            Set<String> programasCorriendo, Set<String> programasCola) {
        for (int k = 0; k < programasC.size(); k++) {
            Programa programa = programasC.get(k);
            int bloques = programa.bloques();
            String nombre = programa.nombrePrograma();

            programasC.remove(k);
            programasCorriendo.add(nombre);
            programasCola.remove(nombre);

            for (int j = 0; j < bloques; j++) {
                programasA.add(programa);
            }
        }
    }
}
