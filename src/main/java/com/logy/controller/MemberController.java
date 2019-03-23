package com.logy.controller;

import com.logy.form.MemberForm;
import com.logy.mode.Member;
import com.logy.mode.User;
import com.logy.service.inter.DailyActivityService;
import com.logy.service.inter.MemberService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("member")
public class MemberController {
    @Autowired
    private MemberService memberService;


    @RequestMapping("me_l")
    public DataResponse queryMemberByPhoneAndPass(MemberForm memberForm) {
        return memberService.queryMemberByPhoneAndPass(memberForm);
    }

    @RequestMapping("me_list")
    public DataResponse queryAllMember(MemberForm memberForm) {
        return memberService.queryAllMember(memberForm);
    }

    @RequestMapping("me_my_list")
    public DataResponse queryMyMembers(MemberForm memberForm) {
        return memberService.queryMyMembers(memberForm);
    }

    @RequestMapping("me_my_order_sub")
    public DataResponse queryMembersOrderBySubline(MemberForm memberForm) {
        return memberService.queryMembersOrderBySubline(memberForm);
    }

    @RequestMapping("me_i")
    public DataResponse insertMember(Member member) {
        return memberService.insertMember(member);
    }

    @RequestMapping("me_d_list")
    public DataResponse delMemberBatch(String mes) {
        return memberService.delMemberBatch(mes);
    }

    @RequestMapping("me_u_pwd")
    public DataResponse ChangeMemberPwd(MemberForm memberForm) {
        return memberService.ChangeMemberPwd(memberForm);
    }
}
