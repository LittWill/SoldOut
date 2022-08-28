package com.wnra.soldout.cupom;

import com.wnra.soldout.model.Cupom;

public class CupomMapper {

    public static Cupom formUpdateCupomDTOToEntity(FormUpdateCupomDTO formUpdateCupomDTO){
        return new Cupom(null, formUpdateCupomDTO.getValor(), formUpdateCupomDTO.getDataExpiracao(), formUpdateCupomDTO.getIsValorPorcentagem(), formUpdateCupomDTO.getIsFreteCupom());
    }
}
