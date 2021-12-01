import entity.Student;
import entity.StudyGroup;
import service.StudentService;
import service.StudyGroupService;


public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        StudyGroupService studyGroupService = new StudyGroupService();
        Student studentPetrov1 = new Student();
        Student studentPetrov2 = new Student();
        Student studentIvanov = new Student();
        Student studentSemenov = new Student();
        Student studentTkachenko = new Student();
        StudyGroup studyGroupPC001 = new StudyGroup();
        StudyGroup studyGroupPT001 = new StudyGroup();
        StudyGroup studyGroupPA001 = new StudyGroup();

        // Groups entity save test
        studyGroupPC001.setGroupName("PC-001");
        studyGroupService.saveOrUpdate(studyGroupPC001);

        studyGroupPT001.setGroupName("PT-001");
        studyGroupService.saveOrUpdate(studyGroupPT001);

        studyGroupPA001.setGroupName("PA-001");
        studyGroupService.saveOrUpdate(studyGroupPA001);

        // Students entity save test
        studentPetrov1.setName("Петров П. П.");
        studentPetrov1.setBecameYear(2005);
        studentPetrov1.setStudyGroup(studyGroupPA001);
        studentService.saveOrUpdate(studentPetrov1);

        studentPetrov2.setName("Петров B. H.");
        studentPetrov2.setBecameYear(2002);
        studentPetrov2.setStudyGroup(studyGroupPA001);
        studentService.saveOrUpdate(studentPetrov2);

        studentIvanov.setName("Иванов И. И.");
        studentIvanov.setBecameYear(2020);
        studentIvanov.setStudyGroup(studyGroupPT001);
        studentService.saveOrUpdate(studentIvanov);

        studentSemenov.setName("Семенов С. С.");
        studentSemenov.setBecameYear(2010);
        studentSemenov.setStudyGroup(studyGroupPC001);
        studentService.saveOrUpdate(studentSemenov);

        studentTkachenko.setName("Ткаченко М. С.");
        studentTkachenko.setBecameYear(2015);
        studentTkachenko.setStudyGroup(studyGroupPT001);
        studentService.saveOrUpdate(studentTkachenko);

        // Change became year for studentIvanov and update test
        Student student = studentService.get(2);
        student.setBecameYear(2000);
        studentService.saveOrUpdate(student);

        // Change group name for studyGroupPC001 and update test
        StudyGroup studyGroup = studyGroupService.get(1);
        studyGroup.setGroupName("PC-211");
        studyGroupService.saveOrUpdate(studyGroup);

        // Student get by id test
        System.out.println("⁘".repeat(80));
        System.out.println("Student with id 2: " + studentService.get(2));

        // Student get all test
        System.out.println("⁘".repeat(80));
        System.out.println("All students: " + studentService.getAll());

        //Group get by id test
        System.out.println("⁘".repeat(80));
        System.out.println("Group with id 3: " + studyGroupService.get(3));

        //Group get all test
        System.out.println("⁘".repeat(80));
        System.out.println("All groups: " + studyGroupService.getAll());

        // Find by part of name student test
        System.out.println("⁘".repeat(80));
        System.out.println("Find 'петр': " + studentService.findByNameContaining("петр"));
    }
}
