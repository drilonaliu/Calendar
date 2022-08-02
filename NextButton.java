
import java.awt.event.*;

public class NextButton extends NavigationButton implements ActionListener {

    private CalendarPanel view;

    NextButton(String label, CalendarPanel view) {
        super(label);
        this.view = view;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.nextMonth();
    }

}
