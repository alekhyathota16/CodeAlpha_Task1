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
        for (int g : grades) sum += g;
        return (double) sum / grades.size();
    }

    int getHighest() {
        int max = Integer.MIN_VALUE;
        for (int g : grades) if (g > max) max = g;
        return max;
    }

    int getLowest() {
        int min = Integer.MAX_VALUE;
        for (int g : grades) if (g < min) min = g;
        return min;
    }
}

public class StudentGradesSummary {
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

        // Display individual student data
        System.out.println("\n--- Student Records ---");
        System.out.printf("%-15s %-10s %-15s %-10s %-10s %-10s\n",
                "Name", "Roll No", "Grades", "Average", "Highest", "Lowest");

        for (Student s : students) {
            System.out.printf("%-15s %-10d %-15s %-10.2f %-10d %-10d\n",
                    s.name, s.rollNumber, s.grades.toString(),
                    s.getAverage(), s.getHighest(), s.getLowest());
        }

        // Summary report for all students
        int totalGrades = 0, totalSubjects = 0;
        int highestOverall = Integer.MIN_VALUE;
        int lowestOverall = Integer.MAX_VALUE;

        for (Student s : students) {
            for (int g : s.grades) {
                totalGrades += g;
                totalSubjects++;
                if (g > highestOverall) highestOverall = g;
                if (g < lowestOverall) lowestOverall = g;
            }
        }

        double overallAverage = (double) totalGrades / totalSubjects;

        System.out.println("\n--- Summary Report ---");
        System.out.println("Overall Average Score: " + String.format("%.2f", overallAverage));
        System.out.println("Highest Score Among All Students: " + highestOverall);
        System.out.println("Lowest Score Among All Students: " + lowestOverall);

        sc.close();
    }
}
