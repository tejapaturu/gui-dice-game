//package view;
//
//import java.awt.GridLayout;
//import java.net.URL;
//
//import javax.swing.ImageIcon;
//import javax.swing.JApplet;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//import com.sun.prism.Graphics;
//import com.sun.prism.Image;
//
//public class DiceImageApplett extends JApplet {
//
//    public void paint(Graphics g) {
//        JPanel panel = new JPanel(new GridLayout(2, 2));
//        add(panel);
//
//        JLabel label1 = new JLabel();
//        panel.add(label1);
//        JLabel label2 = new JLabel();
//        panel.add(label2);
//        JLabel label3 = new JLabel();
//        panel.add(label3);
//        JLabel label4 = new JLabel();
//        panel.add(label4);
//
//        try {
//            URL url = new URL("YOU_IMAGE_URL.jpg");
//            java.awt.Image myPicture = getImage(url);
//
//            label1.setIcon(new ImageIcon(myPicture));
//            label2.setIcon(new ImageIcon(myPicture));
//            label3.setIcon(new ImageIcon(myPicture));
//            label4.setIcon(new ImageIcon(myPicture));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
package view;

/*
 * This panel displays 2 dice
 * Before any rolls have been played, it
 * will display "0 0". During rolls, it
 * will display intermediate and final
 * results. The result of the house roll
 * will remain until the next roll.
 */
import java.awt.*;
import javax.swing.*;


public class DicePanel extends JPanel
{
//   private static final long serialVersionUID = 8379;

   private JLabel dice1;
   private JLabel dice2;
   private JLabel who;

   public DicePanel()
   {
      who = new JLabel("");
      dice1 = new JLabel("0", SwingConstants.CENTER);
      dice2 = new JLabel("0", SwingConstants.CENTER);

      dice1.setBorder(BorderFactory.createTitledBorder("dice1"));
      dice2.setBorder(BorderFactory.createTitledBorder("dice2"));


      this.setLayout(new GridLayout(1,3));
      this.add(who);
      this.add(dice1);
      this.add(dice2);
      this.setMaximumSize(new Dimension(225, 125));
   }

   public void updateDice(String playerName, int dice1, int dice2)
   {
      who.setText(playerName + ":");
      this.dice1.setText("" + dice1);
      this.dice2.setText("" + dice2);

      this.revalidate();
   }
}
