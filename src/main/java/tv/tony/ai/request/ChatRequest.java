package tv.tony.ai.request;

import java.util.List;

public class ChatRequest {
    public List<Message> messages;
    public String model;

    public ChatRequest(List<Message> messages, String model){
        this.messages = messages;
        this.model = model;
    }
    
}
