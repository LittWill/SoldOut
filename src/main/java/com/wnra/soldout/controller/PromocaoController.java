package com.wnra.soldout.controller;


import com.wnra.soldout.dto.FormPromocaoDTO;
import com.wnra.soldout.dto.FormPromocaoProdutosIdDTO;
import com.wnra.soldout.mapper.PromocaoMapper;
import com.wnra.soldout.model.Produto;
import com.wnra.soldout.model.Promocao;
import com.wnra.soldout.service.GenericService;
import com.wnra.soldout.service.ProdutoService;
import com.wnra.soldout.service.PromocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("promocoes")
public class PromocaoController extends CommonController<Promocao, String, FormPromocaoDTO>{

    @Autowired
    private PromocaoService promocaoService;

    @Autowired
    private ProdutoService produtoService;

    protected PromocaoController(GenericService<Promocao, String> genericService) {
        super(genericService);
    }

    @PostMapping("{promocaoId}/produtos")
    public ResponseEntity<?> definirPromocaoProdutos(@PathVariable String promocaoId, @RequestBody FormPromocaoProdutosIdDTO formPromocaoDTO){

        Promocao promocao = promocaoService.obter(promocaoId);

        List<Produto> produtos =
                formPromocaoDTO.getProdutosId().stream().map(formIdDTO -> produtoService.obter(formIdDTO.getId())).collect(Collectors.toList());

        promocaoService.definirPromocao(produtos, promocao);

        return ResponseEntity.ok("Promoção definida para " + produtos.size() + " produto(s)!");
    }

    @Override
    protected Promocao converterFormDTO(FormPromocaoDTO formPromocaoDTO) {
        return PromocaoMapper.formDTOToEntity(formPromocaoDTO);
    }

}
