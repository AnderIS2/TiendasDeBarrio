package co.edu.jdc.TiendasDeBarrio.usecase.tienda;

import co.edu.jdc.TiendasDeBarrio.domain.dto.TiendaDto;
import co.edu.jdc.TiendasDeBarrio.domain.entities.Tienda;
import co.edu.jdc.TiendasDeBarrio.domain.exception.TiendaException;
import co.edu.jdc.TiendasDeBarrio.domain.mapper.TiendaMapper;
import co.edu.jdc.TiendasDeBarrio.adapter.repository.TiendaRepository;

public class UpdateTiendaUseCase {

    private TiendaRepository tiendaRepository;

    public UpdateTiendaUseCase(TiendaRepository tiendaRepository) {
        this.tiendaRepository = tiendaRepository;
    }

    public void execute(TiendaDto dto, Long id) {

        // validar que la tienda exista
        if (this.tiendaRepository.existTienda(id).intValue() == 0)
            throw new TiendaException("La tienda no existe");
        dto.setId(id);

        Tienda tienda = TiendaMapper.INSTANCE.toEntity(dto);

        // guardar información actualizada
        this.tiendaRepository.save(tienda);
    }
}
