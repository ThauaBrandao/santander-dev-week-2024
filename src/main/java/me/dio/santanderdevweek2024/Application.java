package me.dio.santanderdevweek2024;

import me.dio.santanderdevweek2024.application.AskChampionsUseCase;
import me.dio.santanderdevweek2024.application.ListChampionsUseCase;
import me.dio.santanderdevweek2024.domain.model.ports.ChampionsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) { SpringApplication.run(Application.class, args);}

	@Bean
	public ListChampionsUseCase provideListChampionsUseCase(ChampionsRepository repository){
		return new ListChampionsUseCase(repository);
	}
	@Bean
	public AskChampionsUseCase provideAskChampionUseCase(ChampionsRepository repository){
		return new AskChampionsUseCase(repository);
	}
}
