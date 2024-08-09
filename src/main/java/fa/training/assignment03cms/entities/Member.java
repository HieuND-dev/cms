package fa.training.assignment03cms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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

//    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

//    @NotEmpty
    @Column(name = "last_name")
    private String lastName;

//    @NotBlank
//    @Length(min = 3, max = 50)
    @Column(name = "username")
    private String username;

//    @NotBlank
//    @Length(min = 8, max = 50)
    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

//    @Email
//    @NotBlank
//    @Length(min = 5, max = 50)
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
