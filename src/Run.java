import java.io.File;

public class Run {
    private StartScreen startScreen;
    public File file;
    private Reader reader = new Reader();
    private ResultScreen resultScreen;



    public void run() {
        startScreen = new StartScreen();
        System.out.println(2);
        file = startScreen.file;

        while (file == null) {
            System.out.println(3);
            file = startScreen.file;
        }


        System.out.println(4);
        String fileString = reader.read(file);
        System.out.println(fileString);
        String[] fileStrings = fileString.split("\n");
        
        resultScreen = new ResultScreen(fileStrings);
    }
}
