package procesos.pipelines;

import java.util.Scanner;

public class Sumador {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Integer numeroRecibido = entrada.nextInt();
        //Multiplico por él mismo
        numeroRecibido += numeroRecibido;

        System.out.println(numeroRecibido);
    }
}
