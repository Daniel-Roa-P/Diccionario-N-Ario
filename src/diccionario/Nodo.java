
package diccionario;

import java.util.ArrayList;

public class Nodo {
    
    private String llave;
    private String contenido;
    private ArrayList<Nodo> hijos;

    Nodo(String llave){
    
        this.llave = llave;
        this.hijos = new ArrayList<>();
        
    }
    
    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
    }
    
    
    
}
