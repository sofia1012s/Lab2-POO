/******************************************************************************
 * Controlador.java
 * 
 * @author Sofía Salguero
 * @version 17/09/2021 
 * Clase controlador, se encarga de ser el main y realizar
 * las acciones necesarias para tener una interacción entre los modelos y la vista
 ******************************************************************************/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Controlador {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        try{
        Vista view = new Vista();
        // Programa programa;
        RAM ram = null;
        int tamanoRAM = 0;
        int disponibleRAM = 0;
        int usoRAM = 0;
        int ciclosR = 0;
        int tipo = 0;
        ArrayList<Programa> programasActuales = new ArrayList<Programa>();
        ArrayList<Programa> programasiniciales = new ArrayList<Programa>();
        ArrayList<Programa> colaProgramas = new ArrayList<Programa>();
        Set<String> listaProgramas = new HashSet<>();
        Set<String> listaProgramasCola = new HashSet<>();
        Set<String> listaProgramasEliminados = new HashSet<>();

        view.bienvenida();
        int opcion = 0;

        while (opcion != 11) {
            opcion = view.menuOpciones(opcion);

            switch (opcion) {
                case 1:
                    view.nuevaRAM();
                    tipo = view.tipoRAM();

                    while (tipo > 2) {
                        view.opcionInvalida();
                        tipo = view.tipoRAM();
                    }

                    if (tipo == 1) {
                        int op = view.tamanoRAM();

                        while (tipo > 6) {
                            view.opcionInvalida();
                            op = view.tamanoRAM();
                        }

                        switch (op) {
                            case 1: // 4GB
                                tamanoRAM = 64;
                                break;

                            case 2: // 8GB
                                tamanoRAM = 128;
                                break;

                            case 3: // 12GB
                                tamanoRAM = 192;
                                break;

                            case 4: // 16GB
                                tamanoRAM = 256;
                                break;

                            case 5: // 32GB
                                tamanoRAM = 512;
                                break;

                            case 6: // 64GB
                                tamanoRAM = 1024;
                                break;
                            default:
                                break;
                        }
                    }

                    else if (tipo == 2) {
                        tamanoRAM = 64; // Comienza con 4 GB
                    }

                    ram = new RAM(tamanoRAM);
                    programasActuales = new ArrayList<Programa>();
                    programasiniciales = new ArrayList<Programa>();
                    colaProgramas = new ArrayList<Programa>();

                    int opcion2 = 0;
                    opcion2 = view.opInicioP();

                    while (opcion2 > 2) {
                        view.opcionInvalida();
                        opcion2 = view.opInicioP();
                    }

                    while (opcion2 != 2) {
                        int opcion3 = view.inicioPrograma();

                        while (opcion3 > 9) {
                            view.opcionInvalida();
                            opcion3 = view.inicioPrograma();
                        }
                        ram.ingresarProgramasIniciales(opcion3, programasiniciales, listaProgramas);
                        opcion2 = view.opInicioP();
                    }

                    if (tipo == 2) {
                        if (programasiniciales.size() >= tamanoRAM) {
                            tamanoRAM = tamanoRAM * 2;
                            ram.ingresarprogramasActuales(programasiniciales, programasActuales);
                        }

                        else {
                            ram.ingresarprogramasActuales(programasiniciales, programasActuales);
                        }

                        if (programasiniciales.size() < tamanoRAM && tamanoRAM > 64) {
                            tamanoRAM = tamanoRAM / 2;
                            ram.ingresarprogramasActuales(programasiniciales, programasActuales);
                        }

                        else {
                            ram.ingresarprogramasActuales(programasiniciales, programasActuales);
                        }
                    }

                    if (tipo == 1) {

                        if (programasiniciales.size() >= tamanoRAM) {
                            view.memoriaLlena();
                        }

                        else {
                            ram.ingresarprogramasActuales(programasiniciales, programasActuales);
                        }

                    }
                    break;

                case 2:
                    int opcion4 = 0;
                    opcion4 = view.nuevoPrograma();
                    while (opcion4 > 2) {
                        view.opcionInvalida();
                        opcion4 = view.nuevoPrograma();
                    }

                    while (opcion4 != 2) {
                        int opcion5 = view.opPrograma();

                        while (opcion5 > 9) {
                            view.opcionInvalida();
                            opcion5 = view.opPrograma();
                        }

                        ram.ingresarprogramasCola(opcion5, colaProgramas, listaProgramasCola);
                        opcion4 = view.nuevoPrograma();
                    }
                    break;

                case 3:
                    view.memoriaTotal(tamanoRAM);
                    break;

                case 4:
                    usoRAM = ram.memoriaUso(programasActuales);
                    disponibleRAM = ram.memoriaDisponible(tamanoRAM, usoRAM);
                    if (disponibleRAM < 0) {
                        disponibleRAM = 0;
                    }
                    view.memoriaDisponible(disponibleRAM);
                    break;

                case 5:
                    usoRAM = ram.memoriaUso(programasActuales);
                    view.memoriaUsada(usoRAM);
                    break;

                case 6:
                    view.mostrarProgramas(listaProgramas);
                    break;

                case 7:
                    view.mostrarCola(listaProgramasCola);
                    break;

                case 8:
                    int opcion6 = 0;
                    opcion6 = view.opEspacios();
                    while (opcion6 > 9) {
                        view.opcionInvalida();
                        opcion6 = view.opEspacios();
                    }
                    view.espacios(programasActuales, opcion6);
                    break;

                case 9:
                    view.estadoMemoria(programasActuales);
                    break;

                case 10:
                    disponibleRAM = ram.memoriaDisponible(tamanoRAM, usoRAM);
                    view.reloj();
                    listaProgramasEliminados = new HashSet<>();
                    ciclosR = ram.cicloReloj(ciclosR, programasActuales, listaProgramasEliminados,tipo);
                    view.ciclos(ciclosR, programasActuales, listaProgramasEliminados);

                    if (tipo == 2) {
                        if (colaProgramas.size() >= disponibleRAM) {
                            tamanoRAM = tamanoRAM * 2;
                            view.nuevoTamano(tamanoRAM);
                            ram.anadirProgramas(colaProgramas, programasActuales, listaProgramasEliminados,
                                    listaProgramasCola);
                        }

                        else {
                            ram.anadirProgramas(colaProgramas, programasActuales, listaProgramasEliminados,
                                    listaProgramasCola);
                        }

                        if (tamanoRAM >= (programasActuales.size() + colaProgramas.size()) && tamanoRAM > 64) {
                            tamanoRAM = (programasActuales.size() + colaProgramas.size());
                            view.nuevoTamano(tamanoRAM);
                            ram.anadirProgramas(colaProgramas, programasActuales, listaProgramasEliminados,
                                    listaProgramasCola);
                        }

                        else {
                            ram.anadirProgramas(colaProgramas, programasActuales, listaProgramasEliminados,
                                    listaProgramasCola);
                        }
                    }

                    if (tipo == 1) {

                        if (colaProgramas.size() >= disponibleRAM) {
                            view.memoriaLlena();
                        }

                        else {
                            ram.anadirProgramas(colaProgramas, programasActuales, listaProgramas, listaProgramasCola);
                        }
                    }
                    break;

                case 11:
                    view.despedida();
                    break;
                default:
                    view.opcionInvalida();
                    break;
            }
        }
    }
		catch (Exception e){
			System.out.println("Ha ocurrido un error"); 
		}
    }


}
