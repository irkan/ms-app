package az.kapitalbank.common.repository;

import az.kapitalbank.common.entity.UserSystem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSystemRepository extends PagingAndSortingRepository<UserSystem, Long> {

    UserSystem findByEmail(String email);

}
