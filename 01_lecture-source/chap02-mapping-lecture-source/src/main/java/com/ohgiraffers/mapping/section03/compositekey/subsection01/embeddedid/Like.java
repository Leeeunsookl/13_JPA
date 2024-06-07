package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/* 예약어 항상 조심 그냥 like는 이미 있기 때문에..  */
@Entity
@Table(name="tbl_like")
public class Like {

    /* 우리가 세트로 묶어 둔 memberNo, bookNo를 ID(pk)로서 사용 */
    @EmbeddedId
    private LikedCompositeKey likeInfo;

    protected Like(){}

    public Like(LikedCompositeKey likeInfo) {
        this.likeInfo = likeInfo;
    }
}
