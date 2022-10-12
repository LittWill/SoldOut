package com.wnra.soldout.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class Image {

    @Id
    @Column(updatable = false)
    private String url;

    @Column(insertable = false, updatable = false)
    private LocalDateTime addDate;

}
