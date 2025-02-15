package com.goddmnash.MumbleApp.controllers;

import com.goddmnash.MumbleApp.kafka.AudioProducer;
import com.goddmnash.MumbleApp.models.AudioTranscription;
import com.goddmnash.MumbleApp.services.AudioTranscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transcriptions")
public class AudioTranscriptionController {

    private final AudioTranscriptionService service;
    private final AudioProducer producer;

    public AudioTranscriptionController(AudioTranscriptionService service, AudioProducer producer) {
        this.service = service;
        this.producer = producer;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<AudioTranscription>> getUserTranscriptions(@PathVariable UUID userId) {
        return ResponseEntity.ok(service.getTranscriptionsByUser(userId));
    }

    @PostMapping
    public ResponseEntity<String> saveTranscription(@RequestBody AudioTranscription transcription) {
        producer.sendMessage(transcription.getTranscription());
        return ResponseEntity.ok("Transcription sent to Kafka: " + transcription.getTranscription());
    }
}


