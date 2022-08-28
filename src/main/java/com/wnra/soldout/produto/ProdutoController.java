package com.wnra.soldout.produto;

import com.wnra.soldout.common.controller.CommonController;
import com.wnra.soldout.common.service.GenericService;
import com.wnra.soldout.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
public class ProdutoController extends CommonController<Produto, String, FormProdutoDTO> {

    @Autowired
    private ProdutoService produtoService;

    protected ProdutoController(GenericService<Produto, String> genericService) {
        super(genericService);
    }

    @Override
    protected Produto converterFormDTO(FormProdutoDTO formProdutoDTO) {
       /* Marca marca = new Marca();
        marca.setId(formProdutoDTO.getMarcaId());
        List<Category> categories =
                formProdutoDTO.getCategorias().stream().map(categoria -> new Category(categoria.getNome())).collect(Collectors.toList());
        List<Genero> generos =
                formProdutoDTO.getGeneros().stream().map(genero -> new Genero(genero.getNome())).collect(Collectors.toList());


        */
        return null;
    }

}
