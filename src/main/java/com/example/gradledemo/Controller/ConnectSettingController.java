package com.example.gradledemo.Controller;

import com.example.gradledemo.Bean.Widget;
import com.example.gradledemo.Domain.Connect;
import com.example.gradledemo.Repository.ConnectRepository;
import com.example.gradledemo.Service.ConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@Secured("ROLE_ANONYMOUS")
@Controller
public class ConnectSettingController {

    @Autowired
    ConnectService connectService;

    @GetMapping("/connect")
    public String connectForm(Model model) {
        System.out.println("aaaaaaaaa");
        model.addAttribute("connect", new Connect());
        return "connect";
    }


    @PostMapping("/connect")
    public String connectSubmit(@ModelAttribute Connect connect){
        connectService.addConnect(connect);
        return "result";
    }

}
