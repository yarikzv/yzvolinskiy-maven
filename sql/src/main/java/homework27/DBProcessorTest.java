package homework27;

public class DBProcessorTest {
    public static void main(String[] args) {
        // testing getStudentById() by id = 3
        Student student = DBProcessor.getStudentById(3);
        System.out.println("Student by id: " + student.getName());
        System.out.println("-".repeat(20));

        // testing getStudentById() by id = -3
        Student studentNegative = DBProcessor.getStudentById(-3);
        System.out.println("Student by id: " + studentNegative.getName());
        System.out.println("-".repeat(20));

        // testing deleteStudentById() by id = 5
        System.out.println("Deleting: " + DBProcessor.deleteStudentById(5));
        System.out.println("-".repeat(20));

        // testing getAllStudents() and displaying more attractive using Stream API
        System.out.println("List of all students:");
        DBProcessor.getAllStudents().stream().map(Student::getName).forEach(System.out::println);
        System.out.println("-".repeat(20));

        // testing getStudentListByLastName() by lastName = null and displaying more attractive using Stream API
        try {
            DBProcessor.getStudentListByLastName(null).stream().map(Student::getName).forEach(System.out::println);
            System.out.println("getStudentListByLastName() not throws NullPointerException");
            System.out.println("-".repeat(20));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        // testing getStudentListByLastName() by lastName = "Петров" and displaying more attractive using Stream API
        System.out.println("List of students by last name Петров:");
        DBProcessor.getStudentListByLastName("Петров").stream().map(Student::getName).forEach(System.out::println);


        //closing connection
        ConnectionUtil.shutdown();
    }
}
