package co.edu.jdc.TiendasDeBarrio.usecase.tienda;

import co.edu.jdc.TiendasDeBarrio.domain.dto.TiendaDto;
import co.edu.jdc.TiendasDeBarrio.domain.entities.Tienda;
import co.edu.jdc.TiendasDeBarrio.domain.mapper.TiendaMapper;
import co.edu.jdc.TiendasDeBarrio.adapter.repository.TiendaRepository;

import java.util.List;

public class ConsultTiendaUseCase {
    private TiendaRepository tiendaRepository;

    public ConsultTiendaUseCase(TiendaRepository tiendaRepository) {

        this.tiendaRepository = tiendaRepository;
    }

    public List<TiendaDto> execute() {
        List <Tienda> users = tiendaRepository.findAll();
        List<TiendaDto> listUsers = TiendaMapper.INSTANCE.toDto(users);
        return listUsers;
    }
}
