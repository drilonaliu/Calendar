import java.awt.event.*;

public class PreviousButton extends NavigationButton implements ActionListener {

    private CalendarPanel view;

    PreviousButton(String label, CalendarPanel view) {
        super(label);
        this.view = view;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.previousMonth();
    }

}
