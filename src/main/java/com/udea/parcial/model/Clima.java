package com.udea.parcial.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Clima {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_clima")
    private Long idClima;

    @Column(name = "temperatura", nullable = false)
    private @NotNull double temperatura;

    @Column(name = "humedad", nullable = false)
    private @NotNull double humedad;

    @Column(name = "precipitacion", nullable = false)
    private @NotNull double precipitacion;

    @Column(name = "rating", nullable = false)
    private @NotNull int rating;

    @ManyToOne
    @JoinColumn(name = "id_ciudad", nullable = false)
    private Ciudad ciudad;
}