package procesos.pipelines;

import procesos.utils.ProcesosUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EjercicioPipelines {

    public static void main(String[] args) {

        //Construyo los 3 ProcessBuilder, uno por comando
        ProcessBuilder listaProcesos = new ProcessBuilder("bash", "-c","ps -e");
        ProcessBuilder filtrado = new ProcessBuilder("bash", "-c","grep chromium");
        ProcessBuilder contarLineas = new ProcessBuilder("bash", "-c","wc -l");
        ProcessBuilder multiplicador = new ProcessBuilder("java", Multiplicador.class.getName());
        multiplicador.directory(new File(ProcesosUtils.RUTA_CLASS));
        //contarLineas.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        try {
           List<Process> hijosLanzados = ProcessBuilder.startPipeline(Arrays.asList(listaProcesos, filtrado, contarLineas, multiplicador));

           //Cojo el ultimo proceso hijo lanzado
           Process ultimoHijo = hijosLanzados.get(hijosLanzados.size()-1);
            ProcesosUtils.imprimirSalidaHijo(ultimoHijo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
