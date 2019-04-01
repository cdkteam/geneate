package com.logy.dto;

import com.logy.mode.Member;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 *    字辈信息
 *
 * @author xky
 * @date 2019/3/18 10:06
 *        members 包含改字辈的家庭成员
 * @return
 */

public class MemberordersublineDto {
    private String sublineName;
    private List<Member> members = new ArrayList<>();

    public String getSublineName() {
        return sublineName;
    }

    public void setSublineName(String sublineName) {
        this.sublineName = sublineName;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
