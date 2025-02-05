package com.goddmnash.MumbleApp.controllers;

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

    public AudioTranscriptionController(AudioTranscriptionService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<AudioTranscription>> getUserTranscriptions(@PathVariable UUID userId) {
        return ResponseEntity.ok(service.getTranscriptionsByUser(userId));
    }

    @PostMapping
    public ResponseEntity<AudioTranscription> saveTranscription(@RequestBody AudioTranscription transcription) {
        return ResponseEntity.ok(service.saveTranscription(transcription));
    }
}


