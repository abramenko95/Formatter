import java.util.ArrayList;

/**
 * Created by abramenko on 21.10.16.
 */
public class Editor {
    int rank;
    //Edit tabulation
    public ArrayList<Character> editTab (ArrayList<Character> arraylist, int count)
    {
        int  quant=0;
        rank=count;
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
    //Edit semicolon
    public ArrayList<Character> editScol (ArrayList<Character> arraylist)
    {
        ArrayList<Character> line = arraylist;
        int count=0;
        for (int i=0; i<line.size(); i++) {
            switch (line.get(i)) {
                case '(':
                    count++;
                    break;
                case ')':
                    count--;
                    break;
                case ';':
                    if (count<=0 && i!=line.size()-2) {
                        i++;
                        while (line.get(i)==' ') {
                            line.remove(i);
                        }
                        if (line.get(i)!=')') {
                            line.add(i, '\n');
                        }
                        i++;
                        for (int j=0; j<rank*4; j++) {
                            line.add(i,' ');
                        }
                    }
            }

        }
        return line;
    }
}
