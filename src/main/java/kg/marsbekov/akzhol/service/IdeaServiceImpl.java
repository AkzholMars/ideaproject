package kg.marsbekov.akzhol.service;

import kg.marsbekov.akzhol.dal.entity.IdeaEntity;
import kg.marsbekov.akzhol.dal.repository.IdeaRepository;
import kg.marsbekov.akzhol.model.IdeaDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class IdeaServiceImpl implements IdeaService {

    private final IdeaRepository ideaRepository;


    @Override
    public void saveIdea(IdeaDto idea) {
        IdeaEntity entity = new IdeaEntity(idea);
        ideaRepository.save(entity);
    }

    @Override
    public List<IdeaDto> getAllIdeas() {
        List<IdeaEntity> ideas = (List<IdeaEntity>) ideaRepository.findAll();

        return ideas.stream()
                .map(IdeaDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteIdea(Long id) {
        ideaRepository.deleteById(id);
    }

}
