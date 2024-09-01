import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class moneyManager {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.println("First we need to create your profile.");
        System.out.println("Enter your first name?");
        String fName = s.next();
        System.out.println("Enter your last name?");
        String lname = s.next();
        
        System.out.println("What is your birth month (1-12)?");
        int bMonth = s.nextInt(); 
        System.out.println("What is your birth date?");
        int bDate = s.nextInt();
        System.out.println("What year were you born in?");
        int bYear = s.nextInt();
        
        if (bYear > Calendar.getInstance().get(Calendar.YEAR)) {
            System.out.println("Please enter a valid birthday");
            return; 
        }

        else if (bYear > 2008){
                System.out.println("You have to be at least 16 years old");
                return; 
        }

        else if (bYear <= 1912){
            System.out.println("Please enter a valid birthday");
            return; 
        }  
        
        Calendar today = Calendar.getInstance();
        int currentYear = today.get(Calendar.YEAR);
        int currentMonth = today.get(Calendar.MONTH) + 1; 
        int currentDay = today.get(Calendar.DAY_OF_MONTH);

        int age = currentYear - bYear;
        if (currentMonth < bMonth || (currentMonth == bMonth && currentDay < bDate)) {
            age--; 
        }
        
        int idNumber = rand.nextInt(9999) + 1000;
        char idLetter1 = fName.charAt(0);
        char idLetter2 = lname.charAt(0);
        System.out.print("Your identification number is: " + idLetter1);
        System.out.print(idLetter2);
        System.out.println(idNumber);

        System.out.println("Create a 4 digit pin:");
        int aPin = s.nextInt();

        double balance;

        System.out.println("Enter your job title");
        String jobTitle = s.next();
        System.out.println("How many hours did you work a month?");
        Double worked = s.nextDouble();
        System.out.println("What is your hourly rate?");
        Double rate = s.nextDouble();
        
        Double gross = worked * rate;
        System.out.printf("Your gross pay is $%.2f", gross);
        System.out.println();
        
        Double fed = 0.15 * gross;
        System.out.printf("Your federal taxes are $%.2f", fed);
        System.out.println();
        
        Double fica = 0.0765 * gross;
        System.out.printf("Your FICA taxes are $%.2f", fica);
        System.out.println();
        
        Double state = 0.04 * gross;
        System.out.printf("Your state taxes are $%.2f", state);
        System.out.println();
        
        Double taxes = fed + fica + state;
        Double net = gross - taxes;
        System.out.printf("Your net pay is $%.2f", net);
        System.out.println();
        balance = net;
        


        System.out.println("How much do you pay a month for your house?");
        Double houseMonthly = s.nextDouble();
        balance = balance - houseMonthly;

        

        System.out.println("How much do you pay a month for your car?");
        Double carMonthly = s.nextDouble();
        balance = balance - carMonthly;

        if (balance < 0) 
        {
            System.out.printf("You have spent $%.2f", -balance);
            System.out.println(" more than you have. Please review your expenses and income.");
        } 
        else 
        {
            System.out.printf("You have $%.2f", balance);
            System.out.println(" remaining");
        }
    }
}
