package local.zoo.loginservice.repository;

import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import local.zoo.loginservice.model.ZooUser;

@ApplicationScoped
public class ZooUserRepository implements PanacheRepositoryBase<ZooUser, UUID> {

}
