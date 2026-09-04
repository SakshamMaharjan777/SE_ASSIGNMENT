import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static final String FILE_NAME = "students.txt";

    // Adds a student to the file
    public void addStudent(Student student) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(student.toCsv() + "\n");
            System.out.println("Added student: " + student.getName() + " with ID: " + student.getId());
        } catch (IOException e) {
            System.out.println("Error writing student to file: " + e.getMessage());
        }
    }

    // Reads all students from the file
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                students.add(Student.fromCsv(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading students from file: " + e.getMessage());
        }
        return students;
    }
}