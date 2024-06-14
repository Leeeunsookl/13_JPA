package com.ohgiraffers.springdatajpa.menu.model.dao;

import com.ohgiraffers.springdatajpa.menu.entity.Category;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query(value="SELECT category_code, category_name, ref_category_code FROM tbL_category ORDER BY category_code"
            , nativeQuery=true)
    //JPQL은 SELECT m FROM categoryEntity m ORDER BY m.categoryCode 로 작성하면 됨
    List<Category> findAllCategory();

}


