package site.crafsed.sarafan.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import site.crafsed.sarafan.domain.User;
import site.crafsed.sarafan.repo.MessageRepo;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {

    @Value("${spring.profiles.active}")
    private String profile;

    private final MessageRepo messageRepo;

    @Autowired
    public MainController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user){
        HashMap<Object, Object> data = new HashMap<>();

        if (user!=null) {
            data.put("profile", user);
            data.put("messages", messageRepo.findAll());
        }

        model.addAttribute("frontendData", data);
        model.addAttribute("isDevMode","dev".equals(profile));
        return "index";
    }

}
