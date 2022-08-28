package com.wnra.soldout.promocao;

import com.wnra.soldout.common.controller.CommonController;
import com.wnra.soldout.common.service.GenericService;
import com.wnra.soldout.model.Product;
import com.wnra.soldout.model.Promocao;
import com.wnra.soldout.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("promocoes")
public class PromocaoController extends CommonController<Promocao, String, FormPromocaoDTO> {

    @Autowired
    private PromocaoService promocaoService;

    @Autowired
    private ProdutoService produtoService;

    protected PromocaoController(GenericService<Promocao, String> genericService) {
        super(genericService);
    }

    @PatchMapping("expirar/{promocaoId}")
    public ResponseEntity<?> expirarPromocaoAntecipadamente (@PathVariable String promocaoId){
        Promocao promocao = promocaoService.get(promocaoId);
        promocao = promocaoService.expirarPromocao(promocao);
        return ResponseEntity.ok("Promoção expirada com sucesso! " + promocao.getDataExpiracao());
    }

    @PostMapping("{promocaoId}/produtos")
    public ResponseEntity<?> definirPromocaoProdutos(@PathVariable String promocaoId, @RequestBody FormPromocaoProdutosIdDTO formPromocaoDTO){

        Promocao promocao = promocaoService.get(promocaoId);

        List<Product> products =
                formPromocaoDTO.getProdutosId().stream().map(formIdDTO -> produtoService.get(formIdDTO.getId())).collect(Collectors.toList());

        promocaoService.definirPromocao(products, promocao);

        return ResponseEntity.ok("Promoção definida para " + products.size() + " produto(s)!");
    }

    @Override
    protected Promocao converterFormDTO(FormPromocaoDTO formPromocaoDTO) {
        return null;
    }

}
