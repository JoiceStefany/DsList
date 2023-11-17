package com.limajoice.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.limajoice.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}