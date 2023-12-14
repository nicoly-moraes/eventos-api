package eventos.api.setor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SetorRepository extends JpaRepository<Setor, Long> {
    @Query("SELECT s FROM Setor s WHERE s.evento_id = :evento_id")
    List<Setor> findAllByEventoId(@Param("evento_id") Long evento_id);
}
