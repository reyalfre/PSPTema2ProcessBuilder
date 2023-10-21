package procesos;

import procesos.utils.ProcesosUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1Multiple {

    public static void main(String[] args) throws IOException {

        String ruta = ProcesosUtils.RUTA_CLASS;
        String nombreClase = "procesos.ejemplos.HolaProceso";
        String ficheroSalida = "salidaInvocadorMultiple.txt";
        String ficheroError = "errorInvocadorMultiple.txt";

        int numTotalProcesos = 0;

        Scanner lectura = new Scanner(System.in);
        System.out.println("¿Cuántos procesos quieres ejecutar?");
        numTotalProcesos = lectura.nextInt();

        //Creo el ProcessBuilder con la configuracion pero sin el comando
        ProcessBuilder constructorProcesos = new ProcessBuilder();
        constructorProcesos.directory(new File(ruta));
        constructorProcesos.redirectOutput(ProcessBuilder.Redirect.appendTo(new File(ficheroSalida)));
        constructorProcesos.redirectError(ProcessBuilder.Redirect.appendTo(new File(ficheroError)));
        //Bucle de 0 a total procesos
        for (int cont = 0; cont < numTotalProcesos; cont++) {
            constructorProcesos.command("java", nombreClase, String.valueOf(cont));
            constructorProcesos.start();
        }

        System.out.println("La parte del invocador ha terminado");

    }
}
