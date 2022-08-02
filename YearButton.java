import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;

public class YearButton extends JButton implements ActionListener {
  private CalendarPanel view;

  YearButton(String label, CalendarPanel view) {
    super(label);
    this.view = view;
    setForeground(Color.orange);
    setBorder(null);
    setFocusable(false);
    addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    int year = changeYear();
    view.setYear(year);
  }

  private int changeYear() {
    try {
      String reply = JOptionPane.showInputDialog(null, "Change the year");
      int b = Integer.valueOf(reply);
      while (b < 1900) {
        reply = JOptionPane.showInputDialog(null, "The year should not be less than 1900!");
        b = Integer.valueOf(reply);
      }
      return Integer.valueOf(b);
    }

    catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "A mistake occurred, try again!");
      return changeYear();
    }

  }
}
