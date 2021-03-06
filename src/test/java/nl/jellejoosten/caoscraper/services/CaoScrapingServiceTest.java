package nl.jellejoosten.caoscraper.services;

import nl.jellejoosten.caoscraper.web.model.CaoDataDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CaoScrapingServiceTest {

    @Autowired
    CaoScrapingService caoScrapingService;

    @Test
    void scrapeCaoByObjectIdSucces() {
        CaoDataDto dto = caoScrapingService.scrapeCaoByObjectId("14271");
        assertEquals("611", dto.getSbi());
        System.out.println(dto);
    }

    @Test
    void scrapeCaoByObjectIdFail() {
        CaoDataDto dto = caoScrapingService.scrapeCaoByObjectId("1");
        assertNull(dto);
    }
}