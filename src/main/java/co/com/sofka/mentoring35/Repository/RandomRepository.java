package co.com.sofka.mentoring35.Repository;

import co.com.sofka.mentoring35.Controller.Random;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RandomRepository extends ReactiveCrudRepository<Random, String> {
    
}
