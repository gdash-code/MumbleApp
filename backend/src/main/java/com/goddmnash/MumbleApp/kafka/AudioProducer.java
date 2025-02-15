package com.goddmnash.MumbleApp.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * The AudioProducer class is a Kafka producer responsible for sending audio transcription
 * messages to the "audio-transcription" topic.
 *
 * This class is marked as a Spring Service and leverages the {@link KafkaTemplate} to
 * interact with a Kafka cluster. It can be used to publish messages or events
 * related to audio data processing.
 *
 * Key Features:
 * - Sends messages to the "audio-transcription" Kafka topic.
 * - Designed to integrate with consumers, such as {@link AudioConsumer}, for
 *   seamless audio data processing workflows.
 */
@Service
public class AudioProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public AudioProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send("audio-transcription", message);
    }
}

