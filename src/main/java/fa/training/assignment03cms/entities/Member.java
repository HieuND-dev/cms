package fa.training.assignment03cms.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@ToString(exclude = "contents")
@Entity
@Table(name="member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "description")
    private String description;

    @Column(name = "created_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime createdDate;

    @Column(name = "update_time")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime updateTime;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Content> contents;
}
