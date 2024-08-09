package fa.training.assignment03cms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "content")
@DynamicUpdate
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Integer contentId;

//    @NotBlank
//    @Length(min = 10, max = 200)
    @Column(name = "title")
    private String title;

//    @NotBlank
//    @Length(min = 10, max = 150)
    @Column(name = "brief")
    private String brief;

//    @NotBlank
//    @Length(min = 10, max = 1000)
    @Column(name = "content")
    private String contentField;

    @Column(name = "create_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime createDate;

    @Column(name = "update_time")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime updateTime;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Member author;
}
