package com.wnra.soldout.brand;

import com.wnra.soldout.domain.Brand;
import com.wnra.soldout.templates.BrandTemplate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@TestMethodOrder(MethodOrderer.DisplayName.class)
class BrandServiceTest {

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandRepository brandRepository;
    private Brand brand;

    @BeforeEach
    void setup() {
        brand = brandService.save(BrandTemplate.getValid());
    }

    @AfterEach
    void clean() {
        brandRepository.deleteAll();
    }

    @DisplayName("O ID e data de adição foram gerados")
    @Test
    void testSave() {
        assertThat(brand.getId()).isNotNull();
        assertThat(brand.getAddDate()).isNotNull();
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
        Brand updatedBrand = BrandTemplate.getValid();
        updatedBrand.setName("UPDATED_BRAND");
        brandService.update(brand.getId(), updatedBrand);

        assertThat(updatedBrand.getId())
                .isEqualTo(brand.getId());

        assertThat(updatedBrand.getAddDate())
                .isEqualToIgnoringNanos(brand.getAddDate());

        assertThat(updatedBrand.getName())
                .isNotEqualTo(brand.getName())
                .isEqualTo("UPDATED_BRAND");
    }

    @DisplayName("A deleção está funcionando corretamente")
    @Test
    void testDelete() {
        brandService.deleteById(brand.getId());
        assertThat(brandRepository.findById(brand.getId())).isEmpty();
    }

}
