//package home.abramenko.IdeaProjects.Formatter.src.main.java;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Main class
 */
public final class Formatter {
    /**
     *
     * @param args input arguments;
     */
    public static void main(final String[] args) {
        ArrayList<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>();
        String file;
        if (args.length == 1) {
            file = args[0];
        } else {
            file = "CodePart.java";
        }
        try (FileReader reader = new FileReader(file)) {
            int c, rank = 0;
            Editor editor = new Editor();
            ArrayList<Character> line = new ArrayList<Character>();
            while ((c = reader.read()) != -1) {
                line.add((char) c);
                if (c == '\n') {
                    line = editor.editTab(line, rank);
                    line = editor.editScol(line);
                    list.add(line);
                    line = new ArrayList<Character>();
                }
                if (c == '{') {
                    rank++;
                }
                if (c == '}') {
                    rank--;
                }

            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try (FileWriter writer = new FileWriter(file, false)) {
            for (ArrayList<Character> i : list) {
                for (Character j : i) {
                    writer.write(j);
                }
            }
            writer.flush();
        }
        catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
