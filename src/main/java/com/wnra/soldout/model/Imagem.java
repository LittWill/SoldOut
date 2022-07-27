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
    @Column(updatable = false)
    private String url;

    @Column(insertable = false, updatable = false)
    private LocalDateTime dataAdicao;

}
