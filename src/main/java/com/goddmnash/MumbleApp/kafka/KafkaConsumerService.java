package com.goddmnash.MumbleApp.kafka;

import com.goddmnash.MumbleApp.models.Transcription;
import com.goddmnash.MumbleApp.repositories.TranscriptionRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private final TranscriptionRepository transcriptionRepository;

    public KafkaConsumerService(TranscriptionRepository transcriptionRepository) {
        this.transcriptionRepository = transcriptionRepository;
    }

    @KafkaListener(topics = "audio-transcription", groupId = "audio-processing")
    public void consume(ConsumerRecord<String, String> record) {
        String transcribedText = record.value();
        Transcription transcription = new Transcription();
//        transcription.setOriginalAudio("unknown");
//        transcription.setTranscribedText("transcribedText");
        transcriptionRepository.save(transcription);
        System.out.println("Saved transcription: " + transcribedText);
    }
}

