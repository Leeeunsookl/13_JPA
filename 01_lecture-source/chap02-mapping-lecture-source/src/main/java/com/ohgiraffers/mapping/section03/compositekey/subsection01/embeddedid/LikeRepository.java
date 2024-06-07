package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository //영속성 컨텐츠와 접할 수 있는
public class LikeRepository {

    @PersistenceContext
    private EntityManager manager;

    public void save(Like like) {

        manager.persist(like);

    }
}
