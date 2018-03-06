package com.nameofday.demo.Repository;

import com.nameofday.demo.Models.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    AppUser findAppUserById(long id);
    AppUser findAppUserByUsername(String name);
   // AppUser findFirstByItemsAndRolesIs(Item lostitem,Role role);
    AppUser findByRoles(AppUser appUsers);





}
