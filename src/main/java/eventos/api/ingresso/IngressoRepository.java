package eventos.api.ingresso;

import eventos.api.setor.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IngressoRepository extends JpaRepository<Ingresso, Long> {
    @Query("SELECT s FROM Ingresso s WHERE s.setor_id = :setor_id")
    List<Ingresso> findAllBySetorId(@Param("setor_id") Long setor_id);
}
