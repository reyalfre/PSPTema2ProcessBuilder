package procesos.ejemplos;

import procesos.utils.ProcesosUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LanzarComandoFree {

    public static void main(String[] args) {

//        String rutaFicheroSalida = "salidaFree.txt";
        ProcessBuilder constructorProcesos = new ProcessBuilder();

        //"bash","-c", "ping google.com"

        //Linux:
        //constructorProcesos.command("free");
        //Windows:
        constructorProcesos.command("tasklist");
//        constructorProcesos.redirectOutput(ProcessBuilder.Redirect.appendTo(new File(rutaFicheroSalida)));

        try {
            //Lanzar el hijo
            Process hijo = constructorProcesos.start();
            //Coger el stream conectado a su salida y leerlo
            ProcesosUtils.imprimirSalidaHijo(hijo);

            hijo.waitFor();//espera hasta que el hijo termine

            System.out.println("Proceso terminado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
