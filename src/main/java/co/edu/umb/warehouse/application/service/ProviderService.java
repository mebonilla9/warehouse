package co.edu.umb.warehouse.application.service;

import co.edu.umb.warehouse.domain.entity.Provider;
import co.edu.umb.warehouse.domain.repository.ProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProviderService {

  private ProviderRepository providerRepository;

  @Transactional
  public void saveProvider(Provider provider){
    provider.setEnable(Boolean.TRUE);
    providerRepository.save(provider);
  }

  @Transactional
  public void editProvider(Provider provider){
    providerRepository.save(provider);
  }

  @Transactional(readOnly = true)
  public List<Provider> getAllProviders(){
    return providerRepository.findAll();
  }

  @Transactional(readOnly = true)
  public Provider findById(Integer id){
    Optional<Provider> providerFound = providerRepository.findById(id);
    if (providerFound.isEmpty()){
      System.out.println("Provider not found");
    }
    return providerFound.get();
  }

}
