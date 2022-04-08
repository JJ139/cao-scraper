package nl.jellejoosten.caoscraper.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
public class CaoData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @CreationTimestamp
    private Date createdDate;

    private String objectId;
    private String naam;
    private String registratie;
    private String cao;
    private LocalDate ingangsdatum;
    private LocalDate expiratiedatum;
    private String soort;
    private String type;
    private String sbi;
    private LocalDate kvoDatum;

}
