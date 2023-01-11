package khj.eatingrecord.controller;

import khj.eatingrecord.dto.MemberDto;
import khj.eatingrecord.entity.Member;
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
    public boolean login(@RequestBody MemberDto memberDto) {
        if (loginService.isExist(memberDto)) {
            return true;
        } else {
            loginService.join(memberDto);
            return false;
        }
    }
}
