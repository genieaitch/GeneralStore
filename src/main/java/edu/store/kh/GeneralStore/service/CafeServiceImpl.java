package edu.store.kh.GeneralStore.service;

import edu.store.kh.GeneralStore.dto.Cafe;
import edu.store.kh.GeneralStore.mapper.CafeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CafeServiceImpl implements CafeService {

    @Autowired
    private CafeMapper cafeMapper;

    @Override
    public List<Cafe> getAllCafes() {
        return cafeMapper.selectAllCafes();
    }

    @Override
    public Cafe getCafeById(int id) {
        return cafeMapper.selectCafeById(id);
    }

    @Override
    public void addCafe(Cafe cafe) {
        cafeMapper.insertCafe(cafe);
    }
}
