package local.zoo.loginservice.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import local.zoo.loginservice.model.ZooUser;
import local.zoo.loginservice.service.ZooUserService;

@Path("/api/v1/zoo-user")
public class ZooUserResource {

    @Inject
    ZooUserService zooUserService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ZooUser> getAllZooUser() {
        return this.zooUserService.getZooUsers();
    }
}
