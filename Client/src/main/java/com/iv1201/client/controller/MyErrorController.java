
package com.iv1201.Client.controller;

import static com.iv1201.client.controller.LoginController.isAuthenticated;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * If an user tries to go to a nonexistent page, they will be redirected to the
 * front page with an error
 * @author Zarcez
 */
@RestController
public class MyErrorController implements ErrorController{

        @RequestMapping("/error")
        public String getErrorPath() {
            if (isAuthenticated())
                return "redirect:/startpage?error";
            return "redirect:/login?error";
    }
}

