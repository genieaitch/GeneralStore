package edu.store.kh.GeneralStore.controller;


import edu.store.kh.GeneralStore.dto.Pizza;
import edu.store.kh.GeneralStore.service.PizzaService;
import edu.store.kh.GeneralStore.service.PizzaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/api")
@RestController
public class PizzaApiController {
    // ServiceImpl -> Autowired 호출
    @Autowired
    private PizzaServiceImpl pizzaService;

    @GetMapping("/pizzas") //   /api/pizzas
    public List<Pizza> selectAll() {
        return pizzaService.selectAll();
    }

    @GetMapping("/pizzas/{id}")
    public Pizza selectById(@PathVariable int id) {
        return pizzaService.selectById(id);
    }

    @PostMapping("/pizzas") //   /api/pizzas
    public void createPizza() {

    }

    // @RequestBody @RequestParam
    @PutMapping("pizzas/{id}")
    public void updatePizza(@PathVariable int id,
                            @RequestParam("name") String name,
                            @RequestParam("price") int price,
                            @RequestParam("description") String description,
                            @RequestParam(value = "imagePath", required = false) MultipartFile imagePath) {
                            // required = false     @RequestParam 요청으로 프론트엔드에서 값을 가져올 때 null 값이어도 가능
                            // required 를 작성하지 않은 @RequestParam의 기본 값은 required = true 이다.
                            // DB에서 not null 일 경우 required를 true로 줌     null일 경우 required = false 작성해줌
        /*
        Controller는 주로 Backend <-> Frontend 중간 다리 역할
        똑같은 URL API 주소에서는 GET POST PUT DELETE 최초 1회씩만 사용 가능
        Controller에서는 Frontend 가져온 데이터 @service 로 전달
                  DB에서 Backend 가져온 데이터 @service 로 전달
         */
        pizzaService.updatePizza(id, name, price, description, imagePath);
    }

    @DeleteMapping("/pizzas/{id}")
    public void deletePizza(@PathVariable int id) {
        pizzaService.deletePizza(id);
    }
}