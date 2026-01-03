package com.wjdqudwls.springdatajpa.menu.controller;

import com.wjdqudwls.springdatajpa.menu.dto.MenuDTO;
import com.wjdqudwls.springdatajpa.menu.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu") // /menu 시작하는 요청하는 매핑
public class MenuController {

  private final MenuService menuService;

  public MenuController(MenuService menuService) {
    this.menuService = menuService;
  }

  @GetMapping("/{menuCode}")
  public String findMenuByCode(
      @PathVariable("menuCode") int menuCode, Model model) {

        MenuDTO menu = menuService.findMenuByCode(menuCode);
        model.addAttribute("menu", menu);

        return "menu/detail";
  }


}
