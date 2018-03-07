package com.nameofday.demo.Models;

import com.nameofday.demo.Repository.DateofBirthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormatSymbols;
import java.util.Calendar;

@Service
public class UserService {

    @Autowired
    DateofBirthRepository dateofBirthRepository;



//    public UserService(DateofBirthRepository dateofBirthRepository) {
//        this.dateofBirthRepository=dateofBirthRepository;
//    }

    public DateofBirth getdayName(DateofBirth dobs) {
        int val;
        String myday;



        Calendar cal = Calendar.getInstance();
        cal.setTime(dobs.getDate());
        val=cal.get(Calendar.DAY_OF_WEEK);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int month=cal.get(Calendar.MONTH);

        myday=new DateFormatSymbols().getWeekdays()[val];

        if(myday.equalsIgnoreCase("monday")){
            if(dobs.getSex().equalsIgnoreCase("male"))

                dobs.setName("Kojo");

            else
                dobs.setName("Adjoa");

        }
        if(myday.equalsIgnoreCase("tuesday")){
            if(dobs.getSex().equalsIgnoreCase("male"))

                dobs.setName("Kwabena");

            else
                dobs.setName(" Abena ");




        }
        if(myday.equalsIgnoreCase("wednesday")) {
            if(dobs.getSex().equalsIgnoreCase("male"))

                dobs.setName(" Kweku");

            else
                dobs.setName(" Akua");



        }

        if(myday.equalsIgnoreCase("thursday")) {
            if(dobs.getSex().equalsIgnoreCase("male"))

                dobs.setName("Yaw");

            else
                dobs.setName("Yaa");




        }
        if(myday.equalsIgnoreCase("friday")) {
            if(dobs.getSex().equalsIgnoreCase("male"))

                dobs.setName("Kofi");

            else
                dobs.setName("Afua");



        }
        if(myday.equalsIgnoreCase("saturday")) {
            if(dobs.getSex().equalsIgnoreCase("male"))

                dobs.setName("Kwame");

            else
                dobs.setName("Ama");



        }
        if(myday.equalsIgnoreCase("sunday")) {
            if(dobs.getSex().equalsIgnoreCase("male"))

                dobs.setName("Kwesi");

            else
                dobs.setName("Akosua");



        }

        if((month == 11) && ( day>= 22) || (month == 0) && (day <= 19)) {
            dobs.setZodiac("Capricorn");
        }else if((month == 0) && (day >= 20)  || (month == 1) && (day <= 18)) {
            dobs.setZodiac("Aquarius");
        } else if((month == 1) && (day >= 19)  || (month == 2) && (day <= 20)) {
            dobs.setZodiac("Pisces");
        } else if((month == 2) && (day >= 21)  || (month == 3) && (day <= 19)) {
            dobs.setZodiac("Aries");
        } else if((month == 3) && (day >= 20)  || (month == 4) && (day <= 20)) {
            dobs.setZodiac("Taurus");
        } else if((month == 4) && (day >= 21)  || (month == 5) && (day <= 20)) {
            dobs.setZodiac("Gemini");
        } else if((month == 5) && (day >= 21)  || (month == 6) && (day <= 22)) {
            dobs.setZodiac("Cancer");
        } else if((month == 6) && (day >= 23)  || (month == 7) && (day <= 22)) {
            dobs.setZodiac("Leo");
        } else if((month == 7) && (day >= 23)  || (month == 8) && (day <= 21)) {
            dobs.setZodiac("Virgo");
        } else if((month == 8) && (day >= 22) || (month == 9) && (day <= 21)) {
            dobs.setZodiac("Libra");
        } else if((month == 9) && (day >= 24)  || (month == 10) && (day <= 22)) {
            dobs.setZodiac("Scorpio");
        } else if((month == 10) && (day >= 23)  || (month == 11) && (day <= 21)) {
            dobs.setZodiac("Sagittarius");
        }


        dateofBirthRepository.save(dobs);
return  dobs;
    }

}
