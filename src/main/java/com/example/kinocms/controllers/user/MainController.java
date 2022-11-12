package com.example.kinocms.controllers.user;

import com.example.kinocms.enums.Gender;
import com.example.kinocms.models.User;
import com.example.kinocms.repositorys.UserRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class MainController {

    private final UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String greeting(Model model) {

//        test = new String[] {"city1", "city2", "city3", "city4"};
//
//        model.addAttribute("options", test);

        return "user/main";
    }

    @PostMapping("/registration")
    public String registration(
                @RequestParam String name,
                @RequestParam String surname,
                @RequestParam String nickname,
                @RequestParam String email,
                @RequestParam String phone,
                @RequestParam String password,
                @RequestParam Gender gender,
                @RequestParam @DateTimeFormat(pattern="yyyy-mm-dd") Date birthday,
                @RequestParam String city,
                @RequestParam String address,
                @RequestParam String card,
                Model model) {

        userRepository.save(User

                .builder()

                .name(name)
                .surname(surname)
                .nickname(nickname)
                .email(email)
                .phone(phone)
                .password(password)
                .gender(gender)
                .birthday(birthday)
                .city(city)
                .address(address)
                .card(card)
                .active(true)

                .build());

        return "redirect:/";
    }

}
