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
 * @param sublineName 字辈名称
 *        members 包含改字辈的家庭成员
 * @return
 */
@Setter
@Getter
public class MemberordersublineDto {
    private String sublineName;
    private List<Member> members = new ArrayList<>();
}
