package com.farmacia.sanrafael.APIJava.service.impl;
import com.farmacia.sanrafael.APIJava.payload.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.farmacia.sanrafael.APIJava.entities.ProductoEntity;
import com.farmacia.sanrafael.APIJava.repository.ProductoRepository;
import com.farmacia.sanrafael.APIJava.service.IProducto;
import com.farmacia.sanrafael.APIJava.dto.ProductoDTO;
import com.farmacia.sanrafael.APIJava.utils.ProductoMapper;
import java.util.List;
@Service
public class ProductoImpl implements IProducto {
    @Autowired
    private ProductoRepository productoRepository;

@Override
public MessageResponse findAll() {
    List<ProductoDTO> productos = productoRepository.findAll()
            .stream()
            .map(ProductoMapper::toDTO)
            .toList();

    return MessageResponse.builder()
            .message("Productos encontrados")
            .data(productos)
            .status(HttpStatus.OK)
            .build();
}
    @Override
    public MessageResponse save(ProductoDTO dto) {
        ProductoEntity entity = ProductoMapper.toEntity(dto);
        ProductoEntity saved = productoRepository.save(entity);
        return MessageResponse.builder()
                .message("Producto guardado correctamente")
                .data(ProductoMapper.toDTO(saved))
                .status(HttpStatus.CREATED)
                .build();
    }
    @Override
    public MessageResponse update(Long id, ProductoDTO dto) {
        ProductoEntity existente = productoRepository.findById(id).orElse(null);
        if (existente == null) {
            return MessageResponse.builder()
                    .message("Producto no encontrado")
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        existente.setNombre(dto.getNombre());
        existente.setDescripcion(dto.getDescripcion());
        existente.setPrecio(dto.getPrecio());
        existente.setStock(dto.getStock());
        existente.setFecha_vencimiento(dto.getFechaVencimiento());

        productoRepository.save(existente);

        return MessageResponse.builder()
                .message("Producto actualizado correctamente")
                .data(ProductoMapper.toDTO(existente))
                .status(HttpStatus.OK)
                .build();
    }
@Override
public MessageResponse delete(Long id) {
    ProductoEntity existente = productoRepository.findById(id).orElse(null);

    if (existente == null) {
        return MessageResponse.builder()
                .message("Producto no encontrado")
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    try {
        productoRepository.deleteById(id);
    } catch (DataIntegrityViolationException e) {
        return MessageResponse.builder()
                .message("No se puede eliminar el producto porque está relacionado con ventas existentes.")
                .status(HttpStatus.CONFLICT)
                .build();
    } catch (Exception e) {
        return MessageResponse.builder()
                .message("Error al intentar eliminar el producto: " + e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }

    return MessageResponse.builder()
            .message("Producto eliminado correctamente")
            .status(HttpStatus.OK)
            .build();
}
}
