package com.goddmnash.MumbleApp.controllers;

import com.goddmnash.MumbleApp.kafka.KafkaProducerService;
import com.goddmnash.MumbleApp.models.Transcription;
import com.goddmnash.MumbleApp.repositories.TranscriptionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/transcriptions")
public class TranscriptionController {
    private final KafkaProducerService kafkaProducer;
    private final TranscriptionRepository transcriptionRepository;
    private final RestTemplate restTemplate;

    public TranscriptionController(KafkaProducerService kafkaProducer, TranscriptionRepository transcriptionRepository) {
        this.kafkaProducer = kafkaProducer;
        this.transcriptionRepository = transcriptionRepository;
        this.restTemplate = new RestTemplate();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadAudio(@RequestParam("file") MultipartFile file) {
        String pythonServiceUrl = "http://localhost:5001/transcribe";

        // Send audio file to Python service
        String transcribedText = restTemplate.postForObject(pythonServiceUrl, file, String.class);

        // Send transcription to Kafka
        kafkaProducer.sendMessage(transcribedText);

        return ResponseEntity.ok("Transcription sent to Kafka: " + transcribedText);
    }

    @GetMapping
    public ResponseEntity<List<Transcription>> getAllTranscriptions() {
        return ResponseEntity.ok(transcriptionRepository.findAll());
    }
}

