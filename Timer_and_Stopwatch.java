import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class  Timer_and_Stopwatch{
    private JFrame frame;
    private JLabel timerLabel;
    private JLabel stopwatchLabel;
    private Timer timer;
    private long startTime;

     public  void TimerStopwatchApp() {
        
        frame = new JFrame("Timer and Stopwatch");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timerLabel = new JLabel("Timer: 0");
        stopwatchLabel = new JLabel("Stopwatch: 0");

        JButton startTimerButton = new JButton("Start Timer");
        JButton stopTimerButton = new JButton("Stop Timer");
        JButton startStopwatchButton = new JButton("Start Stopwatch");
        JButton stopStopwatchButton = new JButton("Stop Stopwatch");

        timer = new Timer(1000, new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                timerLabel.setText("Timer: " + count++);
            }
        });

        startTimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });

        stopTimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });

        startStopwatchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTime = System.currentTimeMillis();
                Timer stopwatchTimer = new Timer(10, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        long currentTime = System.currentTimeMillis();
                        long elapsedTime = (currentTime - startTime) / 10;
                        stopwatchLabel.setText("Stopwatch: " + elapsedTime / 100.0 + " seconds");
                    }
                });
                stopwatchTimer.start();
            }
        });

        stopStopwatchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopwatchLabel.setText("Stopwatch: 0");
            }
        });

        frame.add(timerLabel);
        frame.add(startTimerButton);
        frame.add(stopTimerButton);
        frame.add(stopwatchLabel);
        frame.add(startStopwatchButton);
        frame.add(stopStopwatchButton);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Timer_and_Stopwatch sc=new Timer_and_Stopwatch();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                sc.TimerStopwatchApp();
            }
        });
    }
}
