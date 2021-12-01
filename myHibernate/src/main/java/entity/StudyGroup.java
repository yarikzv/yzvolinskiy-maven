package entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * The entity of StudyGroup. Has the same fields as table 'study_groups'. And another List<Student> students
 * for mapping to Students entities.
 * Used Lombok annotation {@code @NoArgsConstructor}, {@code @Getter}, {@code @Setter} and {@code @EqualsAndHashCode}
 * for creating empty constructor and getters and setters.
 * <p>
 * Annotated as @Entity.
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "study_groups")
public class StudyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer studyGroupId;

    @Column(name = "group_name")
    private String groupName;

    /*
     * @OneToMany annotation for mapping Students id. Mapped by studyGroup field from Student class
     */
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "studyGroup",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Student> students;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nStudyGroup {");
        sb.append("studyGroupId=").append(studyGroupId);
        sb.append(", groupName='").append(groupName).append('\'');
        sb.append(", students=").append(students);
        sb.append('}').append("\n").append("-".repeat(80));
        return sb.toString();
    }

    // Setter modification for List<Student> students for adding students to list.
    public void setStudents(List<Student> students) {
        if (students != null) {
            students.forEach(student -> student.setStudyGroup(this));
        }
        this.students = students;
    }
}
