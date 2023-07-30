public class FamilyAccount {
    public static void main(String[] args){
        String details = "Flow\t\t\tAmount\t\tBalance\t\tDescription\n";
        int balance = 10000;

        boolean isFlag = true;
        while(isFlag){
            System.out.println("-----------------Family Account-----------------");
            System.out.println("                 1. Details");
            System.out.println("                 2. Income");
            System.out.println("                 3. Expense");
            System.out.println("                 4. Exit");
            System.out.print("Please select (1-4): ");

            char selection = Utility.readMenuSelection();
            switch (selection){
                case '1':
                    System.out.println("-----------------Details-----------------");
                    System.out.println(details);

                    break;
                case '2':
                    System.out.println("-----------------Amount of current income-----------------");
                    int amount = Utility.readNumber();  // read the amount of income
                    System.out.println("-----------------Description of current income-----------------");
                    String desc = Utility.readString(); // read the description of income
                    balance += amount;
                    details += ("Income\t\t\t" + amount + "\t\t\t" + balance + "\t\t\t" + desc + "\n");
                    System.out.println("-----------------Income completed-----------------");
                    break;
                case '3':
                    System.out.println("-----------------Expense-----------------");
                    System.out.println("Amount of current expense: ");
                    int expenseAmount = Utility.readNumber();
                    System.out.println("Description of current expense: ");
                    String expenseDesc = Utility.readString();

                    balance -= expenseAmount;
                    details += ("Expense\t\t\t" + expenseAmount + "\t\t\t" + balance + "\t\t\t" + expenseDesc + "\n");
                    System.out.println("-----------------Expense completed-----------------");

                    break;
                case '4':
                    System.out.println("Confirm exit? (Y/N): ");
                    char isExit = Utility.readConfirmSelection();
                    if(isExit == 'Y'){
                        isFlag = false;
                    }
                    break;
            }

        }while(isFlag);
    }
}
