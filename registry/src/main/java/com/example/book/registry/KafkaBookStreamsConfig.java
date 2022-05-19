package com.example.book.registry;

import static org.apache.kafka.streams.StreamsConfig.APPLICATION_ID_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG;
import static org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME;

import java.util.Map;

import org.apache.kafka.common.serialization.Serdes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

@Configuration
@EnableKafka
@EnableKafkaStreams
public class KafkaBookStreamsConfig {

  @Value(value = "${spring.kafka.bootstrap-servers}")
  private String bootstrapAddress;

  @Bean(name = DEFAULT_STREAMS_CONFIG_BEAN_NAME)
  KafkaStreamsConfiguration getKafkaStreamsConfiguration() {
    return new KafkaStreamsConfiguration(
      Map.of(
        APPLICATION_ID_CONFIG, "book-registry",
        BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress,
        DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName(),
        DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName()));
  }

}
