package com.wnra.soldout.mapper;

import com.wnra.soldout.dto.FormTamanhoDTO;
import com.wnra.soldout.model.Tamanho;

import java.util.List;
import java.util.stream.Collectors;

public class TamanhoMapper {

    public static Tamanho formDTOToEntity(FormTamanhoDTO dto){
        return new Tamanho(dto.getTamanho());
    }

    public static List<Tamanho> formsDTOToEntity(List<FormTamanhoDTO> dtoList){
        return dtoList.stream().map(TamanhoMapper::formDTOToEntity).collect(Collectors.toList());
    }
}
