package com.ohgiraffers.springdatajpa.menu.controller;

import com.ohgiraffers.springdatajpa.common.Pagenation;
import com.ohgiraffers.springdatajpa.common.PagingButton;
import com.ohgiraffers.springdatajpa.menu.model.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.menu.model.dto.MenuDTO;
import com.ohgiraffers.springdatajpa.menu.model.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuService service;

    @Autowired
    public MenuController(MenuService service) {
        this.service = service;
    }

    @GetMapping("/{menuCode}") //메뉴코드 넣었던 거
    public String findMenuByMenuCode(@PathVariable int menuCode, Model model) {

       MenuDTO resultMenu = service.findMenuByMenuCode(menuCode);

       model.addAttribute("menu", resultMenu);

       return "menu/detail";
    }

    @GetMapping("/list")
    public String findMenuList(Model model, @PageableDefault Pageable pageable) {

        /* no paging 버젼 */
//        List<MenuDTO> menuList = service.findMenuList();
//
//        model.addAttribute("menuList", menuList);

        /* paging 버젼 */
        log.info("pageable : {}", pageable);


        Page<MenuDTO> menuList = service.findMenuList(pageable);

        log.info("조회한 내용 목록 : {}", menuList.getContent());
//        System.out.println("menuList = " + menuList); 와 같다.
        log.info("총 페이지 수 : {}", menuList.getTotalPages());
        log.info("총 메뉴의 수 : {}", menuList.getTotalElements());
        log.info("해당 페이지에 표시될 요소의 수 : {}",menuList.getSize());
        log.info("해당 페이지의 실제 요소 갯수 : {}", menuList.getNumberOfElements());
        log.info("첫 페이지 여부: {}", menuList.isFirst());
        log.info("마지막 페이지 여부: {}", menuList.isLast());
        log.info("정렬 방식 : {}", menuList.getSort());
        log.info("여러 페이지 중 현재 인덱스 : {}",menuList.getNumber());

        PagingButton paging = Pagenation.getPagingButtonInfo(menuList);

        model.addAttribute("menuList", menuList);
        model.addAttribute("paging", paging);

        return "menu/list";

    }

    @GetMapping("/querymethod")
    public void queryMethodPage(){}

    @GetMapping("/search")
    public String findByMenuPrice(@RequestParam int menuPrice, Model model) {

        List<MenuDTO> menuList = service.findByMenuPrice(menuPrice);

        model.addAttribute("menuList", menuList);
        model.addAttribute("menuPrice", menuPrice);

        return "menu/searchResult";
    }

    @GetMapping("/regist")
    public void registPage() {}

    @GetMapping(value = "/category", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CategoryDTO> findCategoryList(){
        return service.findAllCategory();
    }

    @PostMapping("/regist")
    public String registNewMenu(MenuDTO menuDTO) {

        service.registNewMenu(menuDTO);

        return "redirect:/menu/list";
    }
}
