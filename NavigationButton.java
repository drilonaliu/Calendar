import javax.swing.JButton;
import java.awt.*;

public class NavigationButton extends JButton {

    public NavigationButton(String name) {
        super(name);
        this.setFont(new Font("TimesRoman", Font.BOLD, 28));
        this.setForeground(Color.white);
        this.setBorderPainted(false);
        this.setBackground(new Color(48, 54, 88));
        this.setFocusable(false);
        this.setBorder(null);
    }

}
