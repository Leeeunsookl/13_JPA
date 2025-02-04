package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class LikedCompositeKey {

    @Embedded
    private LikedMemberNo memberNo;

    @Embedded
    private LikedBookNo bookNo;

    public LikedCompositeKey() {

    }
    public LikedCompositeKey(LikedMemberNo memberNo, LikedBookNo bookNo){
        this.memberNo = memberNo;
        this.bookNo = bookNo;
    }




}
