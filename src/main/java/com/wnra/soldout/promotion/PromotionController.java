package com.wnra.soldout.promotion;

import com.wnra.soldout.promotion.dto.ResponsePromotionDTO;
import com.wnra.soldout.promotion.dto.SavePromotionDTO;
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
@RequestMapping("promotions")
@RequiredArgsConstructor
public class PromotionController {

    private final PromotionService promotionService;

    private final PromotionMapper promotionMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody SavePromotionDTO savePromotionDTO) {
        promotionService.save(promotionMapper.toModel(savePromotionDTO));
    }

    @GetMapping
    public ResponseEntity<List<ResponsePromotionDTO>> find() {
        return ResponseEntity.ok(promotionService.findAll().stream().map(promotionMapper::toResponse).collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponsePromotionDTO> find(@PathVariable String id) {
        return ResponseEntity.ok(promotionService.findById(id).map(promotionMapper::toResponse).orElseThrow());
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponsePromotionDTO> update(@PathVariable String id, SavePromotionDTO updatedPromotionDTO) {
        return ResponseEntity.ok(promotionMapper.toResponse(promotionService.updatePromotion(id, promotionMapper.toModel(updatedPromotionDTO))));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        promotionService.deleteById(id);
    }


}
