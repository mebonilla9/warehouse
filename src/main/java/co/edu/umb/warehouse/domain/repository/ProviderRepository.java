package co.edu.umb.warehouse.domain.repository;

import co.edu.umb.warehouse.domain.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProviderRepository extends JpaRepository<Provider, Integer> {

}