package khj.eatingrecord.controller;

import khj.eatingrecord.dto.LoginResponseDto;
import khj.eatingrecord.dto.MemberDto;
import khj.eatingrecord.entity.Member;
import khj.eatingrecord.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    @ResponseBody
    public LoginResponseDto login(@RequestBody MemberDto memberDto) {
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        if (loginService.isExist(memberDto)) {
            loginResponseDto.setIsExist(true);
        } else {
            loginResponseDto.setIsExist(false);
        }
        return loginResponseDto;
    }
}
