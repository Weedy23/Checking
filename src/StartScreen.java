import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class StartScreen extends javax.swing.JFrame {
    StartScreen() {
        new JFrame("Checking");
        setIconImage(new ImageIcon("src/Icon.jpeg").getImage());
        setBackground(Color.BLACK);
        setSize(160, 100);
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - 80, Toolkit.getDefaultToolkit().getScreenSize().height/2 - 50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        initButton();

        add(choseFileButton);
    }

    private void initButton() {
        choseFileButton = new JButton("Choose File");
        choseFileButton.setBackground(Color.PINK);
        choseFileButton.setLocation(5, 5);
        choseFileButton.setSize(this.getWidth() - 26, this.getHeight()-48);
        choseFileButton.setVisible(true);
        choseFileButton.addActionListener(e -> choseFile());
    }

    private void choseFile() {
        fileChooser = new JFileChooser();
        fileChooser.setSize(800, 600);
        fileChooser.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - 400,
                                Toolkit.getDefaultToolkit().getScreenSize().height/2 - 300);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/downloads"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
        fileChooser.setFileFilter(filter);

        int response = fileChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
        }

    }

    JButton choseFileButton;
    JFileChooser fileChooser;
    File file;
}
