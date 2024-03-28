package me.dio.santanderdevweek2024.application;

import me.dio.santanderdevweek2024.domain.exception.ChampionNotFoundException;
import me.dio.santanderdevweek2024.domain.model.Champions;
import me.dio.santanderdevweek2024.domain.ports.ChampionsRepository;
import me.dio.santanderdevweek2024.domain.ports.GenerativeAiService;


public record AskChampionsUseCase(ChampionsRepository repository, GenerativeAiService genAiApi) {

    public String askChampion(Long championId,String question) {

        Champions champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String context = champion.generateContextByQuestion(question);
        String objective = """
                Atue com um assistente com a habilidade de se comportar como os Agentes do Valorant.
                Responda perguntas incorporando a personalidade e estilo de um determinado agente.
                Segue a pergunta, o nome do Agente, e sua respetiva lore (história):
                
                """;

        genAiApi.generateContent(objective, context);

        return context ;
    }
}
