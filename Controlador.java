import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Controlador {
    public static void main(String[] args) {
        Vista view = new Vista();
        //Programa programa;
        RAM ram = null;
        int tamanoRAM = 0;
        int disponibleRAM = 0;
        int usoRAM = 0;
        ArrayList<Programa> programasActuales = new ArrayList<Programa>();
        ArrayList<Programa> programasiniciales = new ArrayList<Programa>();
        ArrayList<Programa> colaProgramas = new ArrayList<Programa>();
        Set<String> listaProgramas = new HashSet<>();


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
                        ram.ingresarProgramasIniciales(opcion3, programasiniciales,listaProgramas);
                        opcion2 = view.opInicioP();
                    }
                    ram.ingresarprogramasActuales(programasiniciales, programasActuales);

                    break;

                case 2:
                    break;

                case 3:
                    view.memoriaTotal(tamanoRAM);
                    break;

                case 4:
                    usoRAM = ram.memoriaUso(programasActuales);
                    System.out.println(tamanoRAM);
                    System.out.println(usoRAM);
                    disponibleRAM = ram.memoriaDisponible(tamanoRAM, usoRAM);
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
                    break;

                case 8:
                    break;

                case 9:
                    break;

                case 10:
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
