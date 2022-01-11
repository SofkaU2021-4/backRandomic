package co.com.sofka.mentoring35.UseCase;

import co.com.sofka.mentoring35.Controller.Random;
import co.com.sofka.mentoring35.Repository.RandomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class RandomGetAllUseCase implements Supplier<Flux<Random>> {

    private RandomRepository randomRepository;

    @Autowired
    public RandomGetAllUseCase(RandomRepository randomRepository) {
        this.randomRepository = randomRepository;
    }


    @Override
    public Flux<Random> get() {
        return randomRepository.findAll();
    }
}
