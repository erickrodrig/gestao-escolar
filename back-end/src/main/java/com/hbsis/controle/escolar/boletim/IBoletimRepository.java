package com.hbsis.controle.escolar.boletim;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBoletimRepository extends JpaRepository<Boletim, Long> {
}