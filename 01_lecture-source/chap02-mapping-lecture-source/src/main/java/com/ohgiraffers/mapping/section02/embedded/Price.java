package com.ohgiraffers.mapping.section02.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/* 필기. embedded 가 될 수 있는 타입을 지정할 때 사용한다. */
@Embeddable
public class Price {

    @Column(name = "reqular_price")
    private int regularPrice;

    @Column(name = "discount_rate")
    private double discountRate;

    @Column(name = "sell_price")
    private int sellPrice;

    protected Price() {}



}
