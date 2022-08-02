import java.awt.*;
import java.util.GregorianCalendar;
import javax.swing.*;

public class CalendarPanel extends JPanel {

    private int month;
    private int year;
    private Color myBlue = new Color(48, 54, 88);
    private String[] months = { "January", "February", "March", "April",
            "May", "June", "July", "August", "September",
            "October", "November", "December" };
    private String[] weekdays = { "Mo", "Tu", "We", "Th", "Fr", "Sa", "Su" };
    private String[][] current_calendar;
    private int[] todayDate;
    PreviousButton perviousMonth;
    NextButton nextMonth;
    YearButton changeYear;

    CalendarPanel() {

        GregorianCalendar myCalendar = new GregorianCalendar();
        this.month = myCalendar.get(GregorianCalendar.MONTH) + 1;
        this.year = myCalendar.get(GregorianCalendar.YEAR);
        this.setLayout(null);
        GregorianCalendar cal = new GregorianCalendar();
        todayDate = new int[] { cal.get(GregorianCalendar.DAY_OF_MONTH), cal.get(GregorianCalendar.MONTH) + 1,
                cal.get(GregorianCalendar.YEAR) };
        // buttons
        perviousMonth = new PreviousButton("‹", this);
        perviousMonth.setBounds(340, 37, 20, 20);
        nextMonth = new NextButton("›", this);
        nextMonth.setBounds(370, 37, 20, 20);
        changeYear = new YearButton("📆", this);
        changeYear.setForeground(myBlue);
        changeYear.setBounds(400, 40, 20, 20);

        // panel
        setBackground(myBlue);
        // frame
        JFrame myFrame = new JFrame();
        myFrame.setTitle("Kalendari");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(500, 450);
        myFrame.setResizable(false);

        this.add(perviousMonth);
        this.add(nextMonth);
        this.add(changeYear);
        myFrame.add(this);
        myFrame.setVisible(true);
    }

    public void paintComponent(Graphics g1) {

        // Graphic properties
        super.paintComponent(g1);
        Graphics2D g = (Graphics2D) g1;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(10);
        g.setStroke(stroke);
        g.setColor(Color.white);

        // Month and Year
        g.setFont(new Font("COMIC SANS MS", Font.BOLD, 33));
        g.drawString(monthAndYear(month, year), 70, 70);

        // Day names
        g.setFont(new Font("COMIC SANS MS", Font.PLAIN, 20));
        int l = 70;
        for (int i = 0; i < weekdays.length; i++) {
            g.drawString(weekdays[i], l, 125);
            l += 50;
        }

        // Dates
        int x = 70;
        int y = 175;

        boolean check = (month == todayDate[1] && year == todayDate[2]);

        current_calendar = CalendarModel.getMonthArray(month, year);
        for (int i = 0; i < current_calendar.length; i++) {
            for (int j = 0; j < current_calendar[0].length; j++) {
                String a = current_calendar[i][j];
                System.out.println();
                if (check && String.valueOf(todayDate[0]).equals(a)) {
                    g.setColor(Color.orange);
                }
                g.drawString(a, x, y);
                g.setColor(Color.white);
                x += 52;
            }
            y += 30;
            x = 70;

        }
    }

    public void nextMonth() {
        if (month == 12) {
            month = 1;
            year = year + 1;
        } else {
            month = month + 1;
        }
        repaint();
    }

    public void previousMonth() {
        if (month == 1) {
            month = 12;
            year = year - 1;
        } else {
            month = month - 1;
        }
        repaint();
    }

    public void setYear(int year) {
        this.year = year;
        repaint();
    }

    String monthAndYear(int month, int year) {
        return months[month - 1] + " " + year;
    }
}
