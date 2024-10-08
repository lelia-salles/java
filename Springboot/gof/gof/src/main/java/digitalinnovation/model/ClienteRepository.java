package digitalinnovation.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;   
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository //não é necessário, mas é recomendado
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
