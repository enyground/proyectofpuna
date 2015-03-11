/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.Timer;



  // Define Show Popup ActionListener
  public class Mensaje implements ActionListener {
    private final Component component;

    public Mensaje(Component component) {
      this.component = component;
    }

   /*public ShowPopupActionListener() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public synchronized void actionPerformed(ActionEvent actionEvent) {
      JButton button = new JButton("! Debe ingresar los datos");
      button.setPreferredSize(new Dimension(200, 100));
      PopupFactory factory = PopupFactory.getSharedInstance();
     // Random random = new Random();
      int x = 200;
      int y = 100;
      final Popup popup = factory.getPopup(component, button, x, y);
      popup.show();
      ActionListener hider = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          popup.hide();
        }
      };
      // Hide popup in 3 seconds
      Timer timer = new Timer(3000, hider);
      timer.start();
    }

  }

    
  
