
package diccionario;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Diccionario extends JFrame implements ActionListener {

    JButton botonCrear = new JButton("Crear diccionario");
    JButton botonIngresar = new JButton("Ingresar Nodo");
    JButton botonConsultarNodo = new JButton("Consultar Nodo");
    JButton botonConsultarDiccionario = new JButton("Consultar diccionario");
    
    JTextField campoIngresoLlave = new JTextField("uno,dos,tres,cuatro,cinco,seis,siete");
    JTextField campoIngresoContenido = new JTextField("one,two,three,four,five,six,seven");
    JTextField campoConsulta = new JTextField("uno");
    JTextField campoRespuesta = new JTextField("");
    JTextField preOrden = new JTextField();
    JTextField inOrden = new JTextField();
    JTextField posOrden = new JTextField();
    
    JScrollPane panelInterno = new JScrollPane();
    JScrollPane panelExterno = new JScrollPane();
    
    JScrollPane panelInterno2 = new JScrollPane();
    JScrollPane panelExterno2 = new JScrollPane();
    
    JLabel texto1 = new JLabel("Ingrese la llave del nodo :");
    JLabel texto2 = new JLabel("Ingrese el contenido del nodo :");
    JLabel texto3 = new JLabel("Nodo a consultar :");
    JLabel texto4 = new JLabel(":");
    JLabel texto5 = new JLabel("Daniel Alejandro Roa Palacios");
    JLabel texto6 = new JLabel("Universidad Distrital Francisco Jose de Caldas");
    JLabel texto7 = new JLabel("20171020077");
    JLabel texto8 = new JLabel("Recorrido Preorden : ");
    JLabel texto9 = new JLabel("Recorrido Inorden : ");
    JLabel texto10 = new JLabel("Recorrido Posorden : ");
    JLabel aviso = new JLabel(" ");
    
    JTextArea lista = new JTextArea();
    
    Arbol arbol;
    
    ArrayList<String> pila;
    
    String cadena = "";
    
    int coorX = 50, coorY = 0;
    
    public static void main(String[] args) {

        Diccionario diccionario = new Diccionario();
        diccionario.setBounds(0, 0, 1300, 700);
        diccionario.setTitle("Materias en multilistas");
        diccionario.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        diccionario.setVisible(true);  
        
    }

    Diccionario(){
        
        Container c = getContentPane();
        c.setLayout(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
    
        c.add(botonCrear);
        c.add(botonIngresar);
        c.add(botonConsultarNodo);
        c.add(botonConsultarDiccionario);
        
        c.add(campoIngresoLlave);
        c.add(campoIngresoContenido);
        c.add(campoConsulta);
        
        c.add(panelExterno);
        c.add(panelExterno2);
        
        c.add(texto1);
        c.add(texto2);
        c.add(texto3);
        c.add(texto4);
        c.add(texto5);
        c.add(texto6);
        c.add(texto7);
        c.add(texto8);
        c.add(texto9);
        c.add(texto10);
        c.add(aviso);
        
        c.add(campoConsulta);
        c.add(campoRespuesta);
        c.add(preOrden);
        c.add(inOrden);
        c.add(posOrden);
        
        texto1.setBounds(25, 125, 500, 20);
        texto2.setBounds(25, 150, 500, 20);
        texto3.setBounds(370, 125, 500, 20);
        texto4.setBounds(610, 125, 500, 20);
        texto5.setBounds(25, 25, 200, 20);
        texto6.setBounds(25, 50, 500, 20);
        texto7.setBounds(25, 75, 370,20);
        texto8.setBounds(370, 25, 200, 20);
        texto9.setBounds(370, 50, 500, 20);
        texto10.setBounds(370, 75, 370,20);
        aviso.setBounds(370, 100, 500,20);
        
        preOrden.setBounds(500, 25, 350, 20);
        inOrden.setBounds(500, 50, 350, 20);
        posOrden.setBounds(500, 75, 350, 20);
        campoIngresoLlave.setBounds(200, 125, 100, 20);
        campoIngresoContenido.setBounds(200, 150, 100, 20);
        campoConsulta.setBounds(500, 125, 100, 20);
        campoRespuesta.setBounds(620, 125, 100, 20);
        
        botonCrear.setBackground(Color.CYAN);
        botonCrear.addActionListener(this);
        botonCrear.setBounds(370, 175, 480, 20);
        botonIngresar.setBackground(Color.GREEN);
        botonIngresar.addActionListener(this);
        botonIngresar.setBounds(25, 175, 275, 20);
        botonConsultarNodo.setBackground(Color.ORANGE);
        botonConsultarNodo.addActionListener(this);
        botonConsultarNodo.setBounds(370, 150, 480, 20);
        botonConsultarDiccionario.setBackground(Color.YELLOW);
        botonConsultarDiccionario.addActionListener(this);
        botonConsultarDiccionario.setBounds(1000, 610, 250, 40);
        
        panelExterno.setBounds(10, 200, 960, 450);
        panelExterno.setPreferredSize(new Dimension(960, 450));
        
        panelInterno.setBounds(10, 200, 1500, 1000);
        panelInterno.setPreferredSize(new Dimension(1500, 1000));
        
        panelExterno2.setBounds(1000, 20, 250, 580);
        panelExterno2.setPreferredSize(new Dimension(250, 550));
        
        panelInterno2.setBounds(1000, 50, 500, 2000);
        panelInterno2.setPreferredSize(new Dimension(500, 2000));
        
    }
    
    public void listar(NodoArbol nodo){

        if(!nodo.getHijos().isEmpty()){

            for(int i = 0; i < nodo.getHijos().size(); i++){

                pila.add(nodo.getLlave());
                
                listar(nodo.getHijos().get(i));
                pila.remove(pila.size()-1);
                
            }
            
        } else {
            
            cadena = cadena + "\n \n " + pila.toString() + " : " + nodo.getContenido();
            System.out.println(pila.toString() + " : " + nodo.getContenido());
            
        }
   
    }
    
    public void pintar(NodoArbol nodo){
        
        if(!nodo.getHijos().isEmpty()){
            
            JLabel caracter = new JLabel( nodo.getLlave() );
            caracter.setForeground(Color.BLACK);
            caracter.setBounds(coorX, coorY, 20, 20);

            JLabel img = new JLabel();
        
            ImageIcon imgIcon = new ImageIcon(getClass().getResource("Abajo.png"));

            Image imgEscalada = imgIcon.getImage().getScaledInstance(20,30, Image.SCALE_SMOOTH);
            Icon iconoEscalado = new ImageIcon(imgEscalada);
            img.setBounds(coorX - 7, coorY + 20, 20, 30);
            img.setIcon(iconoEscalado);

            panelInterno.add(img);

            panelInterno.add(caracter);

            for(int i = 0; i < nodo.getHijos().size(); i++){
            
                int anteriorX = coorX;
                
                coorY = coorY + 50;  
                coorX = coorX + 50*i;

                if( nodo.getHijos().size() > 1 && ((nodo.getHijos().size() - 1) != i) ){
                
                    JLabel img2 = new JLabel();

                    ImageIcon imgIcon2 = new ImageIcon(getClass().getResource("Derecha.png"));

                    Image imgEscalada2 = imgIcon2.getImage().getScaledInstance(20, 30, Image.SCALE_SMOOTH);
                    Icon iconoEscalado2 = new ImageIcon(imgEscalada2);
                    img2.setBounds(coorX + 10, coorY , 20, 30);
                    img2.setIcon(iconoEscalado2);

                    panelInterno.add(img2);
                
                }
                
                pintar(nodo.getHijos().get(i));
            
                coorY = coorY - 50;
                
            }
            
        } else {
            
            JLabel caracter = new JLabel( nodo.getLlave() );
            caracter.setForeground(Color.BLACK);
            caracter.setBounds(coorX, coorY, 20, 20);

            panelInterno.add(caracter);
            
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {       
        
        if(e.getSource() == botonCrear){
        
            arbol = new Arbol();
            aviso.setForeground(Color.blue);
            aviso.setText("Diccionario creado");
            
        } else if ( e.getSource() == botonIngresar && arbol != null ){
            
            panelInterno.removeAll();
            
            coorX = 50;
            coorY = 0;
            
            String entrada = campoIngresoLlave.getText().replace(" ", "");
            String contenido = campoIngresoContenido.getText().replace(" ", "");
            
            String[] listaLlaves = entrada.split(",");
            String[] listaContenidos = contenido.split(",");
                   
            if(!entrada.equals(" ") && (listaLlaves.length == listaContenidos.length)){
                
                for(int i=0; i<listaLlaves.length; i++){
                        
                    listaLlaves[i] = listaLlaves[i] + "}";
                    NodoArbol nodoTemporal = arbol.getRaiz();
                    
                    for(int j = 0; j<listaLlaves[i].length(); j++){
                            
                        if(listaLlaves[i].charAt(j) == '}'){
                        
                            String temp = String.valueOf(listaLlaves[i].charAt(j)); 
                            nodoTemporal = arbol.insertar(nodoTemporal, temp, listaContenidos[i]);
                        
                        } else {
                            
                            String temp = String.valueOf(listaLlaves[i].charAt(j)); 
                            nodoTemporal = arbol.insertar(nodoTemporal, temp, ".");
                            
                        }
                                                
                    }

                }
            }
            
            List<String> valores = arbol.preorden(arbol.getRaiz());
            List<String> valores2 = arbol.postorden(arbol.getRaiz());
            
            preOrden.setText(valores.toString());
            posOrden.setText(valores2.toString());
            
            System.out.println("Preorden:" + valores.toString());
            System.out.println("Postorden:" + valores2.toString());
//            System.out.println("Inorden:" + arbol.);
            
            pintar(arbol.getRaiz());
            
            panelInterno.repaint();
            panelExterno.setViewportView(panelInterno);
            
        } else if ( e.getSource() == botonConsultarNodo ){
        
            String entrada = campoConsulta.getText() + "}";
            NodoArbol nodoTemporal = arbol.getRaiz();
            
            if(!entrada.equals(" ")){
                    
                for(int i = 0; i < entrada.length(); i++){

                    if(nodoTemporal != null){
                    
                    String temp = String.valueOf(entrada.charAt(i)); 
                    nodoTemporal = arbol.consultar(nodoTemporal, temp);                   
                    
                    } else {
                        
                        break;
                        
                    }
                }
                
                if(nodoTemporal != null){
                    
                    System.out.println(nodoTemporal.getLlave());
                    campoRespuesta.setText(nodoTemporal.getContenido());
                    
                } else {
                    
                    aviso.setForeground(Color.RED);
                    aviso.setText("Palabra no registrada en el diccionario");
                    
                }
                
            }
            
        } else if (e.getSource() == botonConsultarDiccionario){
        
            panelInterno2.removeAll();
            lista.removeAll();
            
            pila = new ArrayList<>();
            
            listar(arbol.getRaiz());
            
            lista.setText(" ");
            lista.setBounds(0, 0, 500, 2000);
            
            lista.setText(cadena);
            
            panelInterno2.add(lista);
            panelInterno2.repaint();

            panelExterno2.setViewportView(panelInterno2);
            
        }
        
    }
    
}
