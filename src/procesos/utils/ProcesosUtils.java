package procesos.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcesosUtils {

    public static final String RUTA_CLASS = "out/production/PSPTema2";

    public static void imprimirSalidaHijo(Process hijo) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
    }

    public static String traducirCodigoSalida(int value){
        return value == 0 ? "[Exito]" : "[Fallo]";
    }
}
