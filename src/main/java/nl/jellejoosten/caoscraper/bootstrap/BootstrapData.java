package nl.jellejoosten.caoscraper.bootstrap;

import nl.jellejoosten.caoscraper.converters.CaoDataConverter;
import nl.jellejoosten.caoscraper.domain.CaoData;
import nl.jellejoosten.caoscraper.repositories.CaoDataRepository;
import nl.jellejoosten.caoscraper.services.CaoScrapingService;
import nl.jellejoosten.caoscraper.web.model.CaoDataDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class BootstrapData implements CommandLineRunner {

    CaoScrapingService caoScrapingService;
    CaoDataConverter caoDataConverter;
    CaoDataRepository caoDataRepository;


    public BootstrapData(CaoScrapingService caoScrapingService, CaoDataConverter caoDataConverter,
                                 CaoDataRepository caoDataRepository) {
        this.caoScrapingService = caoScrapingService;
        this.caoDataConverter = caoDataConverter;
        this.caoDataRepository = caoDataRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading data...");
        for (int i = 6787; i < 7000; i++) {
            System.out.println(i);
            // get cao data dto
            CaoDataDto dto = caoScrapingService.scrapeCaoByObjectId(String.valueOf(i));

            if (dto != null) {
                // convert dto to entity
                CaoData caoData = caoDataConverter.caoDataDtoToCaoData(dto);

                // persist entity to database if found
                System.out.println(caoDataRepository.save(caoData));
            }
        }
        System.out.println("Completed Data Loading.");

    }
}
