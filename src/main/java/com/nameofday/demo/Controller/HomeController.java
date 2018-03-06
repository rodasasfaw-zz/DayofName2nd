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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@Controller
public class HomeController {
    @Autowired
    DateofBirthRepository dateofBirthRepository;
    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

   @GetMapping("/adddate")
    public String adddate(Model model){
        model.addAttribute("dob", new DateofBirth());

return "dayform";


   }
   @PostMapping("/adddate")
    public String showName(@Valid @ModelAttribute("dob") DateofBirth dateofBirth, Model model, BindingResult result){
       if (result.hasErrors()) {
           return "dayform";
       }


       Calendar cal = Calendar.getInstance();
       cal.setTime(dateofBirth.getDate());
       int val=cal.get(Calendar.DAY_OF_WEEK);

   String myday=new DateFormatSymbols().getWeekdays()[val];

          if(myday.equalsIgnoreCase("Monday")) {
              if (dateofBirth.getSex().equalsIgnoreCase("male"))
                  dateofBirth.setName("Kojo");
              else
                  dateofBirth.setName("Akojo");

              System.out.println(dateofBirth.getName());
          }
          else
              dateofBirth.setName("babute");

          dateofBirthRepository.save(dateofBirth);

              System.out.println("your day is different");
       model.addAttribute("date",dateofBirthRepository.findAll());
        return "confirmationpage";
   }



}