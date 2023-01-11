package khj.eatingrecord.controller;

import khj.eatingrecord.domain.Member;
import khj.eatingrecord.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public boolean login( @RequestBody Member member) {
        if (loginService.isExist(member)) {
            return true;
        } else {
            loginService.join(member);
            return false;
        }
    }
}
