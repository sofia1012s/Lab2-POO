public class Programa {
    private String[] programas = { "Google Chrome", "Firefox", "Zoom", "Whatsapp", "Telegram", "Visual Studio", "Mail",
            "Contactos", "Word" };
    private int bloques;
    private int ciclos;
    private String nombrePrograma;

    public Programa(int opcion) {

        switch (opcion) {
            case 1: // Google Chrome
                bloques = 32;
                ciclos = 8;
                nombrePrograma = programas[0];
                break;

            case 2: // Firefox
                bloques = 1;
                ciclos = 16;
                nombrePrograma = programas[1];
                break;

            case 3: // Zoom
                bloques = 5;
                ciclos = 60;
                nombrePrograma = programas[2];
                break;

            case 4: // Whatsapp
                bloques = 2;
                ciclos = 8;
                nombrePrograma = programas[3];
                break;

            case 5: // Telegram
                bloques = 2;
                ciclos = 8;
                nombrePrograma = programas[4];
                break;

            case 6: // Visual Studio
                bloques = 5;
                ciclos = 60;
                nombrePrograma = programas[5];
                break;

            case 7: // Mail
                bloques = 1;
                ciclos = 15;
                nombrePrograma = programas[6];
                break;

            case 8: // Contactos
                bloques = 1;
                ciclos = 8;
                nombrePrograma = programas[7];
                break;

            case 9: // Word
                bloques = 16;
                ciclos = 10;
                nombrePrograma = programas[8];
                break;

            default: // Si es una opción incorrecta
                bloques = 0;
                ciclos = 0;
                nombrePrograma = "";
                break;
        }
    }

    public int bloques() {
        return bloques;

    }

    public void ciclos() {
        ciclos++;
    }

    public int getCiclos() {
        return ciclos;
    }

    public String nombrePrograma() {
        return nombrePrograma;

    }
}
