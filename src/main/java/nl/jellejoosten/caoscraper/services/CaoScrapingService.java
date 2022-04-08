package nl.jellejoosten.caoscraper.services;

import nl.jellejoosten.caoscraper.web.model.CaoDataDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CaoScrapingService {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final String URL = "https://www.uitvoeringarbeidsvoorwaardenwetgeving.nl/mozard/!suite92.scherm1007?mObj=";

    public CaoDataDto scrapeCaoByObjectId(String objectId) {

        String objectUrl = URL + objectId;
        System.out.println(objectUrl);
        CaoDataDto dto = new CaoDataDto();
        dto.setObjectId(objectId);

        try {
            // retrieving the desired web page
            Document webPage = Jsoup.connect(objectUrl).get();

            // get web page
            Element tbody = webPage.getElementById("tabel1");

            // get data rows
            assert tbody != null;
            Elements rows = tbody.children();

            for (Element row : rows) {

                String key = null;
                String value = null;

                try {
                    key = row.getElementsByClass("prompttekst").first().val();
                    value = row.
                            getElementsByClass("aandachttekst")
                            .first()
                            .getElementsByClass("aandachttekst__tekst")
                            .first()
                            .getElementsByTag("span")
                            .first()
                            .val();
                } catch (NullPointerException e) {
                    System.out.println("element not found");
                }

                if (key != null && value != null) {
                    switch (key) {
                        case "Naam":
                            dto.setNaam(value);
                            break;
                        case "Registratie":
                            dto.setRegistratie(value);
                            break;
                        case "CAO":
                            dto.setCao(value);
                            break;
                        case "Ingangsdatum":
                            dto.setIngangsdatum(LocalDate.parse(value, formatter));
                            break;
                        case "Expiratiedatum":
                            dto.setExpiratiedatum(LocalDate.parse(value, formatter));
                            break;
                        case "Soort cao":
                            dto.setSoort(value);
                            break;
                        case "Type cao":
                            dto.setType(value);
                            break;
                        case "SBI-code":
                            dto.setSbi(value);
                            break;
                        case "Datum formele Kennisgeving van Ontvangst":
                            dto.setKvoDatum(LocalDate.parse(value, formatter));
                            break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dto;
    }
}
