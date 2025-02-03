package edu.store.kh.GeneralStore.service;

import edu.store.kh.GeneralStore.dto.Pizza;

import java.util.List;

public interface PizzaService {
    // 피자 메뉴 모두 조회
    public List<Pizza> selectAll();

    // 피자 상세 조회
    public Pizza selectById(int id);

    // 피자 메뉴 저장 - 자료형  void or int
    public int insertPizza(Pizza pizza);

    // 피자 메뉴 수정 - 자료형  void or int
    public int updatePizza(Pizza pizza);

    // 피자 메뉴 삭제 - 자료형  void or int
    public int deletePizza(int id);
}