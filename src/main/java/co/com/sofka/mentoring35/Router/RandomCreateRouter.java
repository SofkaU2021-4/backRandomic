package co.com.sofka.mentoring35.Router;

import co.com.sofka.mentoring35.Dto.RequestDTO;
import co.com.sofka.mentoring35.UseCase.RandomCreateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RandomCreateRouter {
    @Bean
    public RouterFunction<ServerResponse> postRandom(RandomCreateUseCase randomUseCase){

        return route(
                POST("/BackFuncional").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(RequestDTO.class)
                        .flatMap(RequestDTO -> randomUseCase.apply(RequestDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        ).onErrorResume(throwable -> ServerResponse.badRequest().build())
        );
    }
}
