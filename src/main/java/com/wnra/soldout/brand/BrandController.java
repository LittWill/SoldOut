package com.wnra.soldout.brand;

import com.wnra.soldout.brand.dto.RequestBrandDTO;
import com.wnra.soldout.brand.dto.ResponseBrandDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;
    private final BrandMapper brandMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid RequestBrandDTO brandDTO) {
        brandService.save(brandMapper.toModel(brandDTO));
    }

    @GetMapping
    public ResponseEntity<List<ResponseBrandDTO>> listAll() {
        return ResponseEntity.ok(brandService.findAll().stream()
                .map(brandMapper::toResponse)
                .collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseBrandDTO> find(@PathVariable String id) {
        return ResponseEntity.ok(brandMapper.toResponse(brandService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Marca não encontrada!"))));
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseBrandDTO> update(@PathVariable String id,
                                                   @RequestBody RequestBrandDTO updatedBrandDTO) {
        return ResponseEntity.ok(brandMapper.toResponse(brandService.update(id,
                brandMapper.toModel(updatedBrandDTO))));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        brandService.deleteById(id);
    }

}
