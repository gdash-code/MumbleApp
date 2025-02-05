package com.goddmnash.MumbleApp.repositories;

import com.goddmnash.MumbleApp.models.AudioTranscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AudioTranscriptionRepository extends JpaRepository<AudioTranscription, Long> {
    List<AudioTranscription> findByUserId(UUID userId);
}

