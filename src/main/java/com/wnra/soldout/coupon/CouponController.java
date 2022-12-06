package com.wnra.soldout.coupon;

import com.wnra.soldout.coupon.dto.RequestCouponDTO;
import com.wnra.soldout.coupon.dto.ResponseCouponDTO;
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
@RequestMapping("coupons")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    private final CouponMapper couponMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody RequestCouponDTO requestCouponDTO) {
        couponService.save(couponMapper.toModel(requestCouponDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseCouponDTO> find(@PathVariable String id) {
        return ResponseEntity.ok(couponMapper.toResponse(couponService.findById(id).orElseThrow()));
    }

    @GetMapping
    public ResponseEntity<List<ResponseCouponDTO>> findAll() {
        return ResponseEntity.ok(couponService.findAll().stream().map(couponMapper::toResponse).collect(Collectors.toList()));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody RequestCouponDTO updatedCouponDTO, @PathVariable String id) {
        couponService.update(id, couponMapper.toModel(updatedCouponDTO));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id) {
        couponService.deleteById(id);
    }

}
