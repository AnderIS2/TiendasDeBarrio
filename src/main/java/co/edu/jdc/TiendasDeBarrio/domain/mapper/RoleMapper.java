package co.edu.jdc.TiendasDeBarrio.domain.mapper;

import co.edu.jdc.TiendasDeBarrio.domain.dto.RoleDto;
import co.edu.jdc.TiendasDeBarrio.domain.entities.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
    RoleDto toDto(Role role);
    Role toEntity(RoleDto role);
    List<RoleDto> toDto(List<Role> role);
    List<Role> toEntity(List<RoleDto> role);
}
