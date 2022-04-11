package nl.jellejoosten.caoscraper;

import nl.jellejoosten.caoscraper.converters.CaoDataConverter;
import nl.jellejoosten.caoscraper.domain.CaoData;
import nl.jellejoosten.caoscraper.repositories.CaoDataRepository;
import nl.jellejoosten.caoscraper.services.CaoScrapingService;
import nl.jellejoosten.caoscraper.web.model.CaoDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CaoScraperApplication implements CommandLineRunner {

	CaoScrapingService caoScrapingService;
	CaoDataConverter caoDataConverter;
	CaoDataRepository caoDataRepository;


	public CaoScraperApplication(CaoScrapingService caoScrapingService, CaoDataConverter caoDataConverter,
						 CaoDataRepository caoDataRepository) {
		this.caoScrapingService = caoScrapingService;
		this.caoDataConverter = caoDataConverter;
		this.caoDataRepository = caoDataRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CaoScraperApplication.class, args).close();
	}

	@Override
	public void run(String... args) throws Exception {

		// 2022-04-08 | 6787 - 10.000 | start: 18:01 | finish: 18:30
		// 2022-04-08 | 10.000 - 13.000 | start: 18:50 | finish: 19:18
		// 2022-04-08 | 13.000 - 18.000 | start: 19:19 | finish: 20:02
		// 2022-04-08 | 18.000 - 30.000 | start: 20:03 | finish:
		System.out.println("Loading data...");
		for (int i = 18000; i < 30000; i++) {
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
		return;
	}
}
