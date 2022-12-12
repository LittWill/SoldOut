package com.wnra.soldout.promotion;

import com.wnra.soldout.promotion.dto.AssignPromotionDTO;
import com.wnra.soldout.promotion.dto.SavePromotionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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



    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        promotionService.deleteById(id);
    }

    @PatchMapping("assign")
    @ResponseStatus(HttpStatus.OK)
    public void assign(@Valid @RequestBody AssignPromotionDTO assignPromotionDTO) {
        promotionService.assignPromotion(promotionMapper.toModel(assignPromotionDTO));
    }

}
