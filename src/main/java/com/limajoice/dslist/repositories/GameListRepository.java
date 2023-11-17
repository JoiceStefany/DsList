package com.limajoice.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.limajoice.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
