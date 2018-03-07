package com.nameofday.demo.security;



import com.nameofday.demo.Models.AppUser;
import com.nameofday.demo.Models.Role;
import com.nameofday.demo.Repository.AppUserRepository;
import com.nameofday.demo.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    RoleRepository roleRepository;


    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Loading data...");

        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

       Role adminRole = roleRepository.findByRoleName("ADMIN");
       Role userRole = roleRepository.findByRoleName("USER");


        AppUser user1 = new AppUser("rodas4@gmail.com","rod","password");
       user1.setRoles(Arrays.asList(userRole));
        appUserRepository.save(user1);

        AppUser user2 = new AppUser("sam@gmail.com", "sam","pass");
        user2.setRoles(Arrays.asList(userRole));
        appUserRepository.save(user2);














    }

}