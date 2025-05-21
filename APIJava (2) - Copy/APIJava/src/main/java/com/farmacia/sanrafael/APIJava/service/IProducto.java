package com.farmacia.sanrafael.APIJava.service;
import com.farmacia.sanrafael.APIJava.entities.ProductoEntity;
import com.farmacia.sanrafael.APIJava.payload.MessageResponse;
import com.farmacia.sanrafael.APIJava.dto.ProductoDTO;
import java.util.List;
public interface IProducto {

    MessageResponse findAll();
    MessageResponse delete(Long id);
    MessageResponse save(ProductoDTO producto);
    MessageResponse update(Long id, ProductoDTO producto);
}
