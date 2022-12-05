package com.wnra.soldout.category;

import com.wnra.soldout.category.dto.RequestCategoryDTO;
import com.wnra.soldout.category.dto.ResponseCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    private final CategoryMapper categoryMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody RequestCategoryDTO requestCategoryDTO) {
        categoryService.save(categoryMapper.toModel(requestCategoryDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseCategoryDTO> find(@PathVariable String id) {
        return ResponseEntity.ok(categoryMapper.toResponse(categoryService.findById(id).orElseThrow()));
    }

    @GetMapping
    public ResponseEntity<List<ResponseCategoryDTO>> findAll() {
        return ResponseEntity.ok(categoryService.findAll().stream().map(categoryMapper::toResponse).collect(Collectors.toList()));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody RequestCategoryDTO updatedCategoryDTO, @PathVariable String id) {
        categoryService.update(id, categoryMapper.toModel(updatedCategoryDTO));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        categoryService.deleteById(id);
    }

}
