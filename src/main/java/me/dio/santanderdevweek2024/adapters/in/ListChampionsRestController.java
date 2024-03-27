package me.dio.santanderdevweek2024.adapters.in;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.santanderdevweek2024.application.ListChampionsUseCase;
import me.dio.santanderdevweek2024.domain.model.Champions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="Agentes",description = "Endpoints do domínio de Agentes do Valorant")
@RestController
@RequestMapping("/champions")
public record ListChampionsRestController(ListChampionsUseCase useCase) {

    @GetMapping
    public List<Champions> findAllChampions() {
        return useCase.findAll();
    }
}
