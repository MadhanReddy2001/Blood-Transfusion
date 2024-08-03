package cyteplasma.blood.donation.repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cyteplasma.blood.donation.entity.DonorDetails;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@ApplicationScoped
public class DonorDetailsRepo implements PanacheRepository<DonorDetails>{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public Map<String, Long> getCountByBloodGroups() {
        List<Object[]> results = entityManager.createQuery(
                "SELECT d.bloodgroup, COUNT(d) FROM DonorDetails d GROUP BY d.bloodgroup", Object[].class)
                .getResultList();
                
        return results.stream()
                .collect(Collectors.toMap(
                        row -> (String) row[0],
                        row -> ((Number) row[1]).longValue()
                ));
    }
}
