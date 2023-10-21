package procesos.ejemplos;

public class HolaProceso {

    public static void main(String[] args) {

        String argumento =args[0];

        Integer numero = 0;
        try {
            numero = Integer.parseInt(argumento);
        }catch (NumberFormatException exception){
            System.out.println("Error al parsear el argumento");
            throw exception;
        }

        System.out.println("HolaProceso-. El numero es: "+ numero);
    }
}
