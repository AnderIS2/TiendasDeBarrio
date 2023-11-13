package co.edu.jdc.TiendasDeBarrio.usecase.tienda;

import co.edu.jdc.TiendasDeBarrio.domain.dto.TiendaDto;
import co.edu.jdc.TiendasDeBarrio.domain.entities.Tienda;
import co.edu.jdc.TiendasDeBarrio.domain.exception.TiendaException;
import co.edu.jdc.TiendasDeBarrio.domain.mapper.TiendaMapper;
import co.edu.jdc.TiendasDeBarrio.adapter.repository.TiendaRepository;
import co.edu.jdc.TiendasDeBarrio.usecase.validator.TiendaValidator;

public class CreateTiendaUseCase {

    private TiendaRepository tiendaRepository;
    public CreateTiendaUseCase(TiendaRepository tiendaRepository) {
        this.tiendaRepository = tiendaRepository;
    }

    public void execute(TiendaDto dto) {
        // validar informacion de usuario
        TiendaValidator.validateInputDto(dto);
        // validar que el usuario no exista
        if(this.tiendaRepository.existsTienda(dto.getName().trim()).intValue() > 0)
            throw new TiendaException("La tienda ya existe");
        // convertir dto a entidad
        Tienda tienda = TiendaMapper.INSTANCE.toEntity(dto);
        // guardar usuario
        this.tiendaRepository.save(tienda);
    }

}
