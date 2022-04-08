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
public class CaoScraperApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CaoScraperApplication.class, args);
	}

}
