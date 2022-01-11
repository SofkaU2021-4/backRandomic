package co.com.sofka.mentoring35.UseCase;

import co.com.sofka.mentoring35.Repository.RandomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class RandomDeleteUseCase implements Function<String, Mono<String>> {

    private RandomRepository randomRepository;

    @Autowired
    public RandomDeleteUseCase(RandomRepository randomRepository) {
        this.randomRepository = randomRepository;
    }

    @Override
    public Mono<String> apply(String id) {
        Objects.requireNonNull(id, "Id Random requerida");
        return randomRepository.deleteById(id).thenReturn("Borrado")
               .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND , "id erroneo")));
    }
}
