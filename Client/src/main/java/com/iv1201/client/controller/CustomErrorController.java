
package com.iv1201.Client.controller;

import static com.iv1201.client.controller.LoginController.isAuthenticated;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * If an user tries to go to a nonexistent page, they will be redirected to the
 * front page with an error
 * @author Zarcez
 */
@RestController
@AutoConfigureAfter(CustomErrorController.class)
public class CustomErrorController implements ErrorController  {

    public CustomErrorController(){
        System.out.println("Created CustomErrorController");
    }
        @RequestMapping("/error")
        public String handleError() {
            if (isAuthenticated())
                return "redirect:/startpage?error";
            return "redirect:/login?error";
    }
}

