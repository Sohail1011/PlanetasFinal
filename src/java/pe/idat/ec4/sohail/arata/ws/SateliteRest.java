package pe.idat.ec4.sohail.arata.ws;

import java.util.Collection;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pe.idat.ec4.sohail.arata.dao.SateliteDao;
import pe.idat.ec4.sohail.arata.vo.Satelite;

@Path("satelite")
public class SateliteRest {

    @Context
    private UriInfo context;

    private SateliteDao sateliteDao = new SateliteDao();

    public SateliteRest() {
    }

    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Satelite> list() {
        return sateliteDao.findAll();
    }

    @Path("/agregar")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Satelite satelite) {
        sateliteDao.insert(satelite);
        return Response.ok().entity(satelite).build();
    }
}
