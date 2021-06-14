package cl.bice.sampleapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Currency {
    
    private String key;
    private String name;
    private String unit;
    private Long date;    
    private double value;

}
