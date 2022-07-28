package com.wnra.soldout.mapper;

import com.wnra.soldout.dto.FormPromocaoDTO;
import com.wnra.soldout.model.Promocao;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.UUID;

public class PromocaoMapper {

    private final static ModelMapper modelMapper = new ModelMapper();
    
    public static Promocao formDTOToEntity(FormPromocaoDTO formPromocaoDTO){
        Promocao promocao = modelMapper.map(formPromocaoDTO, Promocao.class);
        promocao.setId(UUID.randomUUID().toString());
        promocao.setDataCriacao(LocalDateTime.now());
        return promocao;
    }
            
            
}
