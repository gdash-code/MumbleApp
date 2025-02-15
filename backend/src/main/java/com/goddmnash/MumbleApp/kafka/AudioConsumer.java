package com.goddmnash.MumbleApp.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * The AudioConsumer class acts as a Kafka consumer for handling messages from the "audio-transcription" topic.
 * It listens for new messages, processes them, and outputs the transcription.
 * Intended for extending functionality to process and store the transcriptions in a database.
 *
 * This class is marked as a Spring Service and uses the @KafkaListener annotation
 * to subscribe to Kafka topics and handle incoming messages.
 */
@Service
public class AudioConsumer {

    @KafkaListener(topics = "audio-transcription", groupId = "audio-processing")
    public void consume(ConsumerRecord<String, String> record) {
        System.out.println("Received Transcription: " + record.value());

//        TODO: PROCESS AND STORE THE TRANSCRIPTION IN POSTGRESQL
    }
}

