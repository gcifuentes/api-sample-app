package cl.bice.sampleapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.bice.sampleapp.model.Currency;
import cl.bice.sampleapp.model.Indice;
import cl.bice.sampleapp.service.IndiceService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class IndiceController {
    
    @Autowired
    private IndiceService indiceService;

    @GetMapping("/api/get-last-indices")
    public ResponseEntity<Indice> getLastIndice(){
        log.info("Start getCurrencyList Service");
        
        return ResponseEntity.ok()
                            .body(indiceService.getLastIndice()); 
    }

    @GetMapping("/api/get-last-currency/list")
    public ResponseEntity<List<Currency>> getLastCurrencyList(){
        log.info("Start getLastCurrencyList Service");
        return ResponseEntity.ok()
                            .body(indiceService.getLastCurrencyList());
    }

}
