package com.limajoice.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limajoice.dslist.dto.GameMinDTO;
import com.limajoice.dslist.entities.Game;
import com.limajoice.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepositoy;
	
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepositoy.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	
	}
}
