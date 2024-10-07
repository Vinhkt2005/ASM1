import java.util.*;
class StudentManager {
    // Using List to store the list of students
    private List<Student> students;
    private Stack<Student> addedStudents; // Stack to store recently added students
    private Queue<String> editQueue; // Queue to manage edit requests

    public StudentManager() {
        students = new ArrayList<>();
        addedStudents = new Stack<>();
        editQueue = new LinkedList<>();
    }

    // Add a new student
    public void addStudent(String id, String name, double marks) {
        if (marks < 0 || marks > 10) {
            System.out.println("Invalid Marks! Please enter marks between 0 and 10.");
            return;
        }
        Student newStudent = new Student(id, name, marks);
        students.add(newStudent);
        addedStudents.push(newStudent); // Push to stack
    }

    // Edit student information
    public void editStudent(String id, String newName, double newMarks) {
        editQueue.add(id); // Add edit request to queue
        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.set(students.indexOf(student), new Student(id, newName, newMarks));
                break;
            }
        }
    }

    // Delete a student
    public void deleteStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    // Bubble Sort
    public void bubbleSortByMarks() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMarks() < students.get(j + 1).getMarks()) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }

    // Merge Sort
    public void mergeSortByMarks() {
        students = mergeSort(students);
    }

    private List<Student> mergeSort(List<Student> studentList) {
        if (studentList.size() <= 1) {
            return studentList;
        }

        int middle = studentList.size() / 2;
        List<Student> left = new ArrayList<>(studentList.subList(0, middle));
        List<Student> right = new ArrayList<>(studentList.subList(middle, studentList.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getMarks() >= right.get(j).getMarks()) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }

    // Search student by ID
    public Student searchStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // Search student by name
    public List<Student> searchStudentByName(String name) {
        List<Student> foundStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }

    // Display all students
    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}