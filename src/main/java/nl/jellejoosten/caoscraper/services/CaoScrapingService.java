package nl.jellejoosten.caoscraper.services;

import nl.jellejoosten.caoscraper.web.model.CaoDataDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CaoScrapingService {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final String ID_ONGELDIG = "Geen Rechten";
    private final String URL = "https://www.uitvoeringarbeidsvoorwaardenwetgeving.nl/mozard/!suite92.scherm1007?mObj=";

    public CaoDataDto scrapeCaoByObjectId(String objectId) {

        String objectUrl = URL + objectId;
        //System.out.println(objectUrl);
        CaoDataDto dto = new CaoDataDto();

        try {
            // retrieving the desired web page
            SSL.trustAllHttpsCertificates();
            HttpsURLConnection.setDefaultHostnameVerifier(SSL.hv);
            Document webPage = Jsoup.connect(objectUrl).get();

            // check if object id is valid
            String header = webPage.getElementsByTag("h1").first().text();

            if (ID_ONGELDIG.equals(header)) {
                return null;
            }
            else {

                dto.setObjectId(objectId);

                // get table with cao data
                Element tbody = webPage
                        .getElementById("tabel1");

                // get data rows
                assert tbody != null;
                Elements rows = tbody.children();
                //System.out.println("Number of rows: " + rows.size());

                for (Element row : rows) {
                    //System.out.println("row: " + row);

                    String key = null;
                    String value = null;

                    try {
                        key = row
                                .getElementsByClass("col-md-12")
                                .first()
                                .getElementsByClass("prompttekst")
                                .first().text();
                        value = row
                                .getElementsByClass("col-md-12")
                                .first()
                                .getElementsByClass("aandachttekst")
                                .first()
                                .getElementsByClass("aandachttekst__tekst")
                                .first()
                                .getElementsByTag("span")
                                .first()
                                .text();
                        //System.out.println("Key: " + key);
                        //System.out.println("Value: " + value);
                    } catch (NullPointerException e) {
                        System.out.println("element not found");
                    }

                    //System.out.println("Key 1: " + key);
                    //System.out.println("Value 1: " + value);
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }
}
