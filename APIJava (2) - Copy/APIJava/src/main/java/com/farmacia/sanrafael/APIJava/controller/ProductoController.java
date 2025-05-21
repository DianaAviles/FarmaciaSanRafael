package com.farmacia.sanrafael.APIJava.controller;
import com.farmacia.sanrafael.APIJava.payload.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.farmacia.sanrafael.APIJava.entities.ProductoEntity;
import com.farmacia.    sanrafael.APIJava.service.IProducto;
import java.util.List;
import com.farmacia.sanrafael.APIJava.dto.ProductoDTO;

@RestController
@RequestMapping("/process")
public class ProductoController {
    @Autowired
    private IProducto iProducto;

    @Transactional(readOnly = true)
    @GetMapping("/productos")
    public MessageResponse getProductos() {
        return iProducto.findAll();
    }

@PostMapping("/producto")
public MessageResponse saveProducto(@RequestBody ProductoDTO producto) {
    return iProducto.save(producto);
}

    @PutMapping("/producto/{id}")
    public MessageResponse updateProducto(@PathVariable Long id, @RequestBody ProductoDTO producto) {
        return iProducto.update(id, producto);
    }


    @Transactional
    @DeleteMapping("/producto/{id}")
    public MessageResponse deleteProducto(@PathVariable Long id) {
        return iProducto.delete(id);
    }
}
