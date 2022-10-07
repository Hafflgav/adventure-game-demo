package com.adventuretime.game;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.EnableZeebeClient;
import io.camunda.zeebe.spring.client.annotation.ZeebeDeployment;
import io.camunda.zeebe.spring.client.annotation.ZeebeVariable;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
@EnableZeebeClient
@ZeebeDeployment(resources = "classpath:murder-mystery.bpmn")
public class GameApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameApplication.class, args);
	}

	@ZeebeWorker(type = "initialisePlayers", autoComplete = true)
	public Map<String,Object> initialisePlayers(final JobClient client, final ActivatedJob job, @ZeebeVariable String playerString, @ZeebeVariable Integer playerCount){
		List<String> players = new LinkedList<>();
		HashMap<String, Object> processVariables = new HashMap<>();

		players = Arrays.asList(playerString.split("\\s*,\\s*"));

		processVariables.put("players", players);
		return processVariables;
	}
}
