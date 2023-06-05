package kg.marsbekov.akzhol.dal.repository;

import kg.marsbekov.akzhol.dal.entity.IdeaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepository extends CrudRepository<IdeaEntity, Long> {
}
