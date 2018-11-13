package com.jdios.gdg.clients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdios.gdg.library.clients.Client;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {
   @Transactional
   public Integer removeById(Long idClient);
}
