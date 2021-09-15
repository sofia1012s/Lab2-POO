import java.util.Set;

public class Programa {
    private int bloques;
    private int ciclos;
    private String nombrePrograma;

    public Programa(int opcion,Set<String> programas) {

        switch (opcion) {
            case 1: // Google Chrome
                bloques = 32; //2.07 GB
                ciclos = 8;
                nombrePrograma = "Google Chrome";
                programas.add(nombrePrograma);
                break;

            case 2: // Firefox
                bloques = 1; //0.064 GB
                ciclos = 16;
                nombrePrograma = "Firefox";
                programas.add(nombrePrograma);
                break;

            case 3: // Zoom
                bloques = 5; //0.32 GB
                ciclos = 60;
                nombrePrograma = "Zoom";
                programas.add(nombrePrograma);
                break;

            case 4: // Whatsapp
                bloques = 2; //0.128 GB
                ciclos = 8;
                nombrePrograma = "Whatsapp";
                programas.add(nombrePrograma);
                break;

            case 5: // Telegram
                bloques = 2; //0.128 GB
                ciclos = 8;
                nombrePrograma = "Telegram";
                programas.add(nombrePrograma);
                break;

            case 6: // Visual Studio
                bloques = 5; //0.32 GB
                ciclos = 60;
                nombrePrograma = "Visual Studio";
                programas.add(nombrePrograma);
                break;

            case 7: // Mail
                bloques = 1; //0.032 GB
                ciclos = 15;
                nombrePrograma = "Mail";
                programas.add(nombrePrograma);
                break;

            case 8: // Contactos
                bloques = 1; //0.032 GB
                ciclos = 8;
                nombrePrograma = "Contactos";
                programas.add(nombrePrograma);
                break;

            case 9: // Word
                bloques = 16; //1.024 GB
                ciclos = 10;
                nombrePrograma = "Word";
                programas.add(nombrePrograma);
                break;

            default: // Si es una opción incorrecta
                bloques = 0;
                ciclos = 0;
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
