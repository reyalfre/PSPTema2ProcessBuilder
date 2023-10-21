package procesos.ejemplos;

import procesos.utils.ProcesosUtils;

import java.io.File;
import java.io.IOException;

public class LanzarComandoPing {

    public static void main(String[] args) {
        ProcessBuilder constructorProceso = new ProcessBuilder();

        //constructorProceso.command("bash", "-c", "netstat");
        constructorProceso.command("cmd.exe", "/c", "netstat");
        String rutaSalida = "salidaNetstat.txt";
        try {
            constructorProceso.redirectOutput(ProcessBuilder.Redirect.appendTo(new File(rutaSalida)));
            Process hijo = constructorProceso.start();

           int exitValue = hijo.waitFor();

            System.out.println("El proceso hijo ha terminado. Valor salida: " + ProcesosUtils.traducirCodigoSalida(exitValue));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
