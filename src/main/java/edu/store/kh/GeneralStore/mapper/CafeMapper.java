package edu.store.kh.GeneralStore.mapper;

import edu.store.kh.GeneralStore.dto.Cafe;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CafeMapper {
    List<Cafe> selectAllCafes();
    Cafe selectCafeById(int id);
    void insertCafe(Cafe cafe);
}