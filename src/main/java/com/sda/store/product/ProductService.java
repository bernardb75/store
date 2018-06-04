package com.sda.store.product;

import com.sda.store.commons.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    ModelMapper modelMapper;
    public List<ProductDto> findByNameFragment(String nameFragment){
        List<ProductEntity>allByNameIsLike=productRepository.findAllByNameContaining(nameFragment);
        return allByNameIsLike.stream().map(entity->modelMapper.map(entity,ProductDto.class)).collect(Collectors.toList());
    }
}
