package cl.bice.sampleapp.service;

import java.util.List;

import cl.bice.sampleapp.model.Currency;
import cl.bice.sampleapp.model.Indice;

/**
 * @author Glen Cifuentes
 */
public interface IndiceService {
    
    /**
     * Return last currency indices
     * @return Indice
     */
    public Indice getLastIndice();

    public List<Currency> getLastCurrencyList();
}
