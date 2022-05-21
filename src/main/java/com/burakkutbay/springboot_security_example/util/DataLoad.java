package com.burakkutbay.springboot_security_example.util;

import com.burakkutbay.springboot_security_example.model.Role;
import com.burakkutbay.springboot_security_example.model.User;
import com.burakkutbay.springboot_security_example.repository.RoleRepository;
import com.burakkutbay.springboot_security_example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoad implements ApplicationRunner {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Admin save

        Role roleAdmin=Role.builder().id(1L).role_name("ROLE_ADMIN").build();
        Role roleUser=Role.builder().id(2L).role_name("ROLE_USER").build();

        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);


        List<Role> adminRoleList=new ArrayList<>();
        adminRoleList.add(roleAdmin);

        User admin=User.builder().id(3L).name("Burak").password("1234").roles(adminRoleList).build();
        userRepository.save(admin);

        //User save

        List<Role> userRoleList=new ArrayList<>();
        userRoleList.add(roleUser);

        User user=User.builder().id(4L).name("Ali").password("1234").roles(userRoleList).build();
        userRepository.save(user);

        System.out.println("-- Roles --");
        roleRepository.findAll().forEach(System.out::println);
        System.out.println("-- User --");
        userRepository.findAll().forEach(System.out::println);

    }
}
