package com.farmacia.sanrafael.APIJava.service;
import com.farmacia.sanrafael.APIJava.entities.ProductoEntity;
import com.farmacia.sanrafael.APIJava.payload.MessageResponse;

import java.util.List;
public interface IProducto {
    //List<ProductoEntity> findAll();
    MessageResponse findAll();
   // ProductoEntity save(ProductoEntity producto);
    MessageResponse save(ProductoEntity producto);
    MessageResponse update(Long id, ProductoEntity producto);
    MessageResponse delete(Long id);
}
