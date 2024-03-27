package me.dio.santanderdevweek2024.domain.model;

public record Champions(
        Long id,
        String name,
        String role,
        String lore,
        String imageUrl
) {
    public String generateContextByQuestion(String question) {
        return """
        Pergunta: %s
        Nome do Agente: %s
        Função: %s
        Lore (História): %s
        """.formatted(question,this.name,this.role,this.lore);
    }
}
