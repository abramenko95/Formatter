import java.util.ArrayList;

/**
 * Text editor
 */
public class Editor {
    private int rank;
    /**
     * Edit space
     * @param line text;
     * @param count value for rank;
     */
    public ArrayList<Character> editTab(final ArrayList<Character> line, final int count) {
        int  quant = 0;
        final int space = 4;
        rank = count;
        for (Character i : line) {
            if (i == ' ') {
                quant++;
            } else {
                break;
            }
        }
        for (int i = 0; i < line.size(); i++) {
            if (line.get(i) == '{' && rank >= 0) {
                rank--;
            } else if (line.get(i) == '}') {
                for (int j = 0; j < i; j++) {
                    if (line.get(j) != ' ') {
                        rank++;
                        break;
                    }
                }
            }
        }
        if (quant < rank * space) {
            for (int i = 0; i < rank * space - quant; i++) {
                line.add(0, ' ');
            }
        }
        if (quant > rank * space) {
            for (int i = 0; i < quant - rank * space; i++) {
                line.remove(0);
            }
        }

        return line;
    }
    /**
     * Edit semicolon
     * @param line text;
     */
    public ArrayList<Character> editScol(final ArrayList<Character> line) {
        int count = 0;
        final int space = 4;
        for (int i = 0; i < line.size(); i++) {
            switch (line.get(i)) {
                case '(':
                    count++;
                    break;
                case ')':
                    count--;
                    break;
                case ';':
                    if (count <= 0 && i != line.size() - 2) {
                        i++;
                        while (line.get(i) == ' ') {
                            line.remove(i);
                        }
                        if (line.get(i) != ')') {
                            line.add(i, '\n');
                        }
                        i++;
                        for (int j = 0; j < rank * space; j++) {
                            line.add(i, ' ');
                        }
                    }
            }

        }
        return line;
    }
}
