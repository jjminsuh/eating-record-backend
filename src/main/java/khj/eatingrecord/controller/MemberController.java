package khj.eatingrecord.controller;

import khj.eatingrecord.dto.LoginResponseDto;
import khj.eatingrecord.dto.MemberDto;
import khj.eatingrecord.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/login")
    @ResponseBody
    public LoginResponseDto login(@RequestBody MemberDto memberDto) {
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        if (memberService.isExist(memberDto)) {
            loginResponseDto.setIsExist(true);
        } else {
            loginResponseDto.setIsExist(false);
        }
        return loginResponseDto;
    }
}
