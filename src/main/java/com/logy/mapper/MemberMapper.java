package com.logy.mapper;

import com.logy.form.MemberForm;
import com.logy.mode.Member;

import java.util.List;

public interface MemberMapper {
    List<Member> queryAllMember(MemberForm memberForm);
    List<Member> queryMyMembers(MemberForm memberForm);
    List<Member> queryMember(MemberForm memberForm);
    Member queryMemberByPhoneAndPass(MemberForm memberForm);
    Integer countMember(MemberForm memberForm);
    Integer insertMember(Member member);
    Integer updateMember(Member member);
    Integer delMemberBatch(List<Member> mes);
}
