import java.util.*;

class MarksCalculator
{
	public static void main(String[] args) 
	{
		Student s = new Student();
		s.getInput();
		s.getCalculate();
		s.display();

    }
}
class Student 
{

	int rollno;
    String name;
    char grade;
    float m1, m2, m3, m4, m5, per;
    float sum = 0;

    Scanner sc = new Scanner(System.in);
	public void getInput()
	{
		System.out.print("Enter Name : ");
		name = sc.next();

		System.out.print("Enter roll no : ");
		rollno = sc.nextInt();

		System.out.print("Enter marks in Subject 1 : ");
        m1 = sc.nextFloat();

        System.out.print("Enter marks in Subject 2 : ");
        m2 = sc.nextFloat();

        System.out.print("Enter marks in Subject 3 : ");
        m3 = sc.nextFloat();

        System.out.print("Enter marks in Subject 4 : ");
        m4 = sc.nextFloat();

        System.out.print("Enter marks in Subject 5 : ");
        m5 = sc.nextFloat();
	}

	public void getCalculate()
	{
		sum = m1 + m2 + m3 + m4 + m5;
		per = sum / 5;


		if (per < 100 && per >= 90)
		{
            grade = 'O';
        } 
        else if (per < 90 && per >= 80) 
        {
            grade = 'A';
        } 
        else if (per < 80 && per >= 70) 
        {
            grade = 'B';
        } 
        else if (per < 70 && per >= 60) 
        {
            grade = 'C';
        } 
        else if (per < 60 && per >= 50) 
        {
            grade = 'D';
        } 
        else 
        {
            grade = 'F';
        }


	}

	public void display()
	{
		System.out.println("* * * * * * * Student Information * * * * * * *");
		System.out.println("Roll No. : "+rollno);
		System.out.println("Name : "+name);	
		System.out.println("Marks in subject 1 : "+m1);	
		System.out.println("Marks in subject 2 : "+m2);	
		System.out.println("Marks in subject 3 : "+m3);	
		System.out.println("Marks in subject 4 : "+m4);	
		System.out.println("Marks in subject 5 : "+m5);	
		System.out.println("Total Marks : "+sum);
		System.out.println("Percentage : "+per+" % ");
		System.out.println("Grade : "+grade);
		

	}
}