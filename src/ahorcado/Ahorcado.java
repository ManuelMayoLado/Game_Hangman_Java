
package ahorcado;

import java.util.ArrayList;
import java.util.Scanner;

public class Ahorcado {

    public static void main(String[] args) {
        
        Scanner escaner = new Scanner(System.in);
        
        //Variables
        int vidas = 5;
        
        //Introducir palabra
        System.out.println("Introduce unha palabra:");
        String stringEntrada = escaner.nextLine();
        stringEntrada = stringEntrada.toLowerCase();
        
        //Creación do ArrayList da palabra
        ArrayList<Caracter> arrayPalabra = new ArrayList <Caracter> ();
         
        for (int x=0;x<stringEntrada.length();x++) {
            char letra = stringEntrada.charAt(x);
            arrayPalabra.add(new Caracter(letra));
        }
        
        //Bucle do xogo
        boolean fin = false;
        while (!fin) {
            //Mostrar a vida
            System.out.println("Vidas: "+vidas);
            //Mostrar as letras da palabra descubertas
            for (int x=0;x<arrayPalabra.size();x++) {
                if (arrayPalabra.get(x).adivinado) {
                    System.out.print("_"+arrayPalabra.get(x).letra+"_ ");
                }
                else {
                    System.out.print("___ ");
                }
            }
            //Introducción do carácter
            System.out.println("");
            System.out.println("Introduce unha letra:");
            String letraIntroducida = escaner.nextLine();
            //Comprobar se existe
            boolean existe = false;
            for (int x=0;x<arrayPalabra.size();x++) {
                if (letraIntroducida.equals(Character.toString(arrayPalabra.get(x).letra))) {
                    existe = true;
                    arrayPalabra.get(x).adivinado = true;
                }
            }
            if (existe) {
                System.out.println(">> Acertaches!");
            }
            else {
                System.out.println(">> Fallaches!");
                vidas -= 1;
            }
            
            //Comprobar si están todas as letras da palabra descubertas
            fin = true;
            for (int x=0;x<arrayPalabra.size();x++) {
                if (!arrayPalabra.get(x).adivinado) {
                    fin = false;
                }
            }
            //Comprobar se quedan vidas
            if (vidas <= 0) {
                fin = true;
            }
            //Mensaje final
            if (fin) {
                 if (vidas <= 0) {
                    System.out.println("-- Derrota! --");
                 }
                 else {
                    System.out.println("-- Victoria! --");
                 }
            }
            
        }
        
    }   
    
}