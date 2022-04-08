package nl.jellejoosten.caoscraper.converters;

import nl.jellejoosten.caoscraper.domain.CaoData;
import nl.jellejoosten.caoscraper.web.model.CaoDataDto;
import org.springframework.stereotype.Component;

@Component
public class CaoDataConverter {

    public CaoData caoDataDtoToCaoData(CaoDataDto dto) {
        CaoData caoData = CaoData.builder()
                .naam(dto.getNaam())
                .objectId(dto.getObjectId())
                .registratie(dto.getRegistratie())
                .cao(dto.getCao())
                .ingangsdatum(dto.getIngangsdatum())
                .expiratiedatum(dto.getExpiratiedatum())
                .soort(dto.getSoort())
                .type(dto.getType())
                .sbi(dto.getSbi())
                .kvoDatum(dto.getKvoDatum())
                .build();

        return(caoData);
    }

}
