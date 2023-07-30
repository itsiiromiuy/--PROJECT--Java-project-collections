import java.util.Scanner;

/**
 * Utility class for Family Budget program.
 * Encapsulating different functionality into methods for ease of use.
 */
public class Utility {
    /**
     * Prompts user for a string input.
     * @param prompt String to prompt user with.
     * @return String input from user.
     */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Prompts user for a string input - this method is used to read a number from keyboard, if user input '1'-'4', return the number
     * @param prompt String to prompt user with.
     * @return String input from user.
     */
    public static char readMenuSelection(){
        char c;
        for(;; ){
            String str = readKeyBoard(1);
            c = str.charAt(0);
            if(c != '1' && c != '2' && c != '3' && c != '4'){
                System.out.print("Invalid input, please try again: ");
            }else break;
        }
        return c;
    }

    /**
     * Prompts user for a string input - this method is used to read an integer no more than 4 bits in length from keyboard, return the number
     * @param prompt String to prompt user with.
     * @return String input from user.
     */
    public static int readNumber(){
        int number;
        for(;;){
            String string = readKeyBoard(4);
            try{
                number = Integer.parseInt(string);
                break;
            }catch (NumberFormatException e){
                System.out.print("Invalid input, please try again: ");
            }
        }
        return number;
    }

    /**
     * The input used to the entry of income and expense descriptions.
     * The method reads a string of no more than 8 bits in length from the keyboard and uses it as the method's return value.
     * @param prompt String to prompt user with.
     * @return String input from user.
     */
    public static String readString(){
        String string = readKeyBoard(8);
        return string;
    }

    /**
     * The input used to confirm the selection.
     * The method reads 'Y' or 'N' from the keyboard and uses it as the return value of the method.
     * @return
     */
    public static char readConfirmSelection(){
        char c;
        for(;;){
            String string = readKeyBoard(1).toUpperCase();
            c = string.charAt(0);
            if(c == 'Y' || c == 'N'){
                break;
            }else{
                System.out.print("Invalid input, please try again: ");
            }
        }
        return c;
    }

    /**
     * The method reads a string of no more than limit bits in length from the keyboard and uses it as the method's return value.
     * @param limit
     * @return
     */
    private static String readKeyBoard(int limit) {
        String line = "";
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (line.length() < 1 || line.length() > limit) {
                System.out.print("Input length (not greater than " + limit + ") was incorrect, please re-enter:");
                continue;
            }
            break;
        }
        return line;
    }
}



// Path: project01 Family Budget/src/Utility.java