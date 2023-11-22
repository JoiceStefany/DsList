package com.limajoice.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.limajoice.dslist.dto.GameListDTO;


import com.limajoice.dslist.entities.GameList;
import com.limajoice.dslist.projections.GameMinProjection;
import com.limajoice.dslist.repositories.GameListRepository;
import com.limajoice.dslist.repositories.GameRepository;


@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(GameListDTO :: new).toList();
	}

	@Transactional
	public void move (Long listId, int sourceIndex, int destinationIndex){

		List <GameMinProjection> list = gameRepository.searchByList(listId);

		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);

		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

		for (int i = min; i <= max; i++){
				gameListRepository.updateBelogingPosition(listId, list.get(i).getId(), i);
		}
	}

	@Transactional(readOnly = true)
	public GameListDTO findById(Long id){
		GameList entity = gameListRepository.findById(id).get();
		return new GameListDTO(entity);
	}
}
