package procesos.ejemplos;

import procesos.utils.ProcesosUtils;

import java.io.File;
import java.io.IOException;

public class Invocador {

    public static void main(String[] args) {

        String ruta = ProcesosUtils.RUTA_CLASS;
        String nombreClase = "procesos.ejemplos.HolaProceso";
        String ficheroSalida = "salidaInvocador.txt";
        String ficheroError = "errorInvocador.txt";
        int numeroArgumento = 9;

        ProcessBuilder constructorProcesos = new ProcessBuilder("java", nombreClase, String.valueOf(numeroArgumento));


        constructorProcesos.directory(new File(ruta));
        constructorProcesos.redirectOutput(ProcessBuilder.Redirect.appendTo(new File(ficheroSalida)));
        constructorProcesos.redirectError(ProcessBuilder.Redirect.appendTo(new File(ficheroError)));

        try {
            constructorProcesos.start();
        } catch (IOException e) {
            System.out.println("Ha habido un error: " + e);
            throw new RuntimeException(e);
        }


        System.out.println("La parte del invocador ha terminado");

    }
}
