package org.bjm.services;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bjm.entities.LokSabha;
import org.bjm.entities.State;
import org.bjm.entities.VidhanSabha;
import org.bjm.dtos.LokSabhaDto;
import org.bjm.dtos.StateDto;
import org.bjm.dtos.VidhanSabhaDto;
import org.bjm.entities.repositories.LokSabhaRepository;
import org.bjm.entities.repositories.StateRepository;
import org.bjm.entities.repositories.VidhanSabhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class ReferenceDataService {
    
    private static final Logger LOGGER = LogManager.getLogger();
    
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private LokSabhaRepository lokSabhaRepository;
    @Autowired
    private VidhanSabhaRepository vidhanSabhaRepository;
    
    
    public List<StateDto> getAllStates(){
    	
    	List<StateDto> toReturn = new ArrayList<>();
    	List<State> states = stateRepository.findAll();
    	LOGGER.info(String.format("Count of States is %d", states.size()));
    	states.forEach(s -> {
    		StateDto stateDto = new StateDto(s.getCode(), s.getName());
    		toReturn.add(stateDto);
    	});
    	return toReturn;
    	
    }
    
	public List<LokSabhaDto> getLokSabhasForState(String stateCode) {
		List<LokSabhaDto> toReturn = new ArrayList();
		List<LokSabha> sourceList = lokSabhaRepository.findByStateCode(stateCode);
		for (LokSabha ls: sourceList) {
			LokSabhaDto lsDto= new LokSabhaDto(ls.getStateCode(),ls.getConstituency()); 
			toReturn.add(lsDto);
		}
		LOGGER.info(String.format("Count of lokSabhas for %s is %d",stateCode,toReturn.size()));
		return toReturn;
	}
	
	public List<VidhanSabhaDto> getVidhanSabhasForState(String stateCode) {
		List<VidhanSabhaDto> toReturn = new ArrayList();
		List<VidhanSabha> sourceList = vidhanSabhaRepository.findByStateCode(stateCode);
		for (VidhanSabha vs: sourceList) {
			VidhanSabhaDto vsDto= new VidhanSabhaDto(vs.getStateCode(),vs.getConstituency()); 
			toReturn.add(vsDto);
		}
		LOGGER.info(String.format("Count of vidhanSabhas for %s is %d",stateCode,toReturn.size()));
		return toReturn;
	}
}
