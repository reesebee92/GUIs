
/**
 * SimpleCalculator
 * 
 * This class builds a JFrame top level container called SimpleCalculator
 * and performs an action when a calculate button is triggered 
 * 
 * @author SDantzler
 * */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SimpleCalculator extends JFrame implements ActionListener {

   // instance variables
   private JPanel contentPane;
   private double val1, val2, answer;
   private JTextField value1, value2, sum;
   private JButton calculate;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               new SimpleCalculator();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }// end main method

   /**
    * Create the frame.
    */
   public SimpleCalculator() {

      // Create a new frame
      JFrame simpCalc = new JFrame("Simple Calculator");

      // Terminate the program when the user closes the application
      simpCalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Bounds of the content pane
      setBounds(100, 100, 450, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);

      // Add a new Panel with a specific Layout
      JPanel panel = new JPanel();
      GridLayout gl = new GridLayout(4, 2);
      panel.setLayout(gl);

      // Text based labels and fields added to the panel
      JLabel label1 = new JLabel("First Value:");
      value1 = new JTextField(10);
      panel.add(label1);
      panel.add(value1);

      JLabel label2 = new JLabel("Second Value:");
      value2 = new JTextField(10);
      panel.add(label2);
      panel.add(value2);

      JLabel label3 = new JLabel("Sum is:");
      sum = new JTextField(10);
      panel.add(label3);
      panel.add(sum);

      // Pushes the calculate button to the 2nd column
      JLabel label4 = new JLabel("");
      panel.add(label4);

      simpCalc.add(panel, BorderLayout.CENTER);

      // Create a Calculate button
      calculate = new JButton("Calculate");
      calculate.setText("Calculate");
      panel.add(calculate);

      // Add Action Listener and Tool Tip for calculate
      calculate.addActionListener(this);
      calculate.setToolTipText("Press this button to calculate sum.");

      // Display the frame
      simpCalc.setVisible(true);

   }// end SimpleCalculator method

   /**
    * This method triggers an action if the calculator button is pressed
    */
   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == calculate) {
         sum();
      }
   }// end actionPerformed method

   /**
    * This method calculates the sum of the two inputed values and populates the
    * sum text field with the results
    */
   public void sum() {
      try {
         val1 = Double.parseDouble(value1.getText());
         val2 = Double.parseDouble(value2.getText());
         answer = val1 + val2;
         sum.setText("" + answer);
      } catch (NumberFormatException ex) {
         value1.setText("error");
         value2.setText("error");
         sum.setText("error");
      } // end try/catch
   }// end sum method

}// end class SimpleCalculator
