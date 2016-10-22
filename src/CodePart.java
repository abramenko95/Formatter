package PACKAGE_NAME;

/**
 * Created by abramenko on 21.10.16.
 */
public class CodePart {
    private static CodePart ourInstance = new CodePart();

    public static CodePart getInstance() {
        return ourInstance;
    }

    private CodePart() {
    }
}
