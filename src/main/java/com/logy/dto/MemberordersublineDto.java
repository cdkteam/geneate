package com.logy.dto;

import com.logy.mode.Member;


import java.util.ArrayList;
import java.util.List;

/**
 *    字辈歌信息
 *
 * @author xky
 * @date 2019/3/18 10:06
 *        members 包含改字辈歌的家庭成员
 * @return
 */

public class MemberordersublineDto implements Comparable<MemberordersublineDto>{
    private String sublineName;
    private List<Member> members = new ArrayList<>();
    private int index;

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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int compareTo(MemberordersublineDto o) {
        return this.index - o.index;
    }
}
