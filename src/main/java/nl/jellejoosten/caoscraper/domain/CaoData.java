package nl.jellejoosten.caoscraper.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cao_data")
public class CaoData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Override
    public String toString() {
        return "CaoData{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", objectId='" + objectId + '\'' +
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CaoData caoData = (CaoData) o;

        if (id != null ? !id.equals(caoData.id) : caoData.id != null) return false;
        if (createdDate != null ? !createdDate.equals(caoData.createdDate) : caoData.createdDate != null) return false;
        if (objectId != null ? !objectId.equals(caoData.objectId) : caoData.objectId != null) return false;
        if (naam != null ? !naam.equals(caoData.naam) : caoData.naam != null) return false;
        if (registratie != null ? !registratie.equals(caoData.registratie) : caoData.registratie != null) return false;
        if (cao != null ? !cao.equals(caoData.cao) : caoData.cao != null) return false;
        if (ingangsdatum != null ? !ingangsdatum.equals(caoData.ingangsdatum) : caoData.ingangsdatum != null)
            return false;
        if (expiratiedatum != null ? !expiratiedatum.equals(caoData.expiratiedatum) : caoData.expiratiedatum != null)
            return false;
        if (soort != null ? !soort.equals(caoData.soort) : caoData.soort != null) return false;
        if (type != null ? !type.equals(caoData.type) : caoData.type != null) return false;
        if (sbi != null ? !sbi.equals(caoData.sbi) : caoData.sbi != null) return false;
        return kvoDatum != null ? kvoDatum.equals(caoData.kvoDatum) : caoData.kvoDatum == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (objectId != null ? objectId.hashCode() : 0);
        result = 31 * result + (naam != null ? naam.hashCode() : 0);
        result = 31 * result + (registratie != null ? registratie.hashCode() : 0);
        result = 31 * result + (cao != null ? cao.hashCode() : 0);
        result = 31 * result + (ingangsdatum != null ? ingangsdatum.hashCode() : 0);
        result = 31 * result + (expiratiedatum != null ? expiratiedatum.hashCode() : 0);
        result = 31 * result + (soort != null ? soort.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (sbi != null ? sbi.hashCode() : 0);
        result = 31 * result + (kvoDatum != null ? kvoDatum.hashCode() : 0);
        return result;
    }
}
