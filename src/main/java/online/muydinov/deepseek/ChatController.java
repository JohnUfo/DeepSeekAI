package online.muydinov.deepseek;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ChatController {

    private final OllamaChatModel chatModel;
    private final ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChatController(OllamaChatModel chatModel, ChatMessageRepository chatMessageRepository) {
        this.chatModel = chatModel;
        this.chatMessageRepository = chatMessageRepository;
    }

    @GetMapping("/")
    public String chatPage(Model model) {
        List<ChatMessage> chatHistory = chatMessageRepository.findAll();
        model.addAttribute("chatHistory", chatHistory);
        return "redirect:/chat.html";
    }

    @PostMapping("/ai/generate")
    @ResponseBody
    public ChatMessage generate(@RequestParam String message) {
        String response = chatModel.call(message);
        ChatMessage userMessage = new ChatMessage(null, "User", message, LocalDateTime.now());
        ChatMessage aiMessage = new ChatMessage(null, "AI", response, LocalDateTime.now());

        chatMessageRepository.save(userMessage);
        chatMessageRepository.save(aiMessage);

        return aiMessage;
    }
}
