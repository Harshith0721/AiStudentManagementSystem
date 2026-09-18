package org.stdumng.aistudentmanagementsystem;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiLayer {
    private final StudentService studentService;
    private final ChatClient chatClient;

    public AiLayer(ChatClient chatClient, StudentService studentService) {
        this.chatClient = chatClient;
        this.studentService = studentService;
    }

    public String operate(String prompt){
        return chatClient.prompt()
                .user(prompt)
                .tools(studentService)
                .call()
                .content();
    }
}
