# A calendar with Java

This is a calendar programmed in Java I designed as homework from *David Schmidt : Programming Principles in Java (chapter 7 exercise 7)*. You can navigate between the months or change a year higher than $1900$. Run the Calendar by running the main method from *StartCalendar* class.

![CalendarGif](https://user-images.githubusercontent.com/84543584/182487141-e417ff80-978d-4866-8044-0d785b008014.gif)

# How it works?

The dates are all calculated within *CalendarModel* class, by using the first day of the year $1900$ (which is Monday). We count the number of days between the first day of the year $1900$ and the selected month and year. Then this number *modulo 7* gives us the day on which the month starts. Once we have that, and the number of days this month, then we have a calendar. This class has the method *getMonthMatrix()*, which returns a $6x7$ matrix as a string representation of calendar for a specific month. For example, for *July 2022* this matrix is: 

![image](https://user-images.githubusercontent.com/84543584/182503080-b604927f-77f7-4748-80f7-ea55e51427d2.png)

Each column represents a day (*starting from monday*), so for this case the fourth element of the first array represents Thursday. Then in *paintComponent()* method from *CalendarPanel* class we iterate through this matrix and draw strings with the values inside it (*"x" are replaced with empty strings  in the actual version*).

The way this algorithm works is quite simple. What it does is that it fills a following matrix like one below, except that the negative values and numbers higher than the total number of days of the month are conditioned to appear as empty strings.

![image](https://user-images.githubusercontent.com/84543584/182505256-8b9b2e63-d163-4077-8ca2-993582cc2dc2.png)

We initialize a counter *day* starting from $1 -(startDay-1)$, and increment it while visiting the elements of the matrix. The algorithm inside the method *getMonthMatrix* goes:

        int day = 1 - (startDay - 1);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (day > 0 && day <= monthDays) {
                    monthArray[i][j] = day + "";
                } else {
                    monthArray[i][j] = "";
                }
                day++;
            }
        }

And this is pretty much it. You can use this model class so that you can come up with a different visual appearnce for a calendar, whether that may be java or with html,css and js. I'd be happy to see them. 
