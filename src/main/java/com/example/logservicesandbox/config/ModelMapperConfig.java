package com.example.logservicesandbox.config;

import com.example.logservicesandbox.domain.Log;
import com.example.logservicesandbox.domain.LogDTO;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.addConverter(logDTOToLog, LogDTO.class, Log.class);
        return modelMapper;
    }

    private Converter<LogDTO, Log> logDTOToLog = new Converter<LogDTO, Log>() {
        @Override
        public Log convert(MappingContext<LogDTO, Log> mappingContext) {
            var logDTO = mappingContext.getSource();
            Log log = new Log();
            log.setMessage(logDTO.getMessage());
            log.setUser(logDTO.getUser());
            return log;
        }
    };

}
