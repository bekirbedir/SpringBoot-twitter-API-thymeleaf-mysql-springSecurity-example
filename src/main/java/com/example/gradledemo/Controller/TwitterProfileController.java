package com.example.gradledemo.Controller;

import com.example.gradledemo.Domain.TwitterProfile;
import com.example.gradledemo.Service.FollowersService;
import com.example.gradledemo.Service.TwitterProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("/analyze")
@Controller
public class TwitterProfileController {

    @Autowired
    TwitterProfileService twitterProfileService;


    @Autowired
    FollowersService followersService;



        @GetMapping("/getfollowers")
    public String getfollowers(Model model) {
        System.out.println("aaaaaaaaa");

        List<TwitterProfile> users = twitterProfileService.getFollowers("iyidusunuyorum");

        for(TwitterProfile profile : users){
            System.out.println(profile.getFollowing());
        };
        model.addAttribute("users", users );
        return "followers";
    }


    @GetMapping("/getfollowerIds")
    public String getfollowerIds(Model model) {
        System.out.println("getfollowerIds started.");
        List<Long> followerIds = followersService.getfollowerIds("iyidusunuyorum");
        model.addAttribute("count", followerIds.size() );
        return "success";
    }

    @GetMapping("/getfollowingIds")
    public String getfollowingIds(Model model) {
        System.out.println("getfollowingIds started.");
        List<Long> followingIds = followersService.getfollowingIds("iyidusunuyorum");
      //  model.addAttribute("count", followingIds.size() );
        return "success";
    }

    @GetMapping("/getnotfollowingIds")
    public String getnotfollowingIds(Model model) {
        System.out.println("getnotfollowingIds started.");
          List<Long> notfollowingIds = followersService.getnotfollowingIds("iyidusunuyorum");
         model.addAttribute("count", notfollowingIds.size() );
        return "success";
    }

}
