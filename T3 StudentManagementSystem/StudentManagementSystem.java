import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class StudentManagementSystem {

    private List<Std> student;

    public StudentManagementSystem() {
        student = new ArrayList<>();
    }

    public void addStd(Std std) {
        student.add(std);
        System.out.println("Student added successfully.");
    }

    public void removeStd(int rollNumber) {
        boolean removed = false;
        for (int i = 0; i < student.size(); i++) {
            Std std = student.get(i);
            if (std.getRollNumber() == rollNumber) {
                student.remove(i);
                removed = true;
                System.out.println("Student removed successfully.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Student not found with roll number: " + rollNumber);
        }
    }

    public void searchStd(int rollNumber) {
        for (Std std : student) {
            if (std.getRollNumber() == rollNumber) {
                System.out.println("Student found:");
                System.out.println("Name: " + std.getName());
                System.out.println("Roll Number: " + std.getRollNumber());
                System.out.println("Grade: " + std.getGrade());
                return;
            }
        }
        System.out.println("Student not found with roll number: " + rollNumber);
    }

    public void displayAllStudent(String Details) {
        if (student.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("All Students:");
            for (Std std : student) {
                System.out.println("Student:");
                System.out.println("Name: " + std.getName());
                System.out.println("Roll Number: " + std.getRollNumber());
                System.out.println("Grade: " + std.getGrade());
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            int option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter name: ");
                    String name = scan.nextLine();
                    System.out.println("Enter roll number: ");
                    int rollNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter grade: ");
                    String grade = scan.nextLine();

                    Std std = new Std(name, rollNumber, grade);
                    system.addStd(std);
                    break;

                case 2:
                    System.out.println("Enter roll number of the student to remove: ");
                    int removeRollNumber = scan.nextInt();
                    scan.nextLine();

                    system.removeStd(removeRollNumber);
                    break;

                case 3:
                    System.out.println("Enter roll number of the student to search: ");
                    int searchRollNumber = scan.nextInt();
                    scan.nextLine();

                    system.searchStd(searchRollNumber);
                    break;

                case 4:
                    System.out.println("plz click enter for \nDisplaying all students Details");
                    String displayStudents = scan.nextLine();
                    system.displayAllStudent(displayStudents);
                    break;

                case 5:
                    System.out.println("You Have Been Exited From Application");
                    System.exit(0);

                default:
                    System.out.println("You have selected Invalid Option.\n Please Select Valid Option");
                    break;
            }
        }
    }
}