import java.util.ArrayList;

/**
 * Created by abramenko on 21.10.16.
 */
public class Editor {
    public ArrayList<Character> editTab (ArrayList<Character> arraylist, int count)
    {
        int rank=count, quant=0;
        ArrayList<Character> line = arraylist;
        for (int i=0; i<line.size(); i++) {
            if (line.get(i) == ' ') {
                quant++;
            }
            else {
                break;
            }
        }
        for (int i=0; i<line.size(); i++) {
            if (line.get(i)=='{' && rank>=0) {
                rank--;
            }
            else if (line.get(i)=='}') {
                for (int j=0; j<i; j++) {
                    if (line.get(j)!=' ') {
                        rank++;
                        break;
                    }
                }
            }
        }
        if (quant<rank*4) {
            for (int i=0; i<rank*4-quant; i++) {
                line.add(0,' ');
            }
        }
        if (quant>rank*4) {
            for (int i=0; i<quant-rank*4; i++) {
                line.remove(0);
            }
        }

        return line;
    }
}
