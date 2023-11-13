package co.edu.jdc.TiendasDeBarrio.domain.mapper;

import co.edu.jdc.TiendasDeBarrio.domain.dto.TiendaDto;
import co.edu.jdc.TiendasDeBarrio.domain.entities.Tienda;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface TiendaMapper {

    TiendaMapper INSTANCE = Mappers.getMapper( TiendaMapper.class );
    TiendaDto toDto(Tienda tienda);
    Tienda toEntity(TiendaDto tienda);
    List<TiendaDto> toDto(List<Tienda> tienda);
    List<Tienda> toEntity(List<TiendaDto> tienda);
}
