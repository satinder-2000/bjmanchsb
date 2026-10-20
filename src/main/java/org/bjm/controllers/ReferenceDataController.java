package org.bjm.controllers;

import java.util.List;

import org.bjm.dtos.LokSabhaDto;
import org.bjm.dtos.VidhanSabhaDto;
import org.bjm.services.ReferenceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ReferenceDataController {
	
	@Autowired
    private ReferenceDataService referenceDataService;
	
	@GetMapping(path="/stateLokSabhas/{stateCode}", produces="application/json")
    public List<LokSabhaDto> getLokSabhasForState(@PathVariable("stateCode") String stateCode){
    	return referenceDataService.getLokSabhasForState(stateCode);
    }
	

    
    @GetMapping(path="/stateVidhanSabhas/{stateCode}", produces="application/json")
    public List<VidhanSabhaDto> getVidhanSabhasForState(@PathVariable("stateCode") String stateCode){
    	return referenceDataService.getVidhanSabhasForState(stateCode);
    }

}
