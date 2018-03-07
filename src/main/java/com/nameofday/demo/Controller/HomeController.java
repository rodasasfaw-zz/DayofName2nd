package com.nameofday.demo.Controller;



import com.nameofday.demo.Models.DateofBirth;
import com.nameofday.demo.Repository.DateofBirthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.text.DateFormatSymbols;
import java.util.Calendar;


@Controller
public class HomeController {
    @Autowired
    DateofBirthRepository dateofBirthRepository;
    int val;
    String myday;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("dob", dateofBirthRepository.findAll());

        return "index";
    }
    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

   @GetMapping("/showdate")
    public String adddate(Model model){
        model.addAttribute("dob", new DateofBirth());

return "dayform";


   }
   @PostMapping("/adddate")
    public String showName(@Valid @ModelAttribute("dob") DateofBirth dobs, BindingResult result, Model model){
       if (result.hasErrors()) {
           return "dayform";
       }


       Calendar cal = Calendar.getInstance();
       cal.setTime(dobs.getDate());
        val=cal.get(Calendar.DAY_OF_WEEK);

    myday=new DateFormatSymbols().getWeekdays()[val];

          if(myday.equalsIgnoreCase("Monday")) {
              if (dobs.getSex().equalsIgnoreCase("male"))
                  dobs.setName("Kojo");
              else
                  dobs.setName("Akojo");

              System.out.println(dobs.getName());
          }
          else
              dobs.setName("babute");

          dateofBirthRepository.save(dobs);

              System.out.println("your day is different");
       model.addAttribute("dob",dateofBirthRepository.findAll());
        return "display";
   }



}