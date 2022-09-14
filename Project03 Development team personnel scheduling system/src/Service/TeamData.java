package Service;

public class TeamData {

    public static final int STAFF = 10;
    public static final int PROGRAMMER = 11;
    public static final int DESIGNER = 12;
    public static final int ARCHITECT = 13;

    public static final int PC = 21;
    public static final int MAC = 22;
    public static final int PRINTER = 23;

    //Employee  :  10, id, name, age, salary
    //Programmer:  11, id, name, age, salary
    //Designer  :  12, id, name, age, salary, bonus
    //Architect :  13, id, name, age, salary, bonus, stock
    public static final String[][] EMPLOYEES = {
            {"10", "1", "Matthew Smith", "22", "3000"},
            {"13", "2", "Jerry Johnson", "32", "18000", "15000", "2000"},
            {"11", "3", "James Brown", "23", "7000"},
            {"11", "4", "Michael Williams", "24", "7300"},
            {"12", "5", "Joseph White", "28", "10000", "5000"},
            {"11", "6", "Thomas Sanchez", "22", "6800"},
            {"12", "7", "Christopher Clark", "29", "10800", "5200"},
            {"13", "8", "Daniel Lewis", "30", "19800", "15000", "2500"},
            {"12", "9", "Anthony Walker", "26", "9800", "5500"},
            {"11", "10", "Mark Robinson", "21", "6600"},
            {"11", "11", "Donald Trump", "25", "7100"},
            {"12", "12", "Richard Scott", "27", "9600", "4800"},
            {"13", "23", "Charles Torres", "20", "15000", "20000", "5000"}
    };

    //PC :21, model, display
    //mac:22, model, price
    //Printer :23, type, name
    public static final String[][] EQUIPMENTS = {
            {},
            {"22", "Lenovo", "6000"},
            {"21", "HP ", "AT7-N52"},
            {"21", "Dell", "3800-R33"},
            {"23", "laser", "Canon 2900"},
            {"21", "ASUS", "K30BD-21"},
            {"21", "HP", "18-511X 19"},
            {"23", "Dot matrix printer", "Epson 20K"},
            {"22", "HPM6", "5800"},
            {"21", "Lenovo", "ThinkCentre"},
            {"21", "ASYS", "KBD-A54M5 "},
            {"22", "HPM6", "5800"},
            {"21", "APPLE", "Apple32"}
    };
}


