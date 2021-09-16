import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;

public class Vista {
    private Scanner scan = new Scanner(System.in);

    public void bienvenida() {
        System.out.println(
                "\n****************************************** Simulador de una RAM ******************************************");
        System.out.println(
                "Bienvenid@ ! A continuacion encontrara distintas opciones para simular el comportamiento de una tarjeta RAM ");
    }

    public int menuOpciones(int opcion) {
        opcion = 0;
        String s = "\nQue desea hacer?\n" + "1. Inicializar todo\n" + "2. Ingresar programas a cola de procesos\n"
                + "3. Ver la cantidad de memoria RAM total\n" + "4. Ver la cantidad de memoria RAM disponible\n"
                + "5. Ver la cantidad de memoria RAM en uso.\n" + "6. Ver los programas en ejecucion.\n"
                + "7. Ver los programas en cola.\n" + "8. Ver los espacios que ocupa un programa particular.\n"
                + "9. Ver estado de memoria (espacios ocupados y espacios en uso).\n"
                + "10. Realizar un ciclo de reloj.\n" + "11. Salir.\n";

        System.out.println(s);
        opcion = scan.nextInt();
        return opcion;
    }

    public void despedida() {
        System.out.println("\nGracias por usar el simulador.\n");
    }

    public void opcionInvalida() {
        System.out.println("Ha elegido una opcion invalida.");
    }

    public void nuevaRAM() {
        System.out.println("\nSe creara una nueva RAM, los datos de la RAM anterior se perderan.");
    }

    public int tipoRAM() {
        int tipo = 0;
        String s = "\nPor favor, escoja un tipo de memoria RAM\n" + "1. SDR\n" + "2. DDR\n";
        System.out.println(s);
        tipo = scan.nextInt();
        return tipo;
    }

    public int tamanoRAM() {
        int tamano = 0;
        String s = "\nCon este tipo de RAM puede escoger su capacidad total, por favor seleccione una opcion:\n"
                + "1. 4 GB\n" + "2. 8 GB\n" + "3. 12 GB\n" + "4. 16 GB\n" + "5. 32 GB\n" + "6. 64 GB\n";
        System.out.println(s);
        tamano = scan.nextInt();
        return tamano;
    }

    public int opInicioP() {
        int op = 0;
        System.out.println(
                "\nDesea agregar un programa u otro programa con el que la RAM se inicie?" + "\n1. Si" + "\n2. No\n");
        op = scan.nextInt();
        return op;
    }

    public int inicioPrograma() {
        int op = 0;
        String s = "\nEscoja un programa: \n" + "1. Google Chrome\n" + "2. Firefox\n" + "3. Zoom\n" + "4. Whatsapp\n"
                + "5. Telegram\n" + "6. Visual Studio\n" + "7. Mail\n" + "8. Contactos\n" + "9. Word\n";
        System.out.println(s);
        op = scan.nextInt();
        return op;
    }

    public int memoriaTotal(int memoriaTotal) {
        int total = (memoriaTotal * 64) / 1024;
        System.out.println("\nMemoria Total" + "\nValor aproximado en GB: " + total);
        return total;
    }

    public int memoriaDisponible(int disponibleRAM) {
        int total = (disponibleRAM * 64) / 1024;
        System.out.println("\nMemoria Disponible" + "\nValor aproximado en GB: " + total);
        return total;
    }

    public int memoriaUsada(int memoriaUsada) {
        int total = (memoriaUsada * 64) / 1024;
        System.out.println("\nMemoria Usada" + "\nValor aproximado en GB: " + total);
        return total;
    }

    public void mostrarProgramas(Set<String> programas) {
        System.out.println("\nLos siguientes programas estan usando actualmente la memoria RAM: \n");
        System.out.println(programas);
    }

    public int nuevoPrograma() {
        int op = 0;
        System.out.println("\nDesea agregar un nuevo programa a la cola" + "\n1. Si" + "\n2. No\n");
        op = scan.nextInt();
        return op;
    }

    public int opPrograma() {
        int op = 0;
        String s = "\nEscoja un programa: \n" + "1. Google Chrome\n" + "2. Firefox\n" + "3. Zoom\n" + "4. Whatsapp\n"
                + "5. Telegram\n" + "6. Visual Studio\n" + "7. Mail\n" + "8. Contactos\n" + "9. Word\n";
        System.out.println(s);
        op = scan.nextInt();
        return op;
    }

    public void mostrarCola(Set<String> programas) {
        System.out.println("\nLos siguientes programas estan esperando ser anadidos a la memoria RAM: \n");
        System.out.println(programas);
    }

    public int opEspacios() {
        int op = 0;
        String s = "\nEscoja el programa del cual desea observar los espacios en la RAM: \n" + "1. Google Chrome\n"
                + "2. Firefox\n" + "3. Zoom\n" + "4. Whatsapp\n" + "5. Telegram\n" + "6. Visual Studio\n" + "7. Mail\n"
                + "8. Contactos\n" + "9. Word\n";
        System.out.println(s);
        op = scan.nextInt();
        return op;
    }

    public void espacios(ArrayList<Programa> programasActuales, int opcion) {
        String nombrePrograma = "";
        int contador = 0;

        switch (opcion) {
            case 1: // Google Chrome
                nombrePrograma = "Google Chrome";
                break;

            case 2: // Firefox
                nombrePrograma = "Firefox";
                break;

            case 3: // Zoom
                nombrePrograma = "Zoom";
                break;

            case 4: // Whatsapp
                nombrePrograma = "Whatsapp";
                break;

            case 5: // Telegram
                nombrePrograma = "Telegram";
                break;

            case 6: // Visual Studio
                nombrePrograma = "Visual Studio";
                break;

            case 7: // Mail
                nombrePrograma = "Mail";
                break;

            case 8: // Contactos
                nombrePrograma = "Contactos";
                break;

            case 9: // Word
                nombrePrograma = "Word";
                break;

            default: // Si es una opción incorrecta
                break;
        }

        for (int i = 0; i < programasActuales.size(); i++) {
            Programa programa = programasActuales.get(i);
            String nombre = programa.nombrePrograma();
            if (nombre == nombrePrograma) {
                contador++;
            }
        }
        System.out.println("\nEl programa ocupa: " + contador + " bloques de la memoria RAM\n");
    }

    public void estadoMemoria(ArrayList<Programa> programasActuales) {
        System.out.println("\nLos espacios de la RAM se encuentran ocupados de la siguiente manera: \n");

        for (int j = 0; j < programasActuales.size(); j++){
            Programa programa = programasActuales.get(j);
            
            String nombre = programa.nombrePrograma();
            System.out.println("[ " + nombre + " ]");
        }
    }

}
