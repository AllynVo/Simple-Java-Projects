//Allyn Vo & Juan Marin
//Project 3, classes
//3-9-2017
//CS 111

import javax.swing.*;
import java.awt.*;

public class LaborPanel extends JPanel
{
   public JTextField laborTextField;
   private JLabel messageLabel;
   
   /*
      Constructor
   */
      
   public LaborPanel()
   {
      // Create label
      messageLabel = new JLabel( "Enter additional hours of labor: " );
      
      // Create a text field.
      laborTextField = new JTextField( 10 );
      
      // Add a border around the panel.
      setBorder( BorderFactory.createTitledBorder("Additional Labor") );
      
      // Add the text field to the panel.
      add( messageLabel );
      add( laborTextField );
      
   }
}