package com.wnra.soldout;

import com.wnra.soldout.model.ItemCompra;
import com.wnra.soldout.model.Produto;
import com.wnra.soldout.model.Promocao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class SoldOutApplicationTests {

	private static Promocao promocao;

	@BeforeAll
	static void setup(){
		promocao = new Promocao(LocalDateTime.now().plusDays(7), BigDecimal.valueOf(20), true);
	}


	@Test
	void aplicarPromocaoItemNaoPromocional() {
		Produto produto = new Produto();
		ItemCompra itemCompra = new ItemCompra(1, BigDecimal.valueOf(500.0), produto);
		aplicarPromocao(List.of(itemCompra));
		Assertions.assertEquals(BigDecimal.valueOf(500.00), itemCompra.getValor());

	}

	@Test
	void aplicarPromocaoPorcentagemItemPromocional() {
		Produto produto = new Produto();
		produto.setPromocao(promocao);
		ItemCompra itemCompra = new ItemCompra(1, BigDecimal.valueOf(500), produto);
		aplicarPromocao(List.of(itemCompra));
		Assertions.assertEquals(BigDecimal.valueOf(400.00), itemCompra.getValor());

	}

	@Test
	void aplicarPromocaoValorFixoItemPromocional() {
		Produto produto = new Produto();
		promocao.setIsValorPorcentagem(false);
		produto.setPromocao(promocao);
		ItemCompra itemCompra = new ItemCompra(1, BigDecimal.valueOf(500), produto);
		aplicarPromocao(List.of(itemCompra));
		Assertions.assertEquals(BigDecimal.valueOf(480.00), itemCompra.getValor());

	}

	@Test
	void aplicarPromocaoExpirada() {
		Produto produto = new Produto();
		promocao.setDataExpiracao(LocalDateTime.now().minusMonths(1));
		definirPromocao(produto, promocao);
		ItemCompra itemCompra = new ItemCompra(1, BigDecimal.valueOf(500.00), produto);
		aplicarPromocao(List.of(itemCompra));
		Assertions.assertEquals(BigDecimal.valueOf(500.00), itemCompra.getValor());

	}

	public void definirPromocao(Produto produto, Promocao promocao){
		if (promocao.getDataExpiracao().isAfter(LocalDateTime.now()))
			produto.setPromocao(promocao);
	}

	public void aplicarPromocao(List<ItemCompra> itensCompra) {
		itensCompra.forEach(itemCompra -> {
			boolean promocaoAtiva = itemCompra.getProduto().getPromocao() != null;

			if (promocaoAtiva) {
				Promocao promocao = itemCompra.getProduto().getPromocao();

				if (Boolean.TRUE.equals(promocao.getIsValorPorcentagem())) {
					itemCompra.setValor(BigDecimal.valueOf(itemCompra.getValor().doubleValue() - (itemCompra.getValor().doubleValue() * promocao.getValor().doubleValue() / 100)));
				} else {
					itemCompra.setValor(BigDecimal.valueOf(itemCompra.getValor().doubleValue() - promocao.getValor().doubleValue()));
				}
			}
		});
	}

}
