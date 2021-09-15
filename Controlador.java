import java.util.ArrayList;

public class Controlador {
    public static void main(String[] args) {
        Vista view = new Vista();
        Programa programa;
        int tamanoRAM = 0;
        RAM ram = new RAM(tamanoRAM);
        int disponibleRAM;
        int usoRAM;
        ArrayList<Programa> programasActuales;
        ArrayList<Programa> programasIniciales;
        ArrayList<Programa> colaProgramas;

        view.bienvenida();
        int opcion = 0;

        while (opcion != 11) {
            opcion = view.menuOpciones(opcion);

            switch (opcion) {
                case 1:
                    view.nuevaRAM();
                    int tipo = view.tipoRAM();
                    ram = new RAM(tipo);

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

                    int opcion2 = 0;

                    while (opcion2 != 2) {
                        opcion2 = view.opInicioP();
                        int opcion3 = view.inicioPrograma();
                        ram.ingresarProgramasIniciales(opcion3);
                        programasIniciales = ram.getProgramasIniciales();
                    }

                    break;

                case 2:
                    colaProgramas = ram.programasCola(opcion);
                    break;

                case 3:
                    view.memoriaTotal(tamanoRAM);
                    break;

                case 4:
                    programasActuales = ram.programasActuales();
                    usoRAM = programasActuales.size();
                    disponibleRAM = ram.memoriaDisponible(tamanoRAM, usoRAM);
                    view.memoriaDisponible(disponibleRAM);
                    break;

                case 5:
                    break;

                case 6:
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
