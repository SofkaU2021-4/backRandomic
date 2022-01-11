package co.com.sofka.mentoring35.Router;

import co.com.sofka.mentoring35.Controller.Random;
import co.com.sofka.mentoring35.UseCase.RandomCreateUseCase;
import co.com.sofka.mentoring35.UseCase.RandomGetAllUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RandomGetAllRouter {

    @Bean
    public RouterFunction<ServerResponse> getAllRandom(RandomGetAllUseCase randomGetAllUseCase){
        return route(
                GET("/BackFuncional").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(randomGetAllUseCase.get(), Random.class))
                        .onErrorResume((error)->ServerResponse.badRequest().build())
        );
    }
}
