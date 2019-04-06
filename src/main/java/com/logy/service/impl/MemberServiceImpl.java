package com.logy.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.logy.dto.MemberordersublineDto;
import com.logy.form.FamilyForm;
import com.logy.form.SublineForm;
import com.logy.mapper.CarsouleImgMapper;
import com.logy.mapper.FamilyMapper;
import com.logy.mapper.MemberMapper;
import com.logy.form.MemberForm;
import com.logy.mapper.SublineMapper;
import com.logy.mode.Member;
import com.logy.mode.Subline;
import com.logy.service.inter.DailyActivityService;
import com.logy.service.inter.MemberService;
import com.logy.utils.DataResponse;
import com.logy.utils.DateUtils;
import com.logy.utils.UploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class MemberServiceImpl implements MemberService {
    private Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
    //Autowired  自动装配;
    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private SublineMapper sublineMapper;

    @Autowired
    private FamilyMapper familyMapper;

    @Autowired
    private DailyActivityService dailyActivityService;

    /**
     * 查询所有成员
     * @param memberForm
     * @return
     */
    @Override
    public DataResponse queryAllMember(MemberForm memberForm) {
        DataResponse<List<Member>> dataResponse = new DataResponse<>();
        List<Member> memberList = memberMapper.queryAllMember(memberForm);//查询所有成员
        if(memberList.size() == 0) {
            dataResponse.setCode(404);
            dataResponse.setMessage("fail");
        } else {
            int memberCount = memberMapper.countMember(memberForm);//统计成员数量
            dataResponse.setData(memberList);//向返回对象中设置查询到的所有成员
            dataResponse.setPageCount(memberCount);//向返回对象中设置条数
        }
        return dataResponse;//返回响应数据
    }

    /**
     * 查询家族成员
     * @param memberForm
     * @return
     */
    @Override
    public DataResponse queryMyMembers(MemberForm memberForm) {
        DataResponse<List<Member>> dataResponse = new DataResponse<>();
        List<Member> memberList = memberMapper.queryMyMembers(memberForm);
        dataResponse.setData(memberList);
        return dataResponse;
    }

    /**
     * 通过支系查询成员
     * @param memberForm
     * @return
     */
    @Override
    public DataResponse queryMembersOrderBySubline(MemberForm memberForm) {
        DataResponse<List<MemberordersublineDto>> dataResponse = new DataResponse<>();
        SublineForm sublineForm = new SublineForm();
        sublineForm.setSubFamilyID(memberForm.getMemberFamilyID());
        List<MemberordersublineDto> memberordersublineDtos = new ArrayList<>();
        List<Member> memberList = memberMapper.queryMyMembers(memberForm);
        if(memberList.size() > 0) {
            for (Member m : memberList) {
                if(memberordersublineDtos.size() == 0) {
                    MemberordersublineDto dto = new MemberordersublineDto();
                    dto.setSublineName(m.getMemberGenealogy());
                    dto.getMembers().add(m);
                    memberordersublineDtos.add(dto);
                } else {
                    MemberordersublineDto dto = new MemberordersublineDto();
                    for(MemberordersublineDto d : memberordersublineDtos) {
                        if(d.getSublineName().equals(m.getMemberGenealogy())) {
                            d.getMembers().add(m);
                        } else {
                            dto.setSublineName(m.getMemberGenealogy());
                            dto.getMembers().add(m);
                            memberordersublineDtos.add(dto);
                            break;
                        }
                    }
                    // if(dto.getSublineName() != "") {
                    //     memberordersublineDtos.add(dto);
                    // }
                }
            }
        }
        if(memberordersublineDtos.size() == 0) {
            dataResponse.setMessage("fail");
            dataResponse.setCode(404);
        }
        dataResponse.setData(memberordersublineDtos);
        return dataResponse;
    }

    /**
     * 通过手机号码或者地址查询
     * @param memberForm
     * @return
     */
    @Override
    public DataResponse queryMemberByPhoneAndPass(MemberForm memberForm) {
        DataResponse<Member> dataResponse = new DataResponse<>();
        Member member = memberMapper.queryMemberByPhoneAndPass(memberForm);
        if(member != null) {
            dataResponse.setData(member);
            dailyActivityService.insertDailyActivity();
        } else {
            dataResponse.setCode(404);
            dataResponse.setMessage("fail");
        }
        return dataResponse;
    }

    /**
     * 向数据库中插入成员
     * @param member
     * @return
     */
    @Transactional
    @Override
    public DataResponse insertMember(Member member) {
        DataResponse<Member> dataResponse = new DataResponse<>();
        int result = 0;
        if(member.getMemberID() != null) {
            result = memberMapper.updateMember(member);
        } else {
            FamilyForm familyForm = new FamilyForm();
            // 查询父ID
            MemberForm mf = new MemberForm();
            mf.setMemberIDNumber(member.getFatherIDNumber());
            Member m2 = memberMapper.queryAllMember(mf).get(0);
            //*************/
            familyForm.setFamilyID(Integer.valueOf(member.getMemberFamilyID()));
            member.setMemberCreateDate(DateUtils.getLocalDateNow().toString());
            member.setMemberCode(UUID.randomUUID().toString().replace("-", ""));
            member.setFatherID(m2.getMemberID());
            familyMapper.updateFamilyNum(familyForm);
            result = memberMapper.insertMember(member);
        }

        if(result <= 0) {
            dataResponse.setMessage("fail");
            dataResponse.setCode(500);
        }
        dataResponse.setData(member);
        return dataResponse;
    }

    /**
     * 删除成员
     * @param mes
     * @return
     */
    @Transactional
    @Override
    public DataResponse delMemberBatch(String mes) {
        DataResponse<Member> dataResponse = new DataResponse<>();
        List<Member> familyList = JSONArray.parseArray(mes, Member.class);
        int result = memberMapper.delMemberBatch(familyList);
        if(result <= 0) {
            dataResponse.setCode(500);
            dataResponse.setMessage("fail");
        }
        return dataResponse;
    }

    /**
     * 修改成员密码
     * @param memberForm
     * @return
     */
    @Override
    public DataResponse ChangeMemberPwd(MemberForm memberForm) {
        DataResponse<Member> dataResponse = new DataResponse<>();
        Member member = memberMapper.queryMemberByPhoneAndPass(memberForm);
        if(member != null) {
            dataResponse.setData(member);
            dataResponse.setMessage("密码修改成功");
            Member m = new Member();
            m.setMemberID(memberForm.getMemberID());
            m.setMemberPass(memberForm.getNewPass());
            memberMapper.updateMember(m);
        } else {
            dataResponse.setCode(404);
            dataResponse.setMessage("旧密码错误");
        }
        return dataResponse;
    }

}
