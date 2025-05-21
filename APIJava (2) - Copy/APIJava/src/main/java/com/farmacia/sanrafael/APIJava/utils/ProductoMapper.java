package com.farmacia.sanrafael.APIJava.utils;

import com.farmacia.sanrafael.APIJava.dto.ProductoDTO;
import com.farmacia.sanrafael.APIJava.entities.ProductoEntity;
public class ProductoMapper {
    public static ProductoDTO toDTO(ProductoEntity entity) {
        ProductoDTO dto = new ProductoDTO();
        dto.setIdProducto(entity.getIdProducto());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setPrecio(entity.getPrecio());
        dto.setStock(entity.getStock());
        dto.setFechaVencimiento(entity.getFecha_vencimiento());
        return dto;
    }

    public static ProductoEntity toEntity(ProductoDTO dto) {
        ProductoEntity entity = new ProductoEntity();
        entity.setIdProducto(dto.getIdProducto());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setPrecio(dto.getPrecio());
        entity.setStock(dto.getStock());
        entity.setFecha_vencimiento(dto.getFechaVencimiento());
        return entity;
    }
}
