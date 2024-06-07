package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeBookService {


    private LikeRepository likeRepository;
    @Autowired
    public LikeBookService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Transactional  //등록하는 것이기 때문에
    public void generateLikeBook(LikeDTO likeDTO) {

        Like like = new Like(
                new LikedCompositeKey(
                        new LikedMemberNo(likeDTO.getLikedMemberNo()),
                        new LikedBookNo(likeDTO.getLikedBookNo())
                )
        );      //like>compositekey>LikedMemberNo,LikedBookNo 이 구성이라고 생각하고 보면 이해가 쉽다

        likeRepository.save(like);
    }
}
