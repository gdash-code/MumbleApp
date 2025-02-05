package com.goddmnash.MumbleApp.services;

import com.goddmnash.MumbleApp.models.AudioTranscription;
import com.goddmnash.MumbleApp.repositories.AudioTranscriptionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AudioTranscriptionService {

    private final AudioTranscriptionRepository repository;

    public AudioTranscriptionService(AudioTranscriptionRepository repository) {
        this.repository = repository;
    }

    public List<AudioTranscription> getTranscriptionsByUser(UUID userId) {
        return repository.findByUserId(userId);
    }

    public AudioTranscription saveTranscription(AudioTranscription transcription) {
        return repository.save(transcription);
    }
}

