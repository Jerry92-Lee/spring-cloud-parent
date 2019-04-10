package nickzxing.microservice.user.web.repo;

import nickzxing.microservice.user.web.repo.po.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author Jerry
 * @version 2019-04-09
 */
@Repository
public interface UserRepository extends JpaRepository<UserPO, Serializable>, JpaSpecificationExecutor<UserPO> {

}
