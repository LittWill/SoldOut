package com.wnra.soldout.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "brand")
public class Brand {

    @Id
    @Column(name = "brd_id")
    private String id;
    @Column(name = "brd_addition_date")
    private LocalDateTime addDate;
    @Column(name = "brd_last_update")
    private LocalDateTime lastUpdate;
    @Column(name = "brd_name")
    private String name;
    @Column(name = "brd_uri_logo")
    private String uriLogo;

}
