package kh.edu.react.provider.controller;

import kh.edu.react.provider.dto.Clothes;
import kh.edu.react.provider.service.ClothesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    @Autowired
    private ClothesServiceImpl clothesService;

    @GetMapping
    public List<Clothes> getAllClothes() {
        return clothesService.getAllClothes();
    }

    @GetMapping("/{id}")
    public Clothes getClothesById(@PathVariable int id) {
        return clothesService.getClothesById(id);
    }

    @PostMapping
    public void insertClothes(@RequestBody Clothes clothes) {
        clothesService.insertClothes(clothes);
    }

    @PutMapping("/{id}")
    public void updateClothes(@RequestBody Clothes clothes) {
        clothesService.updateClothes(clothes);
    }

    @DeleteMapping("/{id}")
    public void deleteClothes(@PathVariable int id) {
        clothesService.deleteClothes(id);
    }
}