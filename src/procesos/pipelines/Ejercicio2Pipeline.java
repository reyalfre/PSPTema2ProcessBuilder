package procesos.pipelines;

import procesos.utils.ProcesosUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2Pipeline {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("¿Qué numero quieres pasar por la picadora?");
        int numero = entrada.nextInt();
        //Construyo los 3 ProcessBuilder, uno por comando
        ProcessBuilder inicial = new ProcessBuilder("java", Inicial.class.getName(), String.valueOf(numero));
        inicial.directory(new File(ProcesosUtils.RUTA_CLASS));

        ProcessBuilder multiplicador = new ProcessBuilder("java", Multiplicador.class.getName());
        multiplicador.directory(new File(ProcesosUtils.RUTA_CLASS));

        ProcessBuilder sumador = new ProcessBuilder("java", Sumador.class.getName());
        sumador.directory(new File(ProcesosUtils.RUTA_CLASS));
        sumador.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        try {
            List<Process> procesos = ProcessBuilder.startPipeline(Arrays.asList(inicial, multiplicador, sumador));

            Process ultimoHijo = procesos.get(procesos.size()-1);
            System.out.println("La salida es... ");
            //ProcesosUtils.imprimirSalidaHijo(ultimoHijo);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
