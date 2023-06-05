package kg.marsbekov.akzhol.service;


import kg.marsbekov.akzhol.model.IdeaDto;

import java.util.List;

public interface IdeaService {

    void saveIdea(IdeaDto idea);

    List<IdeaDto> getAllIdeas();

    void deleteIdea(Long id);
}
