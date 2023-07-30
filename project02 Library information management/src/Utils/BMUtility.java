package Project02.Utils;
import java.util.*;

/**
 * This class is encapsulating different functionality into methods means
 * @version 1.0
 */
public class BMUtility {
    private static Scanner scanner = new Scanner(System.in);
    /**
     * This method is 	Used for interface menu selection. The method reads the keyboard and returns if the user types any character from '1' - '5'. The return value is the character typed by the user.
     * @param limit
     * @return char
     */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' &&
                    c != '3' && c != '4' && c != '5') {
                System.out.print("Incorrect selection, please re-enter: ");
            } else break;
        }
        return c;
    }

    /**
     * This method is used to reads a character from the keyboard and uses it as the method's return value.
     * @param limit
     * @return char
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    /**
     * This method is used to reads a character from the keyboard and uses it as the method's return value. If the user does not enter a character and presses Enter, the default value is returned.
     * @param defaultValue
     * @return char
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    /**
     * This method is to reads an integer of up to 2 bits in length from the keyboard and uses it as the method's return value.
     * @return int
     * @throws NumberFormatException
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
     * This method is to reads an integer of up to 2 bits in length from the keyboard and uses it as the method's return value. If the user does not enter a character and presses Enter, the default value is returned.
     * @param defaultValue
     * @return int
     */
    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, true);
            if (str.equals("")) {
                return defaultValue;
            }

            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Number entered incorrectly, please re-enter: ");
            }
        }
        return n;
    }

    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("")? defaultValue : str;
    }

    /**
     * The input used to confirm the selection. The method reads 'Y' or 'N' from the keyboard and uses it as the return value of the method.
     * @return char
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

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("Incorrect input length (not greater than " + limit + "), please re-enter: ");
                continue;
            }
            break;
        }

        return line;
    }
}
