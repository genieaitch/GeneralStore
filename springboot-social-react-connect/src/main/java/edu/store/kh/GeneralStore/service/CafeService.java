package edu.store.kh.GeneralStore.service;

import edu.store.kh.GeneralStore.dto.Cafe;

import java.util.List;

public interface CafeService {
    List<Cafe> getAllCafes();
    Cafe getCafeById(int id);
    void addCafe(Cafe cafe);
}