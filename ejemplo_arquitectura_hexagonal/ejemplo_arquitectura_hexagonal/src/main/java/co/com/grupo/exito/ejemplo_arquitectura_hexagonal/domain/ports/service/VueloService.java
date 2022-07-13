package co.com.grupo.exito.ejemplo_arquitectura_hexagonal.domain.ports.service;

import co.com.grupo.exito.ejemplo_arquitectura_hexagonal.domain.model.Vuelo;
import co.com.grupo.exito.ejemplo_arquitectura_hexagonal.domain.ports.repository.VueloRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VueloService {
    private final VueloRepository vueloRepository;

    public VueloService(final VueloRepository vueloRepository){ this.vueloRepository = vueloRepository; }

    public Vuelo createVuelo(Vuelo vuelo){
        vueloRepository.save(vuelo);
        return vuelo;
    }

    public Page<Vuelo> getVuelos(Pageable pageable){
        return vueloRepository.findAll(pageable);
    }
}
