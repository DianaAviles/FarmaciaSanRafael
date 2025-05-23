package com.farmacia.sanrafael.APIJava.repository;
import com.farmacia.sanrafael.APIJava.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
