public class Controlador {
    public static void main(String[] args) {
        Vista view = new Vista();
        Programa programa;
        RAM ram;

        view.bienvenida();
        int opcion = 0;

        while (opcion != 11) {
            opcion = view.menuOpciones(opcion);
            
            switch (opcion) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }
        }
    }
}
