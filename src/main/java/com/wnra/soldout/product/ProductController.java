package com.wnra.soldout.product;

import com.wnra.soldout.product.dto.RequestProductDTO;
import com.wnra.soldout.product.dto.ResponseProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final ProductMapper productMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody RequestProductDTO requestProductDTO) {
        productService.save(productMapper.toModel(requestProductDTO));
    }

    @GetMapping
    public ResponseEntity<List<ResponseProductDTO>> find() {
        return ResponseEntity.ok(productService.findAll().stream().map(productMapper::toResponse).collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseProductDTO> find(@PathVariable String id) {
        return ResponseEntity.ok(productService.findById(id).map(productMapper::toResponse).orElseThrow());
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseProductDTO> update(@PathVariable String id, @RequestBody RequestProductDTO requestProductDTO) {
        return ResponseEntity.ok(productMapper.toResponse(productService.update(id, productMapper.toModel(requestProductDTO))));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        productService.deleteById(id);
    }
}
