package peaksoft.sessionjava17restapi.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String imageUrl;
    String groupName;
    LocalDate createDate;
    String description;
    @OneToMany(mappedBy = "group",cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    List<Student> students;

}
