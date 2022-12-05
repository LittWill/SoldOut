package com.wnra.soldout.brand;

import com.wnra.soldout.domain.Brand;
import com.wnra.soldout.templates.BrandTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BrandServiceTest {
    @InjectMocks
    private BrandService brandService;
    @Mock
    private BrandRepository brandRepository;
    private Brand brand;

    @BeforeEach
    void setup() {
        brand = BrandTemplate.getValid();
        MockitoAnnotations.openMocks(this);
        when(brandRepository.findById(any())).thenReturn(Optional.of(brand));
    }

    @DisplayName("O ID e data de adição foram gerados")
    @Test
    void testSave() {
        brandService.save(brand);
        assertThat(brand.getId()).isNotNull();
        assertThat(brand.getAddDate()).isNotNull();
        assertThat(brand.getLastUpdate()).isNotNull();
    }

    @DisplayName("A busca por ID está funcionando")
    @Test
    void testFind() {
        assertThatCode(() -> brandService.findById(brand.getId())).doesNotThrowAnyException();
    }

    @DisplayName("A busca de todas as marcas está trazendo o item salvo")
    @Test
    void testFindAll() {
        assertThat(brandService.findAll())
                .allMatch(brand -> this.brand.getId().equals(brand.getId()));
    }

    @DisplayName("A atualização de marca está alterando o atributo name e mantendo os outros")
    @Test
    void testUpdate() {
        brand.setAddDate(LocalDateTime.now());

        Brand updatedBrand = BrandTemplate.getValid();
        updatedBrand.setName("UPDATED_BRAND");
        brandService.update(brand.getId(), updatedBrand);

        assertThat(updatedBrand.getId())
                .isEqualTo(brand.getId());

        assertThat(updatedBrand.getAddDate())
                .isEqualToIgnoringSeconds(brand.getAddDate());

        assertThat(updatedBrand.getName())
                .isNotEqualTo(brand.getName())
                .isEqualTo("UPDATED_BRAND");
    }

    @DisplayName("A deleção está funcionando corretamente")
    @Test
    void testDelete() {
        brandService.deleteById(brand.getId());
    }

}
