
package diccionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Arbol {

    private Nodo raiz;
    
    Arbol(){
        
        raiz = new Nodo("?");
        raiz.getHijos().add(new Nodo("}"));
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
            
            if( !hijos.isEmpty() && (llave.compareTo(hijos.get(hijos.size()-1).getLlave()) < 0) ){
         
                nodo.setHijos( ordenar(hijos, nodoActual) ); 
                            
            } else {
        
                nodo.getHijos().add(nodoActual);
                
            }
  
        }
        
        return nodoActual;
    
    }
    
    public ArrayList<Nodo> ordenar(ArrayList<Nodo> hijos, Nodo nodoActual){
    
        ArrayList<Nodo> nuevo = new ArrayList<>() ;
        
        for(int i = 0; i< hijos.size(); i++){
            
            Nodo temp = hijos.get(i);
            
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
    
    public List<String> preorder(Nodo root) {
    
        List<String> values = new ArrayList<>();
        updateListIterative(root, values);
        return values;
    
    }
    
    private void updateListIterative(Nodo root, List<String> values) {
        if (root == null) {
            return;
        }
        
        Stack<Nodo> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            Nodo temp = stack.pop();
            values.add(temp.getLlave());
            
            List<Nodo> childrens = temp.getHijos();
            
            for (int i=childrens.size()-1; i>=0; i--) {
                stack.push(childrens.get(i));
            }
        }
    }
    
    private void updateListRecursive(Nodo root, List<String> values) {
        if (root == null) {
            return;
        }
        
        values.add(root.getLlave());
        for (Nodo node : root.getHijos()) {
            updateListRecursive(node, values);
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    
}
