package com.logy.service.inter;

import com.logy.form.MemberForm;
import com.logy.mode.Member;
import com.logy.utils.DataResponse;
import org.springframework.web.multipart.MultipartFile;

public interface MemberService {
    DataResponse queryAllMember(MemberForm memberForm);
    DataResponse queryMyMembers(MemberForm memberForm);
    DataResponse queryMembersOrderBySubline(MemberForm memberForm);
    DataResponse queryMemberRelation(MemberForm memberForm);
    DataResponse queryMemberByPhoneAndPass(MemberForm memberForm);
    DataResponse insertMember(Member member);
    DataResponse delMemberBatch(String mes);
    DataResponse ChangeMemberPwd(MemberForm memberForm);
}
