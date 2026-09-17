import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;

    public Student(String firstName, String middleName, String lastName, String email) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
    }

    public void showInfo() {
        System.out.println("\n========== Student Profile ==========");
        System.out.println("First Name:  " + firstName);
        System.out.println("Middle Name: " + middleName);
        System.out.println("Last Name:   " + lastName);
        System.out.println("Email:       " + email);
        System.out.println("=====================================");
    }
}

public class StudentEnrollment {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    // ADD STUDENT
    public static void addStudent() {
        System.out.println("\n========== Add Student ==========");

        System.out.print("First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Middle Name: ");
        String middleName = sc.nextLine();

        System.out.print("Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        Student student = new Student(
                firstName,
                middleName,
                lastName,
                email);

        students.add(student);

        System.out.println("\nStudent successfully added!");
    }

    // SHOW ALL STUDENTS
    public static void showStudents() {

        if (students.isEmpty()) {
            System.out.println("\nNo students enrolled.");
            return;
        }

        System.out.println("\n========== Enrolled Students ==========");

        for (int i = 0; i < students.size(); i++) {
            System.out.println("\nStudent #" + (i + 1));
            students.get(i).showInfo();
        }
    }

    // EDIT STUDENT
    // TO BE IMPLEMENTED

    // DELETE STUDENT
    public static void deleteStudent() {

        if (students.isEmpty()) {
            System.out.println("\nNo students enrolled.");
            return;
        }

        showStudents();

        System.out.print("\nEnter student number to delete: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index < 1 || index > students.size()) {
            System.out.println("Invalid student number.");
            return;
        }

        students.remove(index - 1);

        System.out.println("\nStudent successfully deleted!");
    }

    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            System.out.println("\n========== Student Enrollment ==========");
            System.out.println("1. Add Student");
            System.out.println("2. Show Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.println("========================================");

            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    showStudents();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    running = false;
                    System.out.println("\nProgram ended.");
                    break;

                default:
                    System.out.println("\nInvalid choice.");
            }
        }

        sc.close();
    }
}