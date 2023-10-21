package procesos.pipelines;

public class Inicial {

    public static void main(String[] args) {

        String numeroRecibido = args[0];

        try{
            Integer numero = Integer.parseInt(numeroRecibido);
            //Imprimimos en la salida estandar para que se pase al siguiente proceso
            System.out.println(numero);
        }catch(NumberFormatException excepcion){
            System.out.println("No es un numero : " + excepcion);
        }


    }

}
