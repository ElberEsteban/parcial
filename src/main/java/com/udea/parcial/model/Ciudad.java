package com.udea.parcial.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

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
    @Column(name = "id_ciudad")
    private Long idCiudad;

    @Column(name = "nombre", nullable = false, length = 100)
    private @NotNull String nombre;

    @Column(name = "pais", nullable = false, length = 100)
    private @NotNull String pais;

    @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Clima> climas;
}