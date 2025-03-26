package com.ndieujou.logement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.ndieujou.logement.entity.Logement;
import com.ndieujou.logement.model.Status;
import com.ndieujou.logement.repository.LogementRepository;

@Service
public class LogementServiceImp implements LogementService{
	
	@Autowired
	private LogementRepository logementRepository;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private final static String LOGEMENT_QUEUE = "logement.queue";

	@Override
	public Logement createLogement(@NonNull Logement logement) {
		logement.setId(0);
		Logement newLogement = logementRepository.save(logement);
		if(newLogement != null) {
			rabbitTemplate.convertAndSend(LOGEMENT_QUEUE, newLogement.getId());
		}
		return newLogement;
	}

	@Override
	public Logement updateLogement(@NonNull Logement logement) {
		Logement result = null;
		if(logement.getId() != 0) {
			result =  logementRepository.save(logement);
		}
		return result;
	}

	@Override
	public boolean deleteLogement(long idLogement) {
		Optional<Logement> logementOptional = logementRepository.findById(idLogement);
		if(logementOptional.isPresent()) {
			Logement logement = logementOptional.get();
			logement.setStatus(Status.ARCHIVED);
			Logement logementUpdate =  updateLogement(logement);
			return logementUpdate != null ? true : false;
		}
		
		return false;
	}

	@Override
	public Logement getLogement(long idLogement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Logement> getLogements(String idAuthor) {
		// TODO Auto-generated method stub
		return null;
	}

}
