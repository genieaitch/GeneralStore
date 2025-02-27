package kh.edu.react.provider.service;

import kh.edu.react.provider.dto.Clothes;

import java.util.List;

public interface ClothesService {
    List<Clothes> getAllClothes();
    Clothes getClothesById(int cId);
    void insertClothes(Clothes clothes);
    void updateClothes(Clothes clothes);
    void deleteClothes(int cId);
}