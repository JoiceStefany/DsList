package com.limajoice.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.limajoice.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

    @Modifying
    @Query(nativeQuery = true, 
                value = "UPDATE tb_belongin SET position = :new Position WHERE list_id = :listId AND game_id = :gameId")
                void updateBelogingPosition(Long listId, Long gameId, Integer newPosition);
}