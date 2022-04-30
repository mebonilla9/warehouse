package co.edu.umb.warehouse.application.controller;

import co.edu.umb.warehouse.application.service.ProviderService;
import co.edu.umb.warehouse.domain.entity.Provider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public record ProviderController(ProviderService providerService) {

  @RequestMapping("/")
  public String index(Model model){
    model.addAttribute("providers", providerService.getAllProviders());
    model.addAttribute("provider", new Provider());
    return "index";
  }

  @PostMapping("/save")
  public String save(Provider provider, Model model){
    model.addAttribute("provider", new Provider());
    if (provider.getId() != null){
      providerService.editProvider(provider);
      return "redirect:/";
    }
    providerService.saveProvider(provider);
    return "redirect:/";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable("id") Integer id, Model model){
    model.addAttribute("providers", providerService.getAllProviders());
    if (id != null && id != 0){
      model.addAttribute("provider", providerService.findById(id));
    }
    return "index";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable("id") Integer id, Model model){
    Provider provider = providerService.findById(id);
    provider.setEnable(Boolean.FALSE);
    providerService.editProvider(provider);
    return "redirect:/";
  }

}
