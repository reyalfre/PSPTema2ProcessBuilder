package procesos.ejemplos;

import java.io.File;
import java.io.IOException;

public class LanzarComandoLs {
    public static void main(String[] args) {

        ProcessBuilder constructorProcesos = new ProcessBuilder();

        String rutaCarpeta = "/home/diego/Escritorio";
        String rutaCarpetaWindows = "C:\\Users\\alfre\\Desktop";
        String rutaSalida = "salidaLs.txt";
        constructorProcesos.directory(new File(rutaCarpetaWindows));
       // constructorProcesos.command("free");
        constructorProcesos.command("tasklist");

        try {
            constructorProcesos.redirectOutput(ProcessBuilder.Redirect.appendTo(new File(rutaSalida)));
            constructorProcesos.start();
            constructorProcesos.start();
            constructorProcesos.start();
            constructorProcesos.start();

            System.out.println("Proceso lanzado...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
