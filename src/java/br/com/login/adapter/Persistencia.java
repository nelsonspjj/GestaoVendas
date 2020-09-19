package br.com.login.adapter;

import java.util.List;

public interface Persistencia {
    
    void salvar(Object object);
    
    Object findById(Long id);
    
    void update(Object object);
    
    void deleteById(Long id);
    
    List<Object> findAll();
}
