package me.dio.santanderdevweek2024.adapters.in;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.santanderdevweek2024.application.AskChampionsUseCase;
import org.springframework.web.bind.annotation.*;

@Tag(name="Agentes",description = "Endpoints do domínio de Agentes do Valorant")
@RestController
@RequestMapping("/champions")
public record AskChampionRestController(AskChampionsUseCase useCase) {

    @CrossOrigin
    @PostMapping("/{championId}/ask")
    public AskChampionResponse askChampion(@PathVariable Long championId, @RequestBody AskChampionRequest request) {
        String answer =  useCase.askChampion(championId,request.question());
        return new AskChampionResponse(answer);
    }

    public record AskChampionRequest(String question) { }
    public record AskChampionResponse(String answer) { }
}
