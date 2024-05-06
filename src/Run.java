import java.io.File;

public class Run {
    public File file;
    private final Reader reader = new Reader();


    public void run() {
        StartScreen startScreen = new StartScreen();
        System.out.println(2);
        file = startScreen.file;

        while (true) {
            System.out.println(3);
            file = startScreen.file;
            if (file != null) {
                String fileString = reader.read(file);
                System.out.println(fileString);
                String[] fileStrings = fileString.split("\n");

                ResultScreen resultScreen = new ResultScreen(fileStrings);
                file = null;
                startScreen.file = null;
            }
        }

    }
}
