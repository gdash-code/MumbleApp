//package com.goddmnash.MumbleApp.kafka;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AudioConsumer {
////    private final TranscriptionRepository transcriptionRepository;
//
////    public KafkaConsumerService(TranscriptionRepository transcriptionRepository) {
////        this.transcriptionRepository = transcriptionRepository;
////    }
//
//    @KafkaListener(topics = "audio-transcription", groupId = "audio-processing")
//    public void consume(ConsumerRecord<String, String> record) {
//        System.out.println("Saved transcription: " + record.value());
//    }
//}
//
