//Allyn Vo & Juan Marin
//Project 3, classes
//3-9-2017
//CS 111

import javax.swing.*;
import java.awt.*;

public class GreetingPanel extends JPanel
{
   private JLabel instructions;
   
   /*
      Contructor
   */
   
   public GreetingPanel()
   {
      // Create GridLayout manager.
      setLayout( new GridLayout(2, 1) );
      
      instructions = new JLabel( "- Select the Service(s) and Enter the hours of labor. (Enter 0 if no addional hours)" );
      add( instructions );
      
      instructions = new JLabel( "- Then press Calculate." );
      add( instructions );
      
      // Add a border around the panel.
      setBorder( BorderFactory.createTitledBorder("Instructions") );
      
      
   }   
}