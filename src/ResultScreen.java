import javax.swing.*;
import java.awt.*;

public class ResultScreen extends JFrame {
    private JLabel resultLabel;
    private String[] strings;

    ResultScreen(String[] fileStrings) {
        strings = fileStrings;

        new JFrame("Checking");
        setSize(300, 200);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - 150, Toolkit.getDefaultToolkit().getScreenSize().height/2 - 100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        initLabel();

        add(resultLabel);
    }

    private void initLabel() {
        resultLabel = new JLabel();
        resultLabel.setLocation(5, 5);
        resultLabel.setSize(this.getWidth() - 26, this.getHeight()-48);

        String[] res = findInfo();

        String resString = "";
        for (int i = 0; i < res.length; i++) {
            resString += res[i] + "<br>";
        }
        resultLabel.setText("<html>" + resString + "</html>");

        resultLabel.setVisible(true);
    }

    private String[] findInfo() {
        Finder finder = new Finder();
        return finder.findAll(strings);
    }

}
