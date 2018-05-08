package com.example.gradledemo.Controller;

import com.example.gradledemo.Bean.Widget;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/widget")
@RestController
public class WidgetController {

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
    public Widget index() {
        System.out.println("---------------------------test");
        return new Widget("green", 10, 7);
    }
}
