package com.sda.store.commons;

import java.util.List;

public class OrderDto  {
    private UserDto userEntity;
    private List<ProductDto> productEntity;

    public OrderDto(UserDto userEntity, List<ProductDto> productEntity) {
        this.userEntity = userEntity;
        this.productEntity = productEntity;
    }

    public UserDto getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserDto userEntity) {
        this.userEntity = userEntity;
    }

    public List<ProductDto> getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(List<ProductDto> productEntity) {
        this.productEntity = productEntity;
    }
    public OrderDto(){}
}
