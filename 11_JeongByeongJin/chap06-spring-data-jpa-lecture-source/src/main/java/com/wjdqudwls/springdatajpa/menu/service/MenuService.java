package com.wjdqudwls.springdatajpa.menu.service;

import com.wjdqudwls.springdatajpa.menu.dto.MenuDTO;
import com.wjdqudwls.springdatajpa.menu.entity.Menu;
import com.wjdqudwls.springdatajpa.menu.repository.MenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

  private final MenuRepository menuRepository;
  private final ModelMapper modelMapper;

  // 생성자 방식의 의존성 주입
  public MenuService(MenuRepository menuRepository, ModelMapper modelMapper) {
    this.menuRepository = menuRepository;
    this.modelMapper = modelMapper;
  }

  /**
   * menuCode가 일치하는 메뉴를 DB에서 조회 후 반환
   * @param menuCode
   * @return 조회된 MenuDTO, 없으면 예외 발생
   * @throws IllegalArgumentException 조회 결과 없으면 예외 발생
   */
  public MenuDTO findMenuByCode(int menuCode) {

    Menu menu = menuRepository.findById(menuCode)
        .orElseThrow(IllegalArgumentException::new);

    /* Menu Entity -> Menu DTO로 변환(ModelMapper 이용)*/
    return modelMapper.map(menu, MenuDTO.class);
  }
}

