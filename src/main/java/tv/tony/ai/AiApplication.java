package tv.tony.ai;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import tv.tony.ai.models.ImageResponse;
import tv.tony.ai.request.ImageRequest;


@SpringBootApplication
public class AiApplication implements CommandLineRunner {
    WebClient webClient = WebClient.builder()
            .baseUrl("https://api.openai.com/v1/")
            .build();

    public static void main(String[] args) {
        SpringApplication.run(AiApplication.class, args);
    }

    @Override
    public void run(String... args) {
        ImageRequest imageRequest = new ImageRequest();
        imageRequest.setModel("dall-e-3");
        imageRequest.setPrompt("Average Spanish person");
        imageRequest.setN(1);
        imageRequest.setSize("1024x1024");
        final var response = webClient.post()
                .uri("images/generations")
                .headers(httpHeaders -> httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer OpenAI Key"))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(imageRequest))
                .retrieve()
                .bodyToMono(ImageResponse.class)
                .doOnNext(imageResponse ->System.out.println(" response is " + imageResponse) )
                .subscribe();


    }
}
