package co.edu.jdc.TiendasDeBarrio.domain.dto;

import lombok.Data;

@Data
public class TiendaDto {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
}
