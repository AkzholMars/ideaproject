package kg.marsbekov.akzhol.dal.repository;

import kg.marsbekov.akzhol.dal.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
