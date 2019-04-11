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

/**
 * 家庭成员控制类
 */
@RestController
@RequestMapping("member")
public class MemberController {
    /**
     * 声明家庭成员服务类对象
     */
    @Autowired
    private MemberService memberService;

    /**
     * 通过用户手机号和密码查询成员
     * @param memberForm
     * @return
     */
    @RequestMapping("me_l")
    public DataResponse queryMemberByPhoneAndPass(MemberForm memberForm) {
        return memberService.queryMemberByPhoneAndPass(memberForm);
    }

    @RequestMapping("me_query")
    public DataResponse queryMember(MemberForm memberForm) {
        return memberService.queryMember(memberForm);
    }

    /**
     * 查询所有的成员
     * @param memberForm
     * @return
     */
    @RequestMapping("me_list")
    public DataResponse queryAllMember(MemberForm memberForm) {
        return memberService.queryAllMember(memberForm);
    }

    /**
     * 查询家族成员
     * @param memberForm
     * @return
     */
    @RequestMapping("me_my_list")
    public DataResponse queryMyMembers(MemberForm memberForm) {
        return memberService.queryMyMembers(memberForm);
    }

    /**
     * 查询支系成员
     * @param memberForm
     * @return
     */
    @RequestMapping("me_my_order_sub")
    public DataResponse queryMembersOrderBySubline(MemberForm memberForm) {
        return memberService.queryMembersOrderBySubline(memberForm);
    }

    /**
     * 查询关系图谱
     * @param memberForm
     * @return
     */
    @RequestMapping("query_member_relation")
    public DataResponse queryMemberRelation(MemberForm memberForm) {
        return memberService.queryMemberRelation(memberForm);
    }

    /**
     * 向数据库中插入家庭成员
     * @param member
     * @return
     */
    @RequestMapping("me_i")
    public DataResponse insertMember(Member member) {
        return memberService.insertMember(member);
    }

    /**
     * 从数据库中删除家庭成员
     * @param mes
     * @return
     */
    @RequestMapping("me_d_list")
    public DataResponse delMemberBatch(String mes) {
        return memberService.delMemberBatch(mes);
    }

    /**
     * 更改数据库中的家庭成员的信息
     * @param memberForm
     * @return
     */
    @RequestMapping("me_u_pwd")
    public DataResponse ChangeMemberPwd(MemberForm memberForm) {
        return memberService.ChangeMemberPwd(memberForm);
    }
}
