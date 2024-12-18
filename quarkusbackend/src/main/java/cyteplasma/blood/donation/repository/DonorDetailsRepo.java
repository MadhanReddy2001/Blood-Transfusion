package cyteplasma.blood.donation.repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cyteplasma.blood.donation.entity.DonorDetails;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DonorDetailsRepo implements PanacheRepository<DonorDetails> {

        @PersistenceContext
        EntityManager entityManager;

        @Transactional
        public Map<String, Long> getCountByBloodGroups() {
                List<Object[]> results = entityManager.createQuery(
                                "SELECT d.bloodgroup, COUNT(d) FROM DonorDetails d GROUP BY d.bloodgroup",
                                Object[].class)
                                .getResultList();

                return results.stream()
                                .collect(Collectors.toMap(
                                                row -> (String) row[0],
                                                row -> ((Number) row[1]).longValue()));
        }

        @Transactional
        public List<DonorDetails> findDonorsByFilters(String bloodgroup, String countryname, String statename,
                        String city) {
                System.out.println("parameters: "+bloodgroup +countryname + statename + city);
                StringBuilder queryBuilder = new StringBuilder(
                                "SELECT d FROM DonorDetails d WHERE d.bloodgroup = :bloodgroup");
                if (countryname != null && !countryname.isEmpty()) {
                        queryBuilder.append(" AND d.countryname = :countryname");
                }
                if (statename != null && !statename.isEmpty()) {
                        queryBuilder.append(" AND d.statename = :statename");
                }
                if (city != null && !city.isEmpty()) {
                        queryBuilder.append(" AND d.city = :city");
                }
                Query query = entityManager.createQuery(queryBuilder.toString(), DonorDetails.class);
                query.setParameter("bloodgroup", bloodgroup);
                if (countryname != null && !countryname.isEmpty()) {
                        query.setParameter("countryname", countryname);
                }
                if (statename != null && !statename.isEmpty()) {
                        query.setParameter("statename", statename);
                }
                if (city != null && !city.isEmpty()) {
                        query.setParameter("city", city);
                }
                return query.getResultList();
        }
}
