import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import ch.aplu.turtle.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextField;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 08.05.2020
 * @author Uli Strautz
 */

public class Zeichnen extends JFrame {
  // Anfang Attribute
  private Playground playground1 = new Playground();
  private Turtle t = new Turtle();
  private JButton bLos = new JButton();
  private JButton bPutzen = new JButton();
  private JButton bRot = new JButton();
  private JButton bBlau = new JButton();
  private JButton bGruen = new JButton();
  private JButton bGelb = new JButton();
  private JTextField textA = new JTextField("1.0");
  private JTextField textB = new JTextField("2.0");
  private JTextField textC = new JTextField("-1");
  // Ende Attribute
  
  public Zeichnen() { 
    super();
    //setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    setSize(600,500);
    
    
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    setTitle("Turtle Grafik");
    setResizable(true);
    Container cp = getContentPane();
    cp.setLayout(new BorderLayout());
    
    // Anfang Komponenten
    JPanel pTextField = new JPanel();
    pTextField.setLayout(new GridLayout());
    pTextField.add(textA);
    pTextField.add(textB);
    pTextField.add(textC);
    cp.add(pTextField,BorderLayout.NORTH);
    
    playground1.setOpaque(false);
    playground1.setBackground(Color.WHITE);
    playground1.addMouseListener(new MouseAdapter() { 
      public void mouseClicked(MouseEvent evt) { 
        playground1_MouseClicked(evt);
      }
    });
    cp.add(playground1,BorderLayout.CENTER);
    playground1.add(t);
    t.setHeading(90);
    
    JPanel pKnoepfe= new JPanel();
    pKnoepfe.setLayout(new GridLayout());
    
    bPutzen.setText("putzen");
    bPutzen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bPutzen_ActionPerformed(evt);
      }
    });
    pKnoepfe.add(bPutzen);
    
    bLos.setText("los");
    bLos.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bLos_ActionPerformed(evt);
      }
    });
    pKnoepfe.add(bLos);
    
    bRot.setText("rot");
    bRot.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bRot_ActionPerformed(evt);
      }
    });
    bRot.setForeground(Color.BLACK);
    bRot.setBackground(Color.RED);
    pKnoepfe.add(bRot);
    
    bBlau.setText("blau");
    bBlau.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bBlau_ActionPerformed(evt);
      }
    });
    bBlau.setBackground(Color.BLUE);
    bBlau.setForeground(Color.WHITE);
    pKnoepfe.add(bBlau);
    
    bGruen.setText("grün");
    bGruen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bGruen_ActionPerformed(evt);
      }
    });
    bGruen.setBackground(Color.GREEN);
    pKnoepfe.add(bGruen);
    
    bGelb.setText("gelb");
    bGelb.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bGelb_ActionPerformed(evt);
      }
    });
    bGelb.setBackground(Color.YELLOW);
    pKnoepfe.add(bGelb);
    cp.add(pKnoepfe, BorderLayout.SOUTH);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Zeichnen
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Zeichnen();
  } // end of main
  
  /**
   * Eigene Funktionen
   */
  
  public void koordinatensystem (double zoom) {
   
    }
  
  public void geheZu(double x, double y) {
     double entfernung=t.distance(x,y);
      double richtung =t.towards(x,y);
      t.setHeading(richtung);
      t.fd(entfernung);
    }
  
  public double parabel(double a, double b, double c, double x){
     return a*x*x+b*x+c;
    }
  
  /**
   * Action-Methoden
   */
   
  public void bLos_ActionPerformed(ActionEvent evt) {
    t.hideTurtle();
    double zoom = 20;   //Eine Einheit ist sonst einen Pixel breit.
    koordinatensystem(zoom);
    double a= 0.5;
    double b= 2;
    double c= -1;
      
    double start=-20.0;
    double stop= 20;
    double step=.5;
    double y=parabel (a, b, c, start); 
    t.setPos(start*zoom, y*zoom);
      
    for (double x= start; x < stop; x+=step) {
      y= parabel(a, b, c, x);
      geheZu(x*zoom, y*zoom);
     }
    
  } // end of bLos_ActionPerformed
    
    
  public void bRot_ActionPerformed(ActionEvent evt) {
    //Konsolenausgabe: Wertetabelle
    
    
  } // end of bRot_ActionPerformed
    
  public void bBlau_ActionPerformed(ActionEvent evt) {
    // Konsolenausgabe: Scheitelpunkt 
  } // end of bBlau_ActionPerformed
    
  public void bGruen_ActionPerformed(ActionEvent evt) {
    // Konsolenausgabe: Anzahl Nullstellen
  } // end of bGruen_ActionPerformed
  
  public void bGelb_ActionPerformed(ActionEvent evt) {
    // Konsolenausgabe: Art der Funktion Parabel, Gerade, konstante Fkt
    // Öffnung nach oben/unten, steigend/fallend...
    
  } // end of bGelb_ActionPerformed
    
  public void bPutzen_ActionPerformed(ActionEvent evt) {
    t.clear();
    t.showTurtle();
    t.setHeading(90);
    
  } // end of bPutzen_ActionPerformed
  
  public void playground1_MouseClicked(MouseEvent evt) {
    // Hier nichts verändern, da dadurch die Mausaktion gelingt.
    t.setX(evt.getX()-playground1.getWidth()/2);
    t.setY(playground1.getHeight()/2-evt.getY());
    t.setHeading(90);
    
   } // end of playground1_MouseClicked
  
// Ende Methoden
} // end of class Zeichnen

