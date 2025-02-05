package com.goddmnash.MumbleApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "audio_transcriptions")
public class AudioTranscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false, columnDefinition = "UUID DEFAULT gen_random_uuid()")
    private UUID userId;

    @Column(nullable = false)
    private String audioFilename;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String transcription;

    @Column(columnDefinition = "TEXT")
    private String generatedLyrics;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

}


