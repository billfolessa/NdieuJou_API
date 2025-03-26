package com.ndieujou.logement.services;

import java.util.List;

import com.ndieujou.logement.entity.Logement;

public interface LogementService {
	
   public Logement createLogement(Logement logement);
   
   public Logement updateLogement(Logement logement);
   
   public boolean deleteLogement(long idLogement);

   public Logement getLogement(long idLogement);
   
   public List<Logement> getLogements(String idAuthor);
}
