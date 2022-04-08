package nl.jellejoosten.caoscraper.web.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class CaoDataDto {

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

    @Override
    public String toString() {
        return "CaoDataDto{" +
                "objectId='" + objectId + '\'' +
                ", naam='" + naam + '\'' +
                ", registratie='" + registratie + '\'' +
                ", cao='" + cao + '\'' +
                ", ingangsdatum=" + ingangsdatum +
                ", expiratiedatum=" + expiratiedatum +
                ", soort='" + soort + '\'' +
                ", type='" + type + '\'' +
                ", sbi='" + sbi + '\'' +
                ", kvoDatum=" + kvoDatum +
                '}';
    }
}
