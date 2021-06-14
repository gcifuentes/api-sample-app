package cl.bice.sampleapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import cl.bice.sampleapp.model.Currency;
import cl.bice.sampleapp.model.Indice;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IndiceServiceImpl implements IndiceService{

    @Value("${service.last-currency-list-url}")
    private String lastCurrencyListUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Indice getLastIndice() {
        try {            

            var headers =  new HttpHeaders();
            headers.add("Content-type", "application/json");

            var response = restTemplate.getForEntity(lastCurrencyListUrl, Indice.class, headers);
            return response.getBody();
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @Override
    public List<Currency> getLastCurrencyList() {
        try {            

            var headers =  new HttpHeaders();
            headers.add("Content-type", "application/json");

            var indice = restTemplate.getForEntity(lastCurrencyListUrl, Indice.class, headers).getBody();
            
            List<Currency> currencyList = new ArrayList<>();
            currencyList.add(indice.getCobre());
            currencyList.add(indice.getDolar());
            currencyList.add(indice.getEuro());
            currencyList.add(indice.getIpc());
            currencyList.add(indice.getIvp());
            currencyList.add(indice.getOro());
            currencyList.add(indice.getPlata());
            currencyList.add(indice.getUf());
            currencyList.add(indice.getUtm());
            currencyList.add(indice.getYen());
            
            return currencyList;

        } catch (Exception e) {
            log.info(e.getMessage());
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

}
