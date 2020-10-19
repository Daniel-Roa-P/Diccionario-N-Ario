
package diccionario;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Diccionario extends JFrame implements ActionListener {

    JButton botonCrear = new JButton("Crear diccionario");
    JButton botonIngresar = new JButton("Ingresar Nodo");
    JButton botonConsultarNodo = new JButton("Consultar Nodo");
    JButton botonConsultarDiccionario = new JButton("Consultar diccionario");
    
    JTextField campoIngresoLave = new JTextField("uno");
    JTextField campoIngresoContenido = new JTextField("one");
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
        
        c.add(campoIngresoLave);
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
        
        preOrden.setBounds(500, 25, 350, 20);
        inOrden.setBounds(500, 50, 350, 20);
        posOrden.setBounds(500, 75, 350, 20);
        campoIngresoLave.setBounds(200, 125, 100, 20);
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
    }
    
}
