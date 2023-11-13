package co.edu.jdc.TiendasDeBarrio.usecase.tienda;

import co.edu.jdc.TiendasDeBarrio.domain.exception.TiendaException;
import co.edu.jdc.TiendasDeBarrio.adapter.repository.TiendaRepository;

public class DeleteTiendaUseCase {

    private TiendaRepository tiendaRepository;

    public DeleteTiendaUseCase(TiendaRepository tiendaRepository){
        this.tiendaRepository = tiendaRepository;
    }

    public void execute(Long id){
        if(tiendaRepository.existTienda(id).intValue() == 0)
            throw new TiendaException("La tienda no existe");
        this.tiendaRepository.deleteById(id);
    }
}
