
package diccionario;

import java.util.ArrayList;

public class Arbol {

    private Nodo raiz;
    
    Arbol(){
        
        raiz = new Nodo("?");
        
    }
    
    public Nodo insertar(Nodo nodo, String llave){
       
        boolean esHijo = false;
        
        ArrayList<Nodo> hijos = nodo.getHijos();
        Nodo nodoActual = null;
        
        for(int i = 0; i < hijos.size(); i++){
            
            if( hijos.get(i).getLlave().equals(llave) ){
            
                esHijo = true;
                nodoActual = hijos.get(i);
                
            }
            
        }
        
        if(!esHijo){
        
            nodoActual = new Nodo(llave);
            nodo.getHijos().add(nodoActual);
            
        }
        
        return nodoActual;
    
    }
    
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    
}
