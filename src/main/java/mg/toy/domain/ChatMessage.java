package mg.toy.domain;


import lombok.Data;

@Data
public class ChatMessage {
    private String from;
    private String text;
}