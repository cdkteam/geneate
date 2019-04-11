package com.logy.mode;

import java.util.List;

public class MemberRelation {

    private String name;
    private String image_url;
    private MemberRelation mate;
    private List<MemberRelation> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public MemberRelation getMate() {
        return mate;
    }

    public void setMate(MemberRelation mate) {
        this.mate = mate;
    }

    public List<MemberRelation> getChildren() {
        return children;
    }

    public void setChildren(List<MemberRelation> children) {
        this.children = children;
    }


}
