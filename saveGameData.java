import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class saveGameData {
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    BufferedReader bufferedReader;
    File file;
    Scanner scanner;

    public saveGameData() {
        file = new File("savegame.txt");
        try {
            fileWriter = new FileWriter(file, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bufferedWriter = new BufferedWriter(fileWriter);
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void save(String name, int line) {
        file = new File("savegame.txt");
        try {
            scanner = new Scanner(bufferedReader);
            scanner.useDelimiter("\n");
            for (int i = 0; i < line; i++) {
                scanner.next();
            }

            scanner.close();
            bufferedWriter.write(name);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String load(int line) {
        String loadedString = "";
        try {
            bufferedReader.mark(10);
            for (int i = 0; i < line; i++) {
                bufferedReader.readLine();
            }
            loadedString = bufferedReader.readLine();
            bufferedReader.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedString;
    }
}
