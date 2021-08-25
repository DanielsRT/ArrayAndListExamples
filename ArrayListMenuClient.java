import java.util.*;

public class ArrayListMenuClient {
    
    static String MENU = "\n(A)dd element, (D)elete element, (I)nsert element, (Q)uit program\n";
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        ArrayList<Double> valList = new ArrayList<>();
        char userChoice;
        do {
            showTheListElements(valList);
            userChoice = getChoice();
            
            switch (userChoice) {
                case 'A':
                    addElementToList(valList);
                    break;
                case 'D':
                    // delete element
                    break;
                case 'I':
                    // insert element
                    break;
                case 'Q':
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("No such option");
            }
        } while (userChoice != 'Q');
    }
    
    // addElementToList(valList);
    static void addElementToList(ArrayList<Double> valList) {
        System.out.print("Enter a floating point value to add to the list: ");
        /*
         * the trailing newline issue arises when a program uses both
         * (a) line-oriented input methods such as nextLine() and
         * (b) tokenizing input methods, e.g. next(), nextInt(), and nextDouble()
         * 
         * the issue is that the tokenizing methods don't clear the end-of-line
         * character from the input buffer, so it's there waiting when the
         * nextLine() method executes again, often in another part of the program.
         * 
         * There are two ways to avoid the issue, shown below.
         */
        
        /*
         * 1. after the tokenized call, consume the trailing newline 
         * 
         * double valToAdd = sc.nextDouble(); // leaves trailing newline
         * sc.nextLine(); // consume the trailing newline
         */
        
        /*
         * 2. stick to line-oriented input, and parse the input in
         * the program instead of using a tokenizing input method
         */
        double valToAdd = Double.parseDouble(sc.nextLine());      
        
        valList.add(valToAdd);
    }
    
    // showTheListElements(valList);
    static void showTheListElements(ArrayList<Double> valList) {
        System.out.println("\nIndex   Element");
        System.out.println("=====   =======");
        for(int ndx = 0; ndx < valList.size(); ndx++) {
            System.out.printf("%2d       %,.2f\n",ndx,valList.get(ndx));
        }
    }
    
    // userChoice = getChoice();
    static char getChoice() {
        System.out.print(MENU);
        System.out.print("Enter your choice: ");
        String user_input = sc.nextLine().toUpperCase();
        return user_input.charAt(0);
    }
}