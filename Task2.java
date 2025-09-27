import java.util.* ;

public class Task2{      // Student Grade calculator.

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("number of subjects: ");
        int numSub = sc.nextInt();

        int marks[] = new int[numSub];
        int totMarks = 0 ;

        for(int i = 0 ; i<numSub ; i++){

            System.out.print("enter marks for subject " +(i +1)+ " (out of hundred)");
            marks[i] = sc.nextInt();

            while(marks[i] < 0 || marks[i] > 100){
                  
                  System.out.print("Invalid input. Enter marks between 0 and 100: ");
                  marks[i] = sc.nextInt();
            }

            totMarks += marks[i] ;
        }

        double avePercentage = (double) totMarks/numSub ;
        String grade ;

        if(avePercentage >= 90){
             
             grade = "A+" ;

        } else if(avePercentage >= 80){

            grade = "A" ;

        } else if(avePercentage >= 70){

            grade = "B" ;

        } else if(avePercentage >= 60) {

            grade = "C" ;

        } else if(avePercentage >= 50){

            grade = "D" ;

        } else {

            grade = "F" ;

        }

        System.out.println("____Rsults_____");
        System.out.println("total marks: " +totMarks+ " out of " +(numSub * 100));
        System.out.println("Average percentage: " +avePercentage+"%");
        System.out.println("Grade: " +grade);

        sc.close(); 
    }
}