package com.wnra.soldout.conta;

import com.wnra.soldout.common.service.GenericService;
import com.wnra.soldout.model.Conta;
import com.wnra.soldout.model.Endereco;
import org.springframework.stereotype.Service;

@Service
public class ContaService extends GenericService<Conta, String> {

    public Conta salvarEndereco(String contaId, Endereco endereco) {
        Conta conta = get(contaId);
        conta.getEnderecos().add(endereco);
        return repository.save(conta);
    }

}
