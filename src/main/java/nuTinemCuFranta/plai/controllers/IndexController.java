package nuTinemCuFranta.plai.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class IndexController {

    public String getIndexPage(){
        return "/index";
    }

}
