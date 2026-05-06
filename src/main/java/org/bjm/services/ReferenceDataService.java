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
    	LOGGER.info(String.format("Count of States is {d}", states.size()));
    	states.forEach(s -> {
    		StateDto stateDto = new StateDto(s.getCode(), s.getName());
    		toReturn.add(stateDto);
    	});
    	return toReturn;
    	
    }
    
	public List<LokSabhaDto> getLokSabhasForState(String stateCode) {

		List<LokSabhaDto> toReturn = new ArrayList<>();
		List<LokSabha> lokSabhas = lokSabhaRepository.findByStateCode(stateCode);
		LOGGER.info(String.format("Count of lokSabhas is {d}", lokSabhas.size()));
		lokSabhas.forEach(ls -> {
			LokSabhaDto lokSabhaDto = new LokSabhaDto(ls.getStateCode(), ls.getConstituency());
			toReturn.add(lokSabhaDto);
		});
		return toReturn;

	}
	
	public List<VidhanSabhaDto> getVidhanSabhasForState(String stateCode) {

		List<VidhanSabhaDto> toReturn = new ArrayList<>();
		List<VidhanSabha> vidhanSabhas = vidhanSabhaRepository.findByStateCode(stateCode);
		LOGGER.info(String.format("Count of vidhanSabhas is {d}", vidhanSabhas.size()));
		vidhanSabhas.forEach(vs -> {
			VidhanSabhaDto vidhanSabhaDto = new VidhanSabhaDto(vs.getStateCode(), vs.getConstituency());
			toReturn.add(vidhanSabhaDto);
		});
		return toReturn;

	}
    
    
        
    
}
