package entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * The entity of Student. Has the same fields as table 'students'.
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
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer studentId;

    @Column(name = "name")
    private String name;

    /*
     * @ManyToOne annotation. Doesn't use CascadeType.ALL because no need to delete the child if studyGroup is deleting.
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;

    @Column(name = "became_year")
    private Integer becameYear;

    /*
     * toString() overriding for displaying info. Displays name of group in row study_group_id.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nStudent {");
        sb.append("studentId=").append(studentId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", studyGroup=").append(studyGroup.getGroupName());
        sb.append(", becameYear=").append(becameYear);
        sb.append('}');
        return sb.toString();
    }
}

