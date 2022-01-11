package co.com.sofka.mentoring35.Router;

import co.com.sofka.mentoring35.Repository.RandomRepository;
import co.com.sofka.mentoring35.UseCase.RandomDeleteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RandomDeleteRouter {

    @Bean
    public RouterFunction<ServerResponse> delete(RandomDeleteUseCase randomDeleteUseCase) {
        return route(
                DELETE("/Delete/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.TEXT_PLAIN)
                        .body(BodyInserters.fromPublisher(randomDeleteUseCase.apply(request.pathVariable("id")), String.class))
        );
    }
}
