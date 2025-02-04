package com.goddmnash.MumbleApp.repositories;

import com.goddmnash.MumbleApp.models.Transcription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptionRepository extends JpaRepository<Transcription, Long> {
}

