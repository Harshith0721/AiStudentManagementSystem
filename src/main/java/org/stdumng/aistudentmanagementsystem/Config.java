package org.stdumng.aistudentmanagementsystem;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ChatClient c(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.build();
    }
}
