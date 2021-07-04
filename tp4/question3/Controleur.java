package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Décrivez votre classe Controleur ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    
    private JLabel label;
    
    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");
        
        label = new JLabel();

        setLayout(new GridLayout(2, 1));
        add(donnee);
        donnee.addActionListener(null /* null est À  remplacer */);
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        boutons.add(push);  push.addActionListener(new CalculatorListener());
        boutons.add(add);   add.addActionListener(new CalculatorListener());
        boutons.add(sub);   sub.addActionListener(new CalculatorListener());
        boutons.add(mul);   mul.addActionListener(new CalculatorListener());
        boutons.add(div);   div.addActionListener(new CalculatorListener());
        boutons.add(clear); clear.addActionListener(new CalculatorListener());
        
        boutons.add(label);
        
        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
    }

    public void actualiserInterface() {
        donnee.setText("");
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

    
    // en cas d'exception comme division par zéro, 
    // mauvais format de nombre suite À  l'appel de la méthode operande
    // la pile reste en l'état (intacte)
   // class CalculListener implements Action Listener
   
   class CalculatorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String op = ((JButton) e.getSource()).getActionCommand();
            if (donnee.getText() != null) {
                
                if (op.equals("push")) {
                    try {
                        
                        pile.empiler(operande());
                        donnee.setText("");
                    } catch (PilePleineException ex) {
                         
                    }
                    catch(NumberFormatException n){}
                } else if (op.equals("+") ) {
                    if (pile.taille()>=2)
                    try {
                        pile.empiler(pile.depiler() + pile.depiler());
                        label.setText(""+pile.sommet());
                    } catch (PileVideException ex) {
                         
                    } catch (PilePleineException ex) {
                         
                    }catch(NumberFormatException n){}

                } else if (op.equals("-") ) {
                    if (pile.taille()>=2)
                    try {
                        pile.empiler(pile.depiler() - pile.depiler());
                        label.setText(""+pile.sommet());
                    } catch (PileVideException ex) {
                         
                    } catch (PilePleineException ex) {
                         
                    }catch(NumberFormatException n){}

                } else if (op.equals("*")) {
                    if (pile.taille()>=2)
                    try {
                        pile.empiler(pile.depiler() * pile.depiler());
                        label.setText(""+pile.sommet());
                    } catch (PileVideException ex) {
                         
                    } catch (PilePleineException ex) {
                         
                    }catch(NumberFormatException n){}
                } else if (op.equals("/")) {
                    if (pile.taille()>=2)
                    try {
                        int temp = pile.depiler();
                        if (temp != 0) {
                            pile.empiler(pile.depiler() / temp);
                            label.setText(""+pile.sommet());
                        } else {
                            donnee.setText("Error");
                        }
                    } catch (PileVideException ex) {
                         
                    } catch (PilePleineException ex) {
                         
                    }catch(NumberFormatException n){}

                }
                else
                {
                    while(!pile.estVide())
                    {
                        try
                        {
                            pile.depiler();
                            label.setText("");
                        }
                        catch (PileVideException pve)
                        {
                            
                        }
                    }
                }
            }
        }
    }

}
