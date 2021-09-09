package com.example.logservicesandbox.services;

import com.example.logservicesandbox.domain.Log;
import com.example.logservicesandbox.domain.LogDTO;
import com.example.logservicesandbox.repository.LogRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.example.logservicesandbox.util.convertors.KafkaMessageConverter;

import java.time.LocalDateTime;

@Service
@Log4j2
public class LogServiceConsumer {

    @Autowired
    LogRepository logRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    KafkaMessageConverter kafkaMessageConverter;

    @KafkaListener(topics = "logs", groupId = "log_group_id")
    public void consume(String logMessage) {
        LogDTO logDTO= (LogDTO) kafkaMessageConverter.deserialize(logMessage, LogDTO.class);
        Log logData = modelMapper.map(logDTO, Log.class);
        logData.setTime(LocalDateTime.now());
        logRepository.save(logData);
        log.info("new log: {}", logData);
    }
}