package me.dio.santanderdevweek2024.domain.ports;

public interface GenerativeAiService {

    String generateContent(String objective, String context);
}
