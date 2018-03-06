package com.nameofday.demo.Repository;

import com.nameofday.demo.Models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository  extends CrudRepository<Role, Long> {
    Role findByRoleName(String roleName);
    //AppUser findByapAndAppusers(AppUser appUser);
}
