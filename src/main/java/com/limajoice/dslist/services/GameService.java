package com.limajoice.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.limajoice.dslist.dto.GameDTO;
import com.limajoice.dslist.dto.GameMinDTO;

import com.limajoice.dslist.entities.GameList;
import com.limajoice.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		GameList result = gameRepository.findById(id).get();
		return new GameDTO();
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<GameList> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO()).toList();
	}
	
	
	
}
