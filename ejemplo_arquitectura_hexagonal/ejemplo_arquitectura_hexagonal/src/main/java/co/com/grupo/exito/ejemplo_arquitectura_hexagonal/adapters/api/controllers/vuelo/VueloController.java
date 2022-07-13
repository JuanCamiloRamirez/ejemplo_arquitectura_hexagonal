package co.com.grupo.exito.ejemplo_arquitectura_hexagonal.adapters.api.controllers.vuelo;

import co.com.grupo.exito.ejemplo_arquitectura_hexagonal.adapters.api.controllers.vuelo.dtos.CreateVueloRequestDTO;
import co.com.grupo.exito.ejemplo_arquitectura_hexagonal.adapters.api.controllers.vuelo.dtos.CreateVueloResponseDTO;
import co.com.grupo.exito.ejemplo_arquitectura_hexagonal.domain.model.Vuelo;
import co.com.grupo.exito.ejemplo_arquitectura_hexagonal.domain.ports.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vuelos")
@Validated
public class VueloController {
    private final VueloService vueloService;

    @Autowired

    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    CreateVueloResponseDTO createVuelo(@Valid @RequestBody CreateVueloRequestDTO createVueloRequest) {

        return CreateVueloResponseDTO.of(vueloService.createVuelo(createVueloRequest.getVuelo()));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllOrders(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "3") int size) {

        try {
            List<Vuelo> vuelos = new ArrayList<Vuelo>();
            Pageable paging = PageRequest.of(page, size);

            Page<Vuelo> pageOrders;

            pageOrders = vueloService.getVuelos(paging);

            vuelos = pageOrders.getContent();

            Map<String, Object> response = new HashMap<>();
            //Use DTO if it's needed
            response.put("vuelos", vuelos);
            response.put("currentPage", pageOrders.getNumber());
            response.put("totalItems", pageOrders.getTotalElements());
            response.put("totalPages", pageOrders.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
