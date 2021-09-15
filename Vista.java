import java.util.Scanner;

public class Vista {
    private Scanner scan = new Scanner(System.in);

    public void bienvenida() {
        System.out.println("\n****************************************** Simulador de una RAM ******************************************");
        System.out.println(
                "Bienvenid@ ! A continuacion encontrara distintas opciones para simular el comportamiento de una tarjeta RAM ");
    }

    public int menuOpciones(int opcion) {
        opcion = 0;
        String s = "\nQue desea hacer?\n" + "1. Inicializar todo\n" + "2. Ingresar programas a cola de procesos\n"
                + "3. Ver la cantidad de memoria RAM total\n" + "4. Ver la cantidad de memoria RAM disponible\n"
                + "5. Ver la cantidad de memoria RAM en uso.\n" + "6. Ver los programas en ejecución.\n"
                + "7. Ver los programas en cola.\n" + "8. Ver los espacios que ocupa un programa particular.\n"
                + "9. Ver estado de memoria (espacios ocupados y espacios en uso).\n"
                + "10. Realizar un ciclo de reloj.\n" + "11. Salir.\n";

        System.out.println(s);
        opcion = scan.nextInt();
        return opcion;
    }

    public void despedida() {
        System.out.println("\nGracias por usar el simulador.");
    }

    public void opcionInvalida() {
        System.out.println("Ha elegido una opcion invalida.");
    }

    public void nuevaRAM() {
        System.out.println("\nSe creará una nueva RAM, los datos de la RAM anterior se perderán.");
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
        String s = "\nCon este tipo de RAM puede escoger su capacidad total, por favor escriba alguna de estas opciones (unicamente el numero):\n"
                + "4 GB, 8GB, 12GB, 16GB, 32GB, 64GB";
        System.out.println(s);
        tamano = scan.nextInt();
        return tamano;
    }

    public int opInicioP() {
        int op = 0;
        System.out.println("\n ¿Desea agregar un programa con el que la RAM se inicie?" + "\n1. Si" + "\n2. No");
        op = scan.nextInt();
        return op;
    }

}
