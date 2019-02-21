
package ahorcado;

public class Caracter {
    public char letra;
    public boolean adivinado;
    
    public Caracter(char letra) {
        this.letra = letra;
        this.adivinado = false;
    }

    Caracter() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
