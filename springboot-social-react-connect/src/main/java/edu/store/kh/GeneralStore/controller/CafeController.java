package edu.store.kh.GeneralStore.controller;

import edu.store.kh.GeneralStore.dto.Cafe;
import edu.store.kh.GeneralStore.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cafes")
public class CafeController {

    @Autowired
    private CafeService cafeService;

    // 모든 카페 조회
    @GetMapping
    public List<Cafe> getAllCafes() {
        return cafeService.getAllCafes();
    }

    // 특정 카페 조회
    @GetMapping("/{id}")
    public Cafe getCafeById(@PathVariable int id) {
        return cafeService.getCafeById(id);
    }

    // 새로운 카페 추가
    @PostMapping
    public void addCafe(@RequestBody Cafe cafe) {
        cafeService.addCafe(cafe);
    }
}