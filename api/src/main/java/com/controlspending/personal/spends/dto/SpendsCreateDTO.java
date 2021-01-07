package com.controlspending.personal.spends.dto;

import com.controlspending.personal.spends.Spends;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpendsCreateDTO {

    private Long id;

    @NotBlank
    @Size(max = 150)
    private String descricao;

    private BigDecimal valor;

    private boolean tags;

    public Spends parseToSpends() {
        Spends spends = new Spends();
        spends.setId(this.getId());
        spends.setDescricao(this.getDescricao());
        spends.setValor(this.getValor());
        spends.setTags(isTags());
        return spends;
    }
}
