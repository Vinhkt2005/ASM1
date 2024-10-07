import java.util.*;
public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---------Menu--------");
            System.out.println("1. Add a student");
            System.out.println("2. Edit a student's information");
            System.out.println("3. Delete a student");
            System.out.println("4. Sort students by marks");
            System.out.println("5. Sort students using Bubble Sort");
            System.out.println("6. Sort students using Merge Sort");
            System.out.println("7. Search a student by ID");
            System.out.println("8. Search students by name");
            System.out.println("9. Display all students");
            System.out.println("10. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.next();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter marks: ");
                    double marks = scanner.nextDouble();
                    manager.addStudent(id, name, marks);
                    break;
                case 2:
                    System.out.print("Enter ID of student to edit: ");
                    String editId = scanner.next();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new marks: ");
                    double newMarks = scanner.nextDouble();
                    manager.editStudent(editId, newName, newMarks);
                    break;
                case 3:
                    System.out.print("Enter ID of student to delete: ");
                    String deleteId = scanner.nextLine();
                    manager.deleteStudent(deleteId);
                    break;
                case 4:
                    manager.bubbleSortByMarks();
                    System.out.println("Sorted using Bubble Sort.");
                    break;
                case 5:
                    manager.mergeSortByMarks();
                    System.out.println("Sorted using Merge Sort.");
                    break;
                case 6:
                    System.out.print("Enter student ID: ");
                    String searchId = scanner.nextLine();
                    Student foundStudent = manager.searchStudentById(searchId);
                    if (foundStudent != null) {
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 7:
                    System.out.print("Enter student name: ");
                    String searchName = scanner.nextLine();
                    var foundStudents = manager.searchStudentByName(searchName);
                    if (!foundStudents.isEmpty()) {
                        for (Student student : foundStudents) {
                            System.out.println(student);
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 8:
                    manager.displayAllStudents();
                    break;
                case 9:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}