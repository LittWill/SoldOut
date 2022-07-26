package com.wnra.soldout.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class Imagem {

    @Id
    private String url;
    private LocalDateTime dataAdicao;

}
