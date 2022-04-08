package nl.jellejoosten.caoscraper;

import nl.jellejoosten.caoscraper.services.CaoScrapingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CaoScraperApplication implements CommandLineRunner {

	CaoScrapingService caoScrapingService;

	public CaoScraperApplication(CaoScrapingService caoScrapingService) {
		this.caoScrapingService = caoScrapingService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CaoScraperApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		for (int i = 9000; i < 9500; i++) {
			System.out.println(caoScrapingService.scrapeCaoByObjectId(String.valueOf(i)).toString());
		}

	}
}
