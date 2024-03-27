package me.dio.santanderdevweek2024.application;

import me.dio.santanderdevweek2024.domain.exception.ChampionNotFoundException;
import me.dio.santanderdevweek2024.domain.model.Champions;
import me.dio.santanderdevweek2024.domain.model.ports.ChampionsRepository;


public record AskChampionsUseCase(ChampionsRepository repository) {

    public String askChampion(Long championId,String question) {

        Champions champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String championContext = champion.generateContextByQuestion(question);

        // TODO: Evoluir a lógica de negócio para considerar a integração com IAs Generativas.

        return championContext ;
    }
}
