import java.io.File;

public class Run {
    private StartScreen startScreen;
    public File file;
    private Reader reader = new Reader();
    private ResultScreen resultScreen;



    public void run() {
        startScreen = new StartScreen();
        file = startScreen.file;
        for (; file == null;) {
            file = startScreen.file;
        }
        System.out.println(file);
        reader.read(file);
    }
}
