//Take marks obtained out of 100 in each subjects
//Calculate Total marks
//Calculate Average percentage
//Assign grades as per the average percentage

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        //We have taken marks as input for 5 different subjects.

        System.out.println("Enter the marks for subject 1 subjects");
        int sub1= scanner.nextInt();
        System.out.println("Enter the marks for subject 2");
        int sub2= scanner.nextInt();
        System.out.println("Enter the marks for subject 3");
        int sub3= scanner.nextInt();
        System.out.println("Enter the marks for subject 4");
        int sub4= scanner.nextInt();
        System.out.println("Enter the marks for subject 5");
        int sub5= scanner.nextInt();

        //We have calculated total marks

        int totalMarks= (sub1+sub2+sub3+sub4+sub5);
        System.out.println("Total marks obtained is: "+totalMarks);

        //We have calculated Average percentage

        double average= ((totalMarks)/5);
        System.out.println("Average percentage is: "+average);

        //We have assign different grades on the basis of average percentage.

        if (average>=90 && average<=100) {
            System.out.println("Grade: A+");
        } else if (average>=80 && average<90) {
            System.out.println("Grade: A");
        } else if (average>=70 && average<80) {
            System.out.println("Grade: B");
        } else if (average>=60 && average<70) {
            System.out.println("Grade: C");
        } else if (average>=50 && average<60) {
            System.out.println("Grade: D");
        } else if (average>=33 && average<50) {
            System.out.println("Grade: E");
        } else {
            System.out.println("Grade: FAIL");
        }
    }
    }
