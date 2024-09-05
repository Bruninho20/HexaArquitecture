package br.com.fiap.products.cliente.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.products.cliente.domain.model.UserProduct;

@Service
public class KafkaConsumer {

	private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topics = "pedidos", groupId = "group-1")
	private void consume(String message) {
		logger.info("Mensagem recebida do Kafka: {}", message);

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			UserProduct userProduct = objectMapper.readValue(message, UserProduct.class);
		} catch (JsonProcessingException e) {
			logger.error("Erro ao deserializar a mensagem", e);
		}
	}

}
