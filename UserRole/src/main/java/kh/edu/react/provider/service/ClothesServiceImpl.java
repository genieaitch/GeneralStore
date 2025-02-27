package kh.edu.react.provider.service;

import kh.edu.react.provider.dto.Clothes;
import kh.edu.react.provider.mapper.ClothesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothesServiceImpl implements ClothesService {

    private final ClothesMapper clothesMapper;

    @Override
    public List<Clothes> getAllClothes() {
        return clothesMapper.getAllClothes();
    }

    @Override
    public Clothes getClothesById(int cId) {
        return clothesMapper.getClothesById(cId);
    }

    @Override
    public void insertClothes(Clothes clothes) {
        clothesMapper.insertClothes(clothes);
    }

    @Override
    public void updateClothes(Clothes clothes) {
        clothesMapper.updateClothes(clothes);
    }

    @Override
    public void deleteClothes(int cId) {
        clothesMapper.deleteClothes(cId);
    }
}