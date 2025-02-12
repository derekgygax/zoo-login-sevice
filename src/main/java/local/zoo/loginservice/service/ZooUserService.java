package local.zoo.loginservice.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import local.zoo.loginservice.model.ZooUser;
import local.zoo.loginservice.repository.ZooUserRepository;

@ApplicationScoped
public class ZooUserService {

    @Inject
    ZooUserRepository zooUserRepository;

    public List<ZooUser> getZooUsers() {
        return this.zooUserRepository.listAll();
    }

}
