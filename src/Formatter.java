import java.io.*;
import java.util.*;
import java.lang.*;


public class Formatter {
    public static void main (String[] Args) {
        ArrayList<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>();
        try(FileReader reader = new FileReader("CodePart.java"))
        {
            int c, rank=0;
            Editor editor = new Editor();
            ArrayList<Character> line = new ArrayList<Character>();
            while((c=reader.read())!=-1){
                line.add((char)c);
                if (c=='\n') {
                    line = editor.editTab (line, rank);
                    list.add(line);
                    line = new ArrayList<Character>();
                }
                if (c=='{') {
                    rank++;
                }
                if (c=='}') {
                    rank--;
                }

            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        for (int i=0; i<list.size(); i++)
        {
            for (int j=0; j<list.get(i).size(); j++)
            {
                System.out.print(list.get(i).get(j));
            }

        }
    }
}
