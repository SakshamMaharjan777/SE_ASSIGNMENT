import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentRepository repository = new StudentRepository();

        System.out.println("1. Add Student");
        System.out.println("2. Calculate Average & Grade");
        System.out.println("3. View All Students");
        System.out.print("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                addStudent(scanner, repository);
                break;
            case 2:
                calculateGrade(scanner);
                break;
            case 3:
                viewAllStudents(repository);
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }

    private static void addStudent(Scanner scanner, StudentRepository repository) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter math score: ");
        int math = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter science score: ");
        int science = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter english score: ");
        int english = Integer.parseInt(scanner.nextLine());

        Student student = new Student(name, id, math, science, english);
        repository.addStudent(student);
    }

    private static void calculateGrade(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter math score: ");
        int math = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter science score: ");
        int science = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter english score: ");
        int english = Integer.parseInt(scanner.nextLine());

        Student student = new Student(name, id, math, science, english);
        System.out.println("Student: " + student.getName() + ", ID: " + student.getId()
                + ", Avg Score: " + student.getAverage());
        System.out.println("Grade: " + student.getGrade());
    }

    private static void viewAllStudents(StudentRepository repository) {
        List<Student> students = repository.getAllStudents();
        for (Student s : students) {
            System.out.println("Name: " + s.getName() + ", ID: " + s.getId()
                    + ", Scores: " + s.getMathScore() + "," + s.getScienceScore() + "," + s.getEnglishScore());
        }
    }
}