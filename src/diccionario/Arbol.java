
package diccionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Arbol {

    private NodoArbol raiz;
    
    int indiceActual = 0; 
    Stack<Pareja> stack = new Stack<Pareja>(); 
    ArrayList<String> postordenLista = new ArrayList<String>(); 
    
    Arbol(){
        
        raiz = new NodoArbol("?");
        raiz.getHijos().add(new NodoArbol("}"));
    
    }
    
    public NodoArbol insertar(NodoArbol nodo, String llave, String Contenido){
       
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
            nodoActual.setContenido(Contenido);
            
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
    
    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
    
    public List<String> preorden(NodoArbol raiz) {
    
        List<String> valores = new ArrayList<>();
        actualizarListaPre(raiz, valores);
        return valores;
    
    }
    
    private void actualizarListaPre(NodoArbol raiz, List<String> valores) {
        
        if (raiz == null) {
            
            return;
        
        }
        
        Stack<NodoArbol> pila = new Stack<>();
        pila.push(raiz);

        while (!pila.empty()) {
            
            NodoArbol temp = pila.pop();
            valores.add(temp.getLlave());
            
            List<NodoArbol> hijos = temp.getHijos();
            
            for (int i=hijos.size()-1; i>=0; i--) {
                
                pila.push(hijos.get(i));
            
            }
            
        }
    }    
    
    public ArrayList<String> postorden(NodoArbol raiz) {
        
        while (raiz != null || !stack.isEmpty()) { 
           
            if (raiz != null) { 

                stack.push(new Pareja(raiz, indiceActual)); 
                indiceActual = 0; 

                if (raiz.getHijos().size() >= 1) { 
                
                    raiz = raiz.getHijos().get(0); 
                
                } 
                
                else { 
                
                    raiz = null; 
                
                } 
                
                continue; 
            } 

            Pareja temp = stack.pop(); 
            postordenLista.add(temp.nodo.getLlave()); 

            while (!stack.isEmpty() && temp.indiceHijo == stack.peek().nodo.getHijos().size() - 1) { 
                
                temp = stack.pop(); 
                postordenLista.add(temp.nodo.getLlave()); 
            
            } 

            if (!stack.isEmpty()) { 
                raiz = stack.peek().nodo.getHijos().get(temp.indiceHijo + 1); 
                indiceActual = temp.indiceHijo + 1; 
            } 
        
        } 
      
        return postordenLista; 
    
    } 
    
}

class Pareja { 
    
    public NodoArbol nodo; 
    public int indiceHijo; 
    
    public Pareja(NodoArbol nodo, int indiceHijo) {
        
        this.nodo = nodo; 
        this.indiceHijo = indiceHijo; 
    
    } 

} 
