package co.com.sofka.mentoring35.UseCase;

import co.com.sofka.mentoring35.Controller.Random;
import co.com.sofka.mentoring35.Dto.RequestDTO;
import co.com.sofka.mentoring35.Repository.RandomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Validated
public class RandomCreateUseCase implements Function<RequestDTO, Mono<Random>> {
    private RandomRepository randomRepository;

    @Autowired
    public RandomCreateUseCase(RandomRepository randomRepository) {
        this.randomRepository = randomRepository;
    }

    @Override
    public Mono<Random> apply(RequestDTO requestDTO) {
        return Mono.just(new Random()).map(entity -> {
            entity.setDate(new Date());
            entity.setOrginalList(requestDTO.getList());
            return entity;
        }).map(entity -> {
            var list = Stream.of(requestDTO.getList().split(","))
                    .map(p -> p.trim())
                    .collect(Collectors.toList());
            Collections.shuffle(list);
            var randomList = list.stream().collect(Collectors.joining(","));
            entity.setRandomList(randomList);
            return entity;
        }).flatMap(randomRepository::save);
    }
}




