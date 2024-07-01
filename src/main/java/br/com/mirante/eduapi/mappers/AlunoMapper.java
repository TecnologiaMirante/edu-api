package br.com.mirante.eduapi.mappers;

import br.com.mirante.eduapi.dto.AlunoDTO;
import br.com.mirante.eduapi.models.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlunoMapper {
    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);
    AlunoDTO alunoToAlunoDTO(Aluno aluno);
    Aluno alunoDTOToAluno(AlunoDTO aluno);

}