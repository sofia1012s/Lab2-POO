public class Programa {
    private String[] programas = { "Google Chrome", "Firefox", "Zoom", "Whatsapp", "Telegram", "Visual Studio", "Mail",
            "Contactos", "Words" };
    private int bloques;
    private int ciclos;
    private String nombrePrograma;

    public Programa(int opcion, int bl, int c, String pr) {
        bl = bloques;
        c = ciclos;
        pr = nombrePrograma;

        switch (opcion) {
            case 0: // Google Chrome
                bl = 32;
                c = 8;
                pr = programas[0];
                break;

            case 1: // Firefox
                bl = 1;
                c = 16;
                pr = programas[1];
                break;

            case 2: // Zoom
                bl = 5;
                c = 60;
                pr = programas[2];
                break;

            case 3: // Whatsapp
                bl = 2;
                c = 8;
                pr = programas[3];
                break;

            case 4: // Telegram
                bl = 2;
                c = 8;
                pr = programas[4];
                break;

            case 5: // Visual Studio
                bl = 5;
                c = 60;
                pr = programas[5];
                break;

            case 6: // Mail
                bl = 1;
                c = 15;
                pr = programas[6];
                break;

            case 7: // Contactos
                bl = 1;
                c = 8;
                pr = programas[7];
                break;

            case 8: // Word
                bl = 16;
                c = 10;
                pr = programas[8];
                break;

            default: // Si es una opción incorrecta
                bl = 0;
                c = 0;
                pr = "";
                break;
        }
    }

    public int bloques() {
        return bloques;

    }

    public int ciclos() {
        return ciclos;
    }

    public String nombrePrograma() {
        return nombrePrograma;

    }
}
