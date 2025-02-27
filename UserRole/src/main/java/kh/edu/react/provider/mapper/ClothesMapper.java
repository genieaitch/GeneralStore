package kh.edu.react.provider.mapper;
import kh.edu.react.provider.dto.Clothes;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ClothesMapper {
    List<Clothes> getAllClothes();
    Clothes getClothesById(int cId);
    void insertClothes(Clothes clothes);
    void updateClothes(Clothes clothes);
    void deleteClothes(int cId);
}