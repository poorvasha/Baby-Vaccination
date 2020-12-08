import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class BabyVaccination {
    public static void main(String[] args) {

        // Get today's Date
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        final Scanner reader = new Scanner(System.in);
        Date date = new Date();

        // Format it into a string
        String str = String.format("%tD", date);
        System.out.println(str);

        // Split it into char array
        char[] cur = str.toCharArray();
        char[] sec = { cur[3], cur[4], ' ', cur[0], cur[1], ' ', '2', '0', cur[6], cur[7] };
        String str2 = new String(sec);

        // Get the birth-date
        System.out.println("*********************************************************");
        System.out.println(" We are here to help you ");
        System.out.println("Keep ur baby away from diseases");
        System.out.println("*********************************************************");
        System.out.println();
        System.out.println("Enter your baby's date of birth");
        String firstInput = reader.nextLine();
        final String secondInput = str2;

        // Convert the current date and birth-date into LocalDate instance
        final LocalDate firstDate = LocalDate.parse(firstInput, formatter);
        final LocalDate secondDate = LocalDate.parse(secondInput, formatter);

        // Calculate the number of days between the current date and birth-date
        final long days = ChronoUnit.DAYS.between(firstDate, secondDate);
        System.out.println("Congrats your baby has seen this wonder world for" + days + "days");
        long da = days;

        // Array contains the Vaccine details
        String str1[] = new String[14];
        str1[0] = "Bacillus Calmette Gu rin (BCG) ,Oral polio vaccine (OPV 0) ,Hepatitis B(Hep-B1)";
        str1[1] = "Diptheria, Tetanus and Pertussis vaccine (DTwP 1), Inactivated polio vaccine (IPV 1),Hepatitis B (Hep   B2) ,Haemophilus influenzae type B (Hib 1),Rotavirus 1 ,Pneumococcal conjugate vaccine (PCV 1)";
        str1[2] = "Diptheria, Tetanus and Pertussis vaccine (DTwP 2),Inactivated polio vaccine(IPV2),Haemophilusinfluenzae type B (Hib 2),Rotavirus 2,Pneumococcal conjugate vaccine (PCV 2)";
        str1[3] = "Diptheria, Tetanus and Pertussis vaccine (DTwP 3),Inactivated polio vaccine (IPV 3) , Haemophilus influenzae type B (Hib 3),Rotavirus 3,Pneumococcal conjugate vaccine (PCV 3)";
        str1[4] = "Oral polio vaccine (OPV 1),Hepatitis B (Hep   B3)";
        str1[5] = "oral polio vaccine(opv 2),Measles, Mumps, and Rubella (MMR   1)";
        str1[6] = "Typhoid Conjugate Vaccine";
        str1[7] = "Hepatitis A (Hep   A1)";
        str1[8] = "Measles, Mumps, and Rubella (MMR 2),Varicella 1,PCV booster";
        str1[9] = "Diphtheria, Perussis, and Tetanus (DTwP B1/DTaP B1),Inactivated polio vaccine (IPV B1),Haemophilus influenzae type B (Hib B1)";
        str1[10] = "Hepatitis A (Hep   A2)";
        str1[11] = "Booster of Typhoid Conjugate Vaccine";
        str1[12] = "Diphtheria, Perussis, and Tetanus (DTwP B2/DTaP B2),Oral polio vaccine (OPV 3),Varicella 2,Measles, Mumps, and Rubella (MMR 3)";
        str1[13] = "Tdap/Td,Human Papilloma Virus (HPV)";
        int t = 0;

        // Array Contains the info on no of days after birth a vaccine should be given
        int j[] = new int[14];
        j[0] = 0;
        j[1] = 42;
        j[2] = 70;
        j[3] = 98;
        j[4] = 183;
        j[5] = 274;
        j[6] = 274;
        j[7] = 365;
        j[8] = 457;
        j[9] = 486;
        j[10] = 547;
        j[11] = 730;
        j[12] = 2191;
        j[13] = 4383;

        // Check how many days are gone after birth and what are all the vaccines which
        // should be given hereafter
        int i = 0;
        for (i = 0; i < 14; i++) {
            if (days <= j[i]) {
                t = i;
                break;
            }
        }
        //System.out.println(da);

        // If the birth-date was too far for the vaccination, print the same
        if (j[13] < days) {
            System.out.println("The person doesn't need any baby vaccination");
        }
        // Print the next vaccination that should be done
        else if (t <= 14) {
            System.out.println("Baby needs " + str1[t] + " vaccination in "
                    + firstDate.plusDays(j[t]));
            System.out.println();
        }

        // Check if the user wants to know about the past vaccination
        System.out.println("\nDo you want to know the vaccines which are given before");
        String choice = reader.nextLine();
        if (choice.equalsIgnoreCase("yes")) {

            // Print the vaccines which are given before
            for (int k = 0; k < i; k++) {
                System.out.print(firstDate.plusDays(j[k]));
                System.out.println(" " + str1[k]);
            }
            System.out.println();

	}

        // Print the vaccines which are to be given in future
	System.out.println("\n know the vaccines which are to be given in future");
	if(i < 14){  
            for (int k = i; k < 14; k++) {
                System.out.print(firstDate.plusDays(j[k]));
                System.out.println(" " + str1[k]);
            }
            System.out.println();
	}
	else{
		System.out.println("Woohoo! your baby is now children! he/she no needs vaccines!");
	}
	
        // END CREDITS
        System.out.println("\n******************* Thank you ***************************\n");
        
    }
}
