import javax.swing.*;
import java.awt.*;

public class ResultScreen extends JFrame {
    private JTextPane resultText;
    private String[] strings;

    ResultScreen(String[] fileStrings) {
        strings = fileStrings;

        new JFrame("Checking");
        setIconImage(new ImageIcon("src/Icon.jpeg").getImage());
        setSize(300, 200);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - 150, Toolkit.getDefaultToolkit().getScreenSize().height/2 - 100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        initLabel();

        add(resultText);
    }

    private void initLabel() {
        resultText = new JTextPane();
        resultText.setContentType("text/html");
        resultText.setEditable(false);
        resultText.setBackground(null);
        resultText.setBorder(null);
        resultText.setLocation(5, 5);
        resultText.setSize(this.getWidth() - 26, this.getHeight()-48);

        String[] res = findInfo();

        String resString = "";
        for (int i = 0; i < res.length; i++) {
            resString += res[i] + "<br>";
        }
        resultText.setText("<html>" + resString + "</html>");

        resultText.setVisible(true);
    }

    private String[] findInfo() {
        Finder finder = new Finder();
        return finder.findAll(strings);
    }

}
