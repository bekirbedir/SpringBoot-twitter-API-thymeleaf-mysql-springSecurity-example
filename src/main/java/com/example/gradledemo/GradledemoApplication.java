package com.example.gradledemo;

import com.example.gradledemo.Domain.TwitterProfile;
import com.example.gradledemo.Repository.TwitterProfileRepository;
import com.example.gradledemo.Service.TwitterProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class GradledemoApplication implements CommandLineRunner {



    public static void main(String[] args) {
        SpringApplication.run(GradledemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
 //       TwitterProfile twitterProfile = getProfile();
   //     twitterProfileService.addUser(twitterProfile);
    }

    public TwitterProfile getProfile() {
/*
		TwitterProfile profile = new TwitterProfile();
		profile.setUsername("bekir");
		profile.setFollowers(450);

		return profile;
*/
        return null;
    }
}