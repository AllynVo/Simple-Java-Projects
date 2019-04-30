//Allyn Vo & Juan Marin
//Project 3, classes
//3-9-2017
//CS 111

import javax.swing.*;
import java.awt.*;

public class ServicePanel extends JPanel
{
   // Cost of the services.
   public final double OIL_CHANGE = 26.00;
   public final double LUBRICATION = 18.00;
   public final double RADIATOR_FLUSH = 30.00;
   public final double TRANSMISSION_FLUSH = 80.00;
   public final double INSPECTION = 15.00;
   public final double MUFFLER_REPLACEMENT = 110.00;
   public final double TIRE_ROTATION = 25.00;
   
   private JCheckBox oilChange;
   private JCheckBox lubrication;
   private JCheckBox radiatorFlush;
   private JCheckBox transmissionFlush;
   private JCheckBox inspection;
   private JCheckBox mufflerReplacement;
   private JCheckBox tireRotation;
   
   /*
      Constructor
   */
   
   public ServicePanel()
   {
      // Create GridLayout manager.
      setLayout( new GridLayout(7, 1) );
      
      // Create the check boxes.
      oilChange = new JCheckBox( "Oil Change" );
      lubrication = new JCheckBox( "Lubrication" );
      radiatorFlush = new JCheckBox( "Radiator flush" );
      transmissionFlush = new JCheckBox( "Transmission flush" );
      inspection = new JCheckBox( "Inspection" );
      mufflerReplacement = new JCheckBox( "Muffler replacement" );
      tireRotation = new JCheckBox( "Tire rotation" );
      
      // Add a border around the panel.
      setBorder( BorderFactory.createTitledBorder("Services") );
      
      // Add the check boxes to the panel.
      add(oilChange);
      add(lubrication);
      add(radiatorFlush);
      add(transmissionFlush);
      add(inspection);
      add(mufflerReplacement);
      add(tireRotation);
   }
   
   /*
      getServiceCost method
   */
   
   public double getServiceCost()
   {
      double serviceCost = 0.0;
      
      if( oilChange.isSelected() )
         serviceCost += OIL_CHANGE;
      if( lubrication.isSelected() )
         serviceCost += LUBRICATION;
      if( radiatorFlush.isSelected() )
         serviceCost += RADIATOR_FLUSH;
      if( transmissionFlush.isSelected() )
         serviceCost += TRANSMISSION_FLUSH;
      if( inspection.isSelected() )
         serviceCost += INSPECTION;
      if( mufflerReplacement.isSelected() )
         serviceCost += MUFFLER_REPLACEMENT;
      if( tireRotation.isSelected() )
         serviceCost += TIRE_ROTATION;  
      
      return serviceCost;          
   }   
}      