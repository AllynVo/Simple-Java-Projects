//Allyn Vo & Juan Marin
//Project 3 
//Main client
//3-9-2017
//CS 111

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class AmountDueP3 extends JFrame
{
   private GreetingPanel banner;
   private ServicePanel service;
   private LaborPanel labor;
   
   private JPanel buttonPanel;
   private JButton calcButton;
   private JButton exitButton;
   
   private final double TAX_RATE = 0.09;
   
   /*
      Constructor 
   */
   
   public AmountDueP3()
   {
      // Set window settings.
      setTitle( "Calculate Amount Due" );
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
      // Create border layout manager.
      setLayout( new BorderLayout() );
      
      // Create the custom panels.
      banner = new GreetingPanel();
      service = new ServicePanel();
      labor = new LaborPanel();
      
      // Create the button panel.
      buildButtonPanel();
      
      // Add the components to the content pane.
      add( banner, BorderLayout.NORTH );
      add( service, BorderLayout.WEST );
      add( labor, BorderLayout.CENTER );
      add( buttonPanel, BorderLayout.SOUTH );
      
      // Pack the contents of the window and display it
      pack();
      setVisible( true );
   }
   
   private void buildButtonPanel()
   {
      // Create a panel for the buttons.
      buttonPanel = new JPanel();
      
      // Create the buttons.
      calcButton = new JButton( "Calculate" );
      exitButton = new JButton( "Exit" );
      
      // Register the action listeners.
      calcButton.addActionListener( new CalcButtonListener() );
      exitButton.addActionListener( new ExitButtonListener() );
      
      // Add the buttons to the button panel. 
      buttonPanel.add( calcButton );
      buttonPanel.add( exitButton );
   }
   
   /*
      Private inner class to handle event when calculate button is pressed
   */
   
   private class CalcButtonListener implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
         // Variables
         double serviceExpenses, laborExpenses, total, taxes, amountDue;
         final double LABOR_RATE = 45.00;
         String input; // Holds the additonal hours of labor
         
         // Get text entered from the user
         // and convert it to double
         input = labor.laborTextField.getText();
         try
         {
            laborExpenses = Double.parseDouble( input ) * LABOR_RATE;
         
            // Get service(s) amount
            serviceExpenses = service.getServiceCost();
            
            // Calculate the total of service and labor
            total = serviceExpenses + laborExpenses;
            
            // Calculate the tax of the total
            taxes = total * TAX_RATE;
            
            // Calculate the final amount due
            amountDue = total + taxes;
            
            // Throw exception if labor expenses is less than 0
            if( laborExpenses < 0 )
               throw new NumberFormatException();
            
            // Display the charges on a new window.
            JOptionPane.showMessageDialog( null, "Standard Services: $" + String.format("%.02f", serviceExpenses) +
                                                 "\nLabor: $" + String.format("%.02f", laborExpenses) +
                                                 "\nTotal: $" + String.format("%.02f", total) +
                                                 "\nTaxes: $" + String.format("%.02f", taxes) +
                                                 "\nAmount Due: $" + String.format("%.02f", amountDue) );
         }
         catch( NumberFormatException ee )
         {
            JOptionPane.showMessageDialog( null, "The input is not a number or is negative.\nTry again." );
         }
      }
   }
   
   /*
      Private inner class to handle event when exit button is pressed
   */
   
   private class ExitButtonListener implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
         System.exit(0);
      }
   }  
   
   /*
      Main Method
   */
   
   public static void main(String[] args)
   {
      new AmountDueP3();
   }   
      
}