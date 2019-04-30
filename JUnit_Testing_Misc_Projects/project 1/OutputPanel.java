import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel
{
   private JLabel output1, output2, output3, output4, output5;
   
   /*
      Contructor
   */
   
   public OutputPanel( double SE, double LE, double TOT, double TAX, double AD )
   {
      // Create GridLayout manager.
      setLayout( new GridLayout(5, 1) );
      
      output1 = new JLabel( "Standard Services: $" + String.format("%.02f", SE) +
                            "Labor: $" + String.format("%.02f", LE) +
                            "Total: $" + String.format("%.02f", TOT) +
                            "Taxes: $" + String.format("%.02f", TAX) +
                            "Amount Due: $" + String.format("%.02f", AD) );
      output2 = new JLabel(  );
      output3 = new JLabel(  );
      output4 = new JLabel(  );
      output5 = new JLabel( "Amount Due: $" + String.format("%.02f", AD) );
      
      // Add a border around the panel.
      setBorder( BorderFactory.createTitledBorder("Charges") );
      
      add( output1 );
      add( output2 );
      add( output3 );
      add( output4 );
      add( output5 );
   }   
}