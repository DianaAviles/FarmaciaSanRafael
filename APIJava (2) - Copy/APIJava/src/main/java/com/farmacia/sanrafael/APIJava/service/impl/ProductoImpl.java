package com.farmacia.sanrafael.APIJava.service.impl;
import com.farmacia.sanrafael.APIJava.payload.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.farmacia.sanrafael.APIJava.entities.ProductoEntity;
import com.farmacia.sanrafael.APIJava.repository.ProductoRepository;
import com.farmacia.sanrafael.APIJava.service.IProducto;
import java.util.List;
@Service
public class ProductoImpl implements IProducto {
    @Autowired
    private ProductoRepository productoRepository;

//    @Override
//    public List<ProductoEntity> findAll() {
//        return productoRepository.findAll();
//    }
    @Override
    public MessageResponse findAll() {
        List<ProductoEntity> productos = productoRepository.findAll();
        return MessageResponse.builder()
                .message("Productos encontrados")
                .data(productos)
                .status(HttpStatus.OK)
                .build();
    }
//    @Override
//    public ProductoEntity save(ProductoEntity producto) {
//        return productoRepository.save(producto);
//    }
    @Override
    public MessageResponse save(ProductoEntity producto){
        ProductoEntity productoGuardado = productoRepository.save(producto);
        return MessageResponse.builder()
                .message("Producto guardado correctamente")
                .data(productoGuardado)
                .status(HttpStatus.CREATED)
                .build();
    }
}
