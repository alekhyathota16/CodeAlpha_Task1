import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    ArrayList<Integer> grades;

    Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grades = new ArrayList<>();
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double getAverage() {
        if (grades.isEmpty()) return 0.0;
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return (double) sum / grades.size();
    }
}

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Enter details for Student " + (i + 1) + " ---");
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter roll number: ");
            int roll = sc.nextInt();

            Student s = new Student(name, roll);

            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();

            for (int j = 0; j < subjects; j++) {
                System.out.print("Enter marks for subject " + (j + 1) + ": ");
                int grade = sc.nextInt();
                s.addGrade(grade);
            }
            sc.nextLine(); // clear buffer
            students.add(s);
        }

        // Display all students' data
        System.out.println("\n--- Student Records ---");
        System.out.printf("%-15s %-10s %-15s %-10s\n", "Name", "Roll No", "Grades", "Average");
        for (Student s : students) {
            System.out.printf("%-15s %-10d %-15s %-10.2f\n",
                    s.name, s.rollNumber, s.grades.toString(), s.getAverage());
        }

        sc.close();
    }
}
