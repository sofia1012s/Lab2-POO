import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Controlador {
    public static void main(String[] args) {
        Vista view = new Vista();
        // Programa programa;
        RAM ram = null;
        int tamanoRAM = 0;
        int disponibleRAM = 0;
        int usoRAM = 0;
        int ciclosR = 0;
        ArrayList<Programa> programasActuales = new ArrayList<Programa>();
        ArrayList<Programa> programasiniciales = new ArrayList<Programa>();
        ArrayList<Programa> colaProgramas = new ArrayList<Programa>();
        Set<String> listaProgramas = new HashSet<>();
        Set<String> listaProgramasCola = new HashSet<>();

        view.bienvenida();
        int opcion = 0;

        while (opcion != 11) {
            opcion = view.menuOpciones(opcion);

            switch (opcion) {
                case 1:
                    view.nuevaRAM();
                    int tipo = view.tipoRAM();

                    if (tipo == 1) {
                        int op = view.tamanoRAM();
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
                    while (opcion2 != 2) {
                        int opcion3 = view.inicioPrograma();
                        ram.ingresarProgramasIniciales(opcion3, programasiniciales, listaProgramas);
                        opcion2 = view.opInicioP();
                    }

                    if (tipo == 2) {
                        if (programasiniciales.size() >= tamanoRAM) {
                            tamanoRAM = tamanoRAM * 2; // 8 GB
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
                    while (opcion4 != 2) {
                        int opcion5 = view.opPrograma();
                        ram.ingresarprogramasCola(opcion5, colaProgramas, listaProgramasCola);
                        opcion4 = view.nuevoPrograma();
                    }
                    break;

                case 3:
                    view.memoriaTotal(tamanoRAM);
                    break;

                case 4:
                    usoRAM = ram.memoriaUso(programasActuales);
                    System.out.println(tamanoRAM);
                    System.out.println(usoRAM);
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
                    view.espacios(programasActuales, opcion6);
                    break;

                case 9:
                    view.estadoMemoria(programasActuales);
                    break;

                case 10:
                    view.reloj();
                    ciclosR = ram.cicloReloj(programasActuales, ciclosR);
                    view.ciclos(ciclosR, programasActuales);
                    break;

                case 11:
                    view.despedida();
                    
                    break;
                default:
                    break;
            }
        }
    }
}
