/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.britto.aspsolutions.Interfaces;

import com.britto.aspsolutions.Validator.Checkeo;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.xml.validation.Validator;

/**
 *
 * @author britt
 */
public class interfaces extends javax.swing.JFrame {
    
    Checkeo check = new Checkeo();
    private JLabel[][] vocal;
    private JLabel word;         
    private ArrayList<String> palabrasEncontradas = new ArrayList<>();    
    private int cantidadPalabrasAgregar = 0;
    private ArrayList<String> palabrasBuscar = new ArrayList<>();
    private ArrayList<Integer> tamaño = new ArrayList<>();
    private int conteo = 0;
    /**
     * Creates new form interfaces 
     */
    public interfaces() {        
        initComponents();
        cargar();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        letter_soup = new javax.swing.JPanel();
        PanelPalabras = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        letter_soup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        letter_soup.setLayout(new java.awt.GridLayout(20, 20));

        PanelPalabras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelPalabras.setLayout(new java.awt.GridLayout(8, 2));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BIENVENIDOS A MI SOPA DE LETRAS ATT: DAVID BRITTO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(PanelPalabras, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(letter_soup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelPalabras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(letter_soup, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
   
    public void cargar(){        
        cantidadPalabras(); //Recogemos la cantidad de palabras que el usuario va a buscar     
        sopa(); // llenamos los Jlabel en el Jpanel                
        ponerPalabras(); //Segun posiciones alazar vamos poniendo algunas palabras que el usuario va a buscar si se cumple la condición de insertar las palabras si no, no nsertamos ninguna
        emptySpace(); // Llenamos los espacios vacios
        recorrerPanelBuscar(); //Buscamos las palabras ingresadas
    }
    
    public void cantidadPalabras(){
        JOptionPane.showMessageDialog(null, "Welcome | Bienvenido  Sopa de letras David Britto"); 
        cantidadPalabrasAgregar = check.checkNumerosPalabras(); //Mandamos el mensaje de cuantas palabras quiere en caso de no tener un respuesta valida saltamos un error        
        for (int i = 0; i < cantidadPalabrasAgregar; i++) {            
            palabrasBuscar.add(check.checkStringPalabras(i + 1));
            tamaño.add(palabrasBuscar.get(i).length());
        }        
        System.out.println("Palabras a buscar"+palabrasBuscar + " tamaño=" + tamaño);
    }        

    public void sopa(){
        
        vocal = new JLabel [20][20];
        
        for (int i = 0; i < 20; i++) {
            
            for (int j = 0; j < 20; j++) {
                
                vocal[i][j] = new JLabel("", javax.swing.SwingConstants.CENTER);// Creamos la casilla vacia y la alineamos centrada
                vocal[i][j].setName(""); // El nombre se lo setiamos vacio 
                vocal[i][j].setBackground(Color.white); //Le ponemos color negro de fondo
                vocal[i][j].setFont(new java.awt.Font("Arial", 1, 10));// tipo de letra
                vocal[i][j].setBorder(new javax.swing.border.LineBorder(Color.black)); // color del bolder
                vocal[i][j].setOpaque(true); // Para poder ver la letra                
                
                letter_soup.add(vocal[i][j]);
            }
            
        }
    }
    
    public void emptySpace(){
        //Arreglo que nos ayuda a poner las letras en la sopa        
        String abc[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (vocal[i][j].getName().equals("")) {
                    vocal[i][j].setText(abc[(int) (random.nextDouble()*abc.length-1)]);                    
                }
            }
        }
    }
    
    public void recorrerPanelBuscar(){
        
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {                
                 buscar(i,j);
            }
        }
        
        System.out.println("CONTEO = " + conteo);
        //llenamos el Jlabel de las palabras
        if (conteo <= 0) {
            JOptionPane.showMessageDialog(null, "No se encontro ninguna palabra");
        }
        llenarJlabel();
                        
    }
    
    public void llenarJlabel(){
        
        
        if (!palabrasEncontradas.isEmpty()) {
            for (int i = 0; i < palabrasEncontradas.size(); i++) {
                word = new JLabel();
                word.setName("palabra1");
                word.setText(""+palabrasEncontradas.get(i));
                word.setBackground(Color.white);
                word.setFont(new java.awt.Font("Arial", 1, 10));
                word.setBorder(new javax.swing.border.LineBorder(Color.black));
                word.setOpaque(true);
                PanelPalabras.add(word); 
            }
        }else{
                word = new JLabel();
                word.setName("palabra1");
                word.setText("No se encontraron palabras");
                word.setBackground(Color.white);
                word.setFont(new java.awt.Font("Arial", 1, 10));
                word.setBorder(new javax.swing.border.LineBorder(Color.black));
                word.setOpaque(true);
                PanelPalabras.add(word);
        }
    }
    
    public void buscar(int i, int j){
        int t=0;
        int finish =0;
        int b=0;
        
         for (int k = 0; k < cantidadPalabrasAgregar; k++) {
            //Izquierda a Derecha
            if (10 - j >=tamaño.get(k) && b==0) {
                while(t < tamaño.get(k) && vocal[i][j+t].getText().equalsIgnoreCase(""+palabrasBuscar.get(k).charAt(t))){t++;}
                if (t==tamaño.get(k)) {
                    for (int l = 0; l < tamaño.get(k); l++) {
                       vocal[i][j+l].setBackground(Color.ORANGE);
                    }
                    
                    finish = tamaño.get(k) - 1;
                    conteo++;
                    b=1;
                    palabrasEncontradas.add(palabrasBuscar.get(k) + " Posicion inicial [" + i + "]" + "[" + j + "]" +
                             " Posicion Final [" + i + "]" + "[" + (j+finish) + "]" + "\n");
                }
            }

            //Derecha a Izquierda
            t=0;
            if (j + 1 >=tamaño.get(k) && b == 0) {
                while(t < tamaño.get(k) && vocal[i][j-t].getText().equalsIgnoreCase(""+palabrasBuscar.get(k).charAt(t))){t++;}
                if (t==tamaño.get(k)) {

                    for (int l = 0; l < tamaño.get(k); l++) {
                       vocal[i][j-l].setBackground(Color.ORANGE);
                    }

                    finish = tamaño.get(k) - 1;
                    conteo++;
                    b=1;
                    palabrasEncontradas.add(palabrasBuscar.get(k) + " Posicion inicial [" + i + "]" + "[" + j + "]" +
                            " Posicion Final [" + i + "]" + "[" + (j-finish) + "]");
                }
            }

            //Arriba
            t=0;
            if (i + 1 >=tamaño.get(k) && b ==0) {
                while(t < tamaño.get(k) && vocal[i-t][j].getText().equalsIgnoreCase(""+palabrasBuscar.get(k).charAt(t))){t++;}
                if (t==tamaño.get(k)) {

                    for (int l = 0; l < tamaño.get(k); l++) {
                       vocal[i-l][j].setBackground(Color.ORANGE);
                    }

                    finish = tamaño.get(k) - 1;
                    conteo++;
                    b=1;
                    palabrasEncontradas.add(palabrasBuscar.get(k) + " Posicion inicial [" + i + "]" + "[" + j + "]" +
                            " Posicion Final [" + (i-finish) + "]" + "[" + j + "]");
                }
            }



            //Abajo
            t=0;
            if (20 - i >=tamaño.get(k) && b ==0) {
                while(t < tamaño.get(k) && vocal[i+t][j].getText().equalsIgnoreCase(""+palabrasBuscar.get(k).charAt(t))){t++;}
                if (t==tamaño.get(k)) {

                     for (int l = 0; l < tamaño.get(k); l++) {
                        vocal[i+l][j].setBackground(Color.ORANGE);
                     }
                     
                    finish = tamaño.get(k) - 1;
                    conteo++;
                    b=1;
                    palabrasEncontradas.add(palabrasBuscar.get(k) + " Posicion inicial [" + i + "]" + "[" + j + "]" +
                            " Posicion Final [" + (i+finish) + "]" + "[" + j + "]");
                     
                }
            }

            //Arriba - Derecha
            t=0;
            if (i + 1 >=tamaño.get(k) && 20 - j >=tamaño.get(k) && b ==0) {
                while(t < tamaño.get(k) && vocal[i-t][j+t].getText().equalsIgnoreCase(""+palabrasBuscar.get(k).charAt(t))){t++;}
                if (t==tamaño.get(k)) {

                    for (int l = 0; l < tamaño.get(k); l++) {
                       vocal[i-l][j+l].setBackground(Color.ORANGE);
                    }
                    
                    finish = tamaño.get(k) - 1;
                    conteo++;
                    b=1;
                    palabrasEncontradas.add(palabrasBuscar.get(k) + " Posicion inicial [" + i + "]" + "[" + j + "]" +
                            " Posicion Final [" + (i-finish) + "]" + "[" + (j+finish) + "]");
                }
            }

            //Arriba - Izquierda
            t=0;
            if (i + 1 >=tamaño.get(k) && j + 1 >=tamaño.get(k) && b ==0) {
                while(t < tamaño.get(k) && vocal[i-t][j-t].getText().equalsIgnoreCase(""+palabrasBuscar.get(k).charAt(t))){t++;}
                if (t==tamaño.get(k)) {

                    for (int l = 0; l < tamaño.get(k); l++) {
                       vocal[i-l][j-l].setBackground(Color.ORANGE);
                    }
                    
                    finish = tamaño.get(k) - 1;
                    conteo++;
                    b=1;
                    palabrasEncontradas.add(palabrasBuscar.get(k) + " Posicion inicial [" + i + "]" + "[" + j + "]" +
                            " Posicion Final [" + (i-finish) + "]" + "[" + (j-finish) + "]");
                }
            }

            //Abajo - Derecha
            t=0;
            if (20 - i >=tamaño.get(k) && 20 - j >=tamaño.get(k) && b ==0) {
                while(t < tamaño.get(k) && vocal[i+t][j+t].getText().equalsIgnoreCase(""+palabrasBuscar.get(k).charAt(t))){t++;}
                if (t==tamaño.get(k)) {

                    for (int l = 0; l < tamaño.get(k); l++) {
                       vocal[i+l][j+l].setBackground(Color.ORANGE);
                    }
                    
                    finish = tamaño.get(k) - 1;
                    conteo++;
                    b=1;
                    palabrasEncontradas.add(palabrasBuscar.get(k) + " Posicion inicial [" + i + "]" + "[" + j + "]" +
                            " Posicion Final [" + (i+finish) + "]" + "[" + (j+finish) + "]");
                }
            }

            //Abajo - Izquierda
            t=0;
            if (20 - i >=tamaño.get(k) && j + 1 >=tamaño.get(k) && b ==0) {
                while(t < tamaño.get(k) && vocal[i+t][j-t].getText().equalsIgnoreCase(""+palabrasBuscar.get(k).charAt(t))){t++;}
                if (t==tamaño.get(k)) {

                    for (int l = 0; l < tamaño.get(k); l++) {
                       vocal[i+l][j-l].setBackground(Color.ORANGE);
                    }
                    
                    finish = tamaño.get(k) - 1;
                    conteo++;
                    b=1;
                    palabrasEncontradas.add(palabrasBuscar.get(k) + " Posicion inicial [" + i + "]" + "[" + j + "]" +
                            " Posicion Final [" + (i+finish) + "]" + "[" + (j-finish) + "]");
                }
            } 
             
        }        
    }
    
    public void ponerPalabras(){        
        Random ra = new Random();
        int i = 0; //posicion alazar en x
        int j = 0; //posicion alazar en y
        int r = ra.nextInt(1,4); // Para definir si colocamos las palabras o no        
        int b=0; //Variable bandera que nos sirve para saber si la palabra ya se inserto en x ubicacin para no volverla a insertar
        int z=0; //Variable bandera que nos sirve para saber si la ubicación que se tiene pensado poner la palabra ya esta ocupado
        int arribaDerecha = 0;
        int derechaIzquierda = 0;
        int izquierdaDerecha = 0;
        int arriba = 0;
        int abajo = 0;
        
        System.out.println("result=" + r);
        
        if (r == 0 || r == 1 || r == 2) {
            
            System.out.println("Vamos a insertar la palabra en la sopa");
            
            // Hacemos un ciclo para la cantidad de palabras a insertar
            for (int k = 0; k < cantidadPalabrasAgregar; k++) {
                
                // posiciones random
                i = (int) (ra.nextDouble()*21-1);
                j = (int) (ra.nextDouble()*21-1);
                b=0;
                
                z=0; // ponemos a z como 0 nuevamente               
                //Arriba - Derecha - verificamos que la palabra quepa  
                if (i + 1 >=tamaño.get(k) && 20 - j >=tamaño.get(k) && arribaDerecha ==0) {
                    
                    //Verificamos que no haya ya escrita una palabra en la ubicación
                    for (int l = 0; l < tamaño.get(k); l++) {
                         if (vocal[i-l][j+l].getName().equalsIgnoreCase("1")) {
                             z = 1;
                             break;                            
                         }
                    }
                    
                    if (z == 1) {
                        System.out.println("Espacio ocupado = Arriba - Derecha");
                    }else{
                        for (int t = 0; t < tamaño.get(k); t++) {
                            vocal[i-t][j+t].setText(""+palabrasBuscar.get(k).charAt(t));
                            vocal[i-t][j+t].setName("1");                            
                        }
                        b=1;
                        arribaDerecha = 1;
                        System.out.println("Se inserto = Arriba - Derecha");
                    }                                        
                }
                
                z=0; // ponemos a z como 0 nuevamente
                //Izquierda a Derecha - verificamos que la palabra quepa                
                if (20 - j >=tamaño.get(k) && izquierdaDerecha==0 && b==0) {
                    
                    //Verificamos que no haya ya escrita una palabra en la ubicación
                    for (int l = 0; l < tamaño.get(k); l++) {
                        if (vocal[i][j+l].getName().equalsIgnoreCase("1")) {
                            z = 1;
                            break;                            
                        }
                    }
                    
                    if (z == 1) {
                        System.out.println("Espacio ocupado - Izquierda a Derecha");
                    }else{
                       for (int t = 0; t < tamaño.get(k); t++) {                                                                        
                            vocal[i][j+t].setText(""+palabrasBuscar.get(k).charAt(t));
                            vocal[i][j+t].setName("1");                            
                        }                
                        b=1;
                        izquierdaDerecha = 1;
                        System.out.println("Se inserto - Izquierda a Derecha"); 
                    }
                }
                
                z=0; // ponemos a z como 0 nuevamente                
                //Derecha a Izquierda - verificamos que la palabra quepa  
                if (j + 1 >=tamaño.get(k) && b == 0 && derechaIzquierda ==0) {
                    
                    //Verificamos que no haya ya escrita una palabra en la ubicación
                    for (int l = 0; l < tamaño.get(k); l++) {
                        if (vocal[i][j-l].getName().equalsIgnoreCase("1")) {
                            z = 1;
                            break;                            
                        }
                    }
                    
                    if (z == 1) {
                        System.out.println("Espacio ocupado - Derecha a Izquierda");
                    }else{
                        for (int t = 0; t < tamaño.get(k); t++) {
                            vocal[i][j-t].setText(""+palabrasBuscar.get(k).charAt(t));
                            vocal[i][j-t].setName("1");                            
                        }                        
                        b=1;
                        derechaIzquierda = 1;
                        System.out.println("Se inserto - Derecha a Izquierda");
                    }                    
                    
                }

                z=0; // ponemos a z como 0 nuevamente                
                //Arriba - verificamos que la palabra quepa  
                if (i + 1 >=tamaño.get(k) && b == 0 && arriba ==0) {
                    
                    //Verificamos que no haya ya escrita una palabra en la ubicación
                    for (int l = 0; l < tamaño.get(k); l++) {
                         if (vocal[i-l][j].getName().equalsIgnoreCase("1")) {
                             z = 1;
                             break;                            
                         }
                    }
                   
                    if (z == 1) {
                        System.out.println("Espacio ocupado - Arriba");
                    }else{
                        for (int t = 0; t < tamaño.get(k); t++) {              
                            vocal[i-t][j].setText(""+palabrasBuscar.get(k).charAt(t));
                            vocal[i-t][j].setName("1");                            
                        }
                        b=1;
                        arriba = 1;
                        System.out.println("Se inserto Arriba");
                    }
                }
                
                z=0; // ponemos a z como 0 nuevamente                
                //Abajo - verificamos que la palabra quepa  
                if (20 - i >=tamaño.get(k) && b == 0 && abajo ==0) {
                    
                    //Verificamos que no haya ya escrita una palabra en la ubicación
                    for (int l = 0; l < tamaño.get(k); l++) {
                         if (vocal[i+l][j].getName().equalsIgnoreCase("1")) {
                             z = 1;
                             break;                            
                         }
                    }
                    
                    if (z == 1) {
                        System.out.println("Espacio ocupado - Abajo");
                    }else{
                        for (int t = 0; t < tamaño.get(k); t++) {               
                            vocal[i+t][j].setText(""+palabrasBuscar.get(k).charAt(t));
                            vocal[i+t][j].setName("1");                            
                        }
                        b=1;
                        abajo = 1;
                        System.out.println("Se inserto - Abajo");
                    }                    
                }
                
                z=0; // ponemos a z como 0 nuevamente                
                //Arriba - Izquierda - verificamos que la palabra quepa  
                if (i + 1 >=tamaño.get(k) && j + 1 >=tamaño.get(k)) {
                    
                    //Verificamos que no haya ya escrita una palabra en la ubicación
                    for (int l = 0; l < tamaño.get(k); l++) {
                         if (vocal[i-l][j-l].getName().equalsIgnoreCase("1")) {
                             z = 1;
                             break;                            
                         }
                    }
                    
                    if (z == 1) {
                        System.out.println("Espacio ocupado = Arriba - Izquierda");
                    }else{
                        for (int t = 0; t < tamaño.get(k); t++) {
                            vocal[i-t][j-t].setText(""+palabrasBuscar.get(k).charAt(t));
                            vocal[i-t][j-t].setName("1");                            
                        }

                        b=1;
                        System.out.println("Se inserto = Arriba - Izquierda");
                    }                                         
                }
                
                z=0; // ponemos a z como 0 nuevamente
                
                //Abajo - Derecha - verificamos que la palabra quepa  
                if (20 - i >=tamaño.get(k) && 20 - j >=tamaño.get(k)) {
                    
                    //Verificamos que no haya ya escrita una palabra en la ubicación
                    for (int l = 0; l < tamaño.get(k); l++) {
                         if (vocal[i+l][j+l].getName().equalsIgnoreCase("1")) {
                             z = 1;
                             break;                            
                         }
                    }
                    
                    if (z == 1) {
                        System.out.println("Espacio ocupado = Abajo - Derecha");
                    }else{
                        for (int t = 0; t < tamaño.get(k); t++) {
                            vocal[i+t][j+t].setText(""+palabrasBuscar.get(k).charAt(t));
                            vocal[i+t][j+t].setName("1");                            
                        }

                        b=1;
                        System.out.println("Se inserto = Abajo - Derecha");
                    }                                        
                }
                
                z=0; // ponemos a z como 0 nuevamente
                
                //Abajo - Izquierda - verificamos que la palabra quepa  
                if (20 - i >=tamaño.get(k) && j + 1 >=tamaño.get(k)) {
                    
                    //Verificamos que no haya ya escrita una palabra en la ubicación
                    for (int l = 0; l < tamaño.get(k); l++) {
                         if (vocal[i+l][j-l].getName().equalsIgnoreCase("1")) {
                             z = 1;
                             break;                            
                         }
                    }
                    
                    if (z == 1) {
                        System.out.println("Espacio ocupado = Abajo - Izquierda");
                    }else{
                        for (int t = 0; t < tamaño.get(k); t++) {
                            vocal[i+t][j-t].setText(""+palabrasBuscar.get(k).charAt(t));
                            vocal[i+t][j-t].setName("1");                            
                        }

                        b=1;
                        System.out.println("Se inserto = Abajo - Izquierda");
                    }                                        
                }
                
                if (b == 0) {
                    System.out.println("No se´pudo insertar la palabra= "+ palabrasBuscar.get(k));
                }
                
            }
              
            if (b == 0) {
                    System.out.println("No se´inserto ninguna palabra");
            }
        }                
         
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfaces.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaces.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaces.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaces.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaces().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPalabras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel letter_soup;
    // End of variables declaration//GEN-END:variables
}
