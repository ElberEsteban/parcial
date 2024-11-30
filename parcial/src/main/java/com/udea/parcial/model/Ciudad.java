package com.udea.parcial.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idciudad")
    private Long idCiudad;

    @Column(name = "ciudad", nullable = false, length = 80)
    private @NotNull String ciudad;

    @Column(name = "pais", nullable = false, length = 80)
    private @NotNull String pais;

    @Column(name = "clima", nullable = false, length = 80)
    private @NotNull String clima;

    @Column(name = "temperatura", nullable = false)
    private @NotNull Double temperatura;
}