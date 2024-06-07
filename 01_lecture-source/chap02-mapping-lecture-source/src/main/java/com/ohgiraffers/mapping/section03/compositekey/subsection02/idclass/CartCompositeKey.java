package com.ohgiraffers.mapping.section03.compositekey.subsection02.idclass;


// 복합키 설정 카트오너, 에디드북 둘다 pk 설정할 것임
public class CartCompositeKey {

    private int cartOwner;

    private int addedBook;

    protected CartCompositeKey(){}

    public CartCompositeKey(int cartOwner, int addedBook){
        this.cartOwner=cartOwner;
        this.addedBook=addedBook;
    }

}
