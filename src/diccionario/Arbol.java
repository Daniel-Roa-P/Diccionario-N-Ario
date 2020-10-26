
package diccionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Arbol {

    private NodoArbol raiz;
    
    Arbol(){
        
        raiz = new NodoArbol("?");
        raiz.getHijos().add(new NodoArbol("}"));
    }
    
    public NodoArbol insertar(NodoArbol nodo, String llave){
       
        boolean esHijo = false;
        ArrayList<NodoArbol> hijos = nodo.getHijos();
        NodoArbol nodoActual = null;
        
        for(int i = 0; i < hijos.size(); i++){
            
            if( hijos.get(i).getLlave().equals(llave) ){
            
                esHijo = true;
                nodoActual = hijos.get(i);
                
            }
            
        }
        
        if(!esHijo){
        
            nodoActual = new NodoArbol(llave);
            
            if( !hijos.isEmpty() && (llave.compareTo(hijos.get(hijos.size()-1).getLlave()) < 0) ){
         
                nodo.setHijos( ordenar(hijos, nodoActual) ); 
                            
            } else {
        
                nodo.getHijos().add(nodoActual);
                
            }
  
        }
        
        return nodoActual;
    
    }
    
    public ArrayList<NodoArbol> ordenar(ArrayList<NodoArbol> hijos, NodoArbol nodoActual){
    
        ArrayList<NodoArbol> nuevo = new ArrayList<>() ;
        
        for(int i = 0; i< hijos.size(); i++){
            
            NodoArbol temp = hijos.get(i);
            
            if( ( nodoActual.getLlave().compareTo( temp.getLlave() ) < 0) ){
                
                if(!nuevo.contains(nodoActual)){
                    
                    nuevo.add(nodoActual);
                
                }
                
                nuevo.add(temp);
                
            } else {
                
                nuevo.add(temp);
                
            }
            
        }
        
        return nuevo;
        
    }
    
    public List<String> preorder(NodoArbol root) {
    
        List<String> values = new ArrayList<>();
        updateListIterative(root, values);
        return values;
    
    }
    
    private void updateListIterative(NodoArbol root, List<String> values) {
        if (root == null) {
            return;
        }
        
        Stack<NodoArbol> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            NodoArbol temp = stack.pop();
            values.add(temp.getLlave());
            
            List<NodoArbol> childrens = temp.getHijos();
            
            for (int i=childrens.size()-1; i>=0; i--) {
                stack.push(childrens.get(i));
            }
        }
    }
    
    private void updateListRecursive(NodoArbol root, List<String> values) {
        if (root == null) {
            return;
        }
        
        values.add(root.getLlave());
        for (NodoArbol node : root.getHijos()) {
            updateListRecursive(node, values);
        }
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    
}
