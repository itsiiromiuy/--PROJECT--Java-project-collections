package View;

import java.util.Scanner;

public class TSUtility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * @return
     * @Description This method reads the keyboard and returns if the user types any character from '1'-'4'. The return value is the character typed by the user.
     * @author Yuimorii
     * @name readMenuSelection
     */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' &&
                    c != '3' && c != '4') {
                System.out.print("Incorrect selection, please re-enter: ");
            } else break;
        }
        return c;
    }

    /**
     * @Description The method prompts and waits until the user presses the enter key to return.
     * @author Yuimorii
     */
    public static void EnterReadReturn() {
        System.out.print("Press enter to continue...");
        readKeyBoard(100, true);
    }

    /**
     * @return
     * @Description This method reads an integer up to 2 digits in length from the keyboard and uses it as the method's return value.
     * @author Yuimorii
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Number entered incorrectly, please re-enter: ");
            }
        }
        return n;
    }

    /**
     * @return
     * @Description Read 'Y' or 'N' from the keyboard and use it as the method's return value.
     * @author Yuimorii
     * @name readConfirmSelection
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("Incorrect selection, please re-enter: ");
            }
        }
        return c;
    }

    /**
     * @param
     * @return
     * @name readKeyBoard
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }
            if (line.length() < 1 || line.length() > limit) {
                System.out.print("Enter length (not greater than " + limit + ") error, please re-enter:");
                continue;
            }
            break;
        }

        return line;
    }
}

