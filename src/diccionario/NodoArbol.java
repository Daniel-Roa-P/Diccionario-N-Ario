
package diccionario;

import java.util.ArrayList;

public class NodoArbol {
    
    private String llave;
    private String contenido;
    private ArrayList<NodoArbol> hijos;

    NodoArbol(String llave){
    
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

    public ArrayList<NodoArbol> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<NodoArbol> hijos) {
        this.hijos = hijos;
    }

}
