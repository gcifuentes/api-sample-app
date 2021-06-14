package cl.bice.sampleapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import cl.bice.sampleapp.controller.IndiceController;
import cl.bice.sampleapp.model.Indice;
import cl.bice.sampleapp.service.IndiceService;

import static org.mockito.Mockito.*;

@WebMvcTest(IndiceController.class)
public class IndiceControllerTest {
    
    @Autowired
    private MockMvc mvc;

    @MockBean
    private IndiceService indiceService;
    
    @Test
    void getLastIndiceTest() throws Exception{
        when(indiceService.getLastIndice()).thenReturn(new Indice());

        mvc.perform(get("/api/get-last-indices").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.cobre.unit").value("dolar"));
    }
}
