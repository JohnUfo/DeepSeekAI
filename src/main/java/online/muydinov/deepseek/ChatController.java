package online.muydinov.deepseek;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        // Retrieve all chat messages from the database
        List<ChatMessage> chatHistory = chatMessageRepository.findAll();
        model.addAttribute("chatHistory", chatHistory);
        return "redirect:/chat.html"; // Return the chat.html view
    }

    @PostMapping("/ai/generate")
    @ResponseBody
    public ChatMessage generate(@RequestParam String message) {
        // Call the AI model to generate a response
        String response = chatModel.call(message);

        // Save user message
        ChatMessage userMessage = new ChatMessage(null, "User", message, LocalDateTime.now());
        // Save AI message
        ChatMessage aiMessage = new ChatMessage(null, "AI", response, LocalDateTime.now());

        // Save both messages to the database
        chatMessageRepository.save(userMessage);
        chatMessageRepository.save(aiMessage);

        // Return the AI response message
        return aiMessage;
    }

    @GetMapping("/chat/history")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getChatHistory() {
        // Fetch chat history from the database
        List<ChatMessage> chatHistory = chatMessageRepository.findAll();

        // Prepare the response
        Map<String, Object> response = new HashMap<>();
        response.put("chatHistory", chatHistory);

        // Return the chat history as JSON
        return ResponseEntity.ok(response);
    }

}
