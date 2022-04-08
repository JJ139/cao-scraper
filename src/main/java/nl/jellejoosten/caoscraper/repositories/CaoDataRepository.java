package nl.jellejoosten.caoscraper.repositories;

import nl.jellejoosten.caoscraper.domain.CaoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaoDataRepository extends JpaRepository<CaoData, Long> {
}
