package com.nameofday.demo.Controller;



import com.nameofday.demo.Models.DateofBirth;
import com.nameofday.demo.Models.Sign;
import com.nameofday.demo.Models.UserService;
import com.nameofday.demo.Repository.DateofBirthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.text.DateFormatSymbols;
import java.util.Calendar;
@Controller
public class HomeController {
    @Autowired
    DateofBirthRepository dateofBirthRepository;
    @Autowired
    UserService userService;


    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("dob", dateofBirthRepository.findAll());

        return "index";
    }
    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

   @GetMapping("/adddate")
    public String adddate(Model model){
        model.addAttribute("dob", new DateofBirth());

return "dayform";


   }
   @PostMapping("/showdate")
    public String showName(@Valid @ModelAttribute("dob") DateofBirth dobs, BindingResult result, Model model){
       if (result.hasErrors()) {
           return "dayform";
       }


       model.addAttribute("dob",userService.getdayName(dobs));

        return "display";
   }

    @GetMapping("/showdetail")
    public @ResponseBody String showIndex( @RequestParam( "zodiac")String zodiac){

        RestTemplate restTemplate = new RestTemplate();
       Sign sign = restTemplate.getForObject("http://horoscope-api.herokuapp.com/horoscope/today/"+zodiac,Sign.class);
        return  sign.getHoroscope();
    }


}
