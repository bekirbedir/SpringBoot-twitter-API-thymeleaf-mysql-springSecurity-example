package com.example.gradledemo.Controller;

import com.example.gradledemo.Domain.FormCommand;
import com.example.gradledemo.Domain.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class thymeleaftest {

    @GetMapping("/thy")
    public String getfollowers(Model model) {
        System.out.println("thymeleaf controller running");

        FormCommand frm = new FormCommand();
        frm.setMultiCheckboxSelectedValues(new String[]{"a", "b", "c"});

        model.addAttribute("multiCheckboxAllValues", getMultiCheckboxAllValues());
        //     model.addAttribute("multiCheckboxAllValues" , new String[]{"pazartesi" , "salı" , "carsamba" , "persembe"});
        model.addAttribute("singleSelectAllValues", new String[]{"evet", "hayır", "belki"});
        model.addAttribute("dropdownSelectedValue", new String[]{"var", "yok", "bazen"});

        model.addAttribute("formCommand", new FormCommand());
        return "thymeleaf";
    }

    public String[] getMultiCheckboxAllValues() {
        return new String[]{
                "Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday", "Saturday", "Sunday"
        };
    }



    @PostMapping("/thy")
    public String foobarPost(@ModelAttribute("formCommand") FormCommand command, Model model ) {
        System.out.println("form command post running");
        System.out.println(command.getColorField());

        model.addAttribute("formCommand", command);
        return "thymeleaf";
    }
}
