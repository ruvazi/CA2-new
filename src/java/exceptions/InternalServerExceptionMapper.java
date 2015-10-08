package exceptions;

import com.google.gson.JsonObject;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InternalServerExceptionMapper implements ExceptionMapper<Throwable>{
    
    @Context
    ServletContext con;
    @Override
    public Response toResponse(Throwable e){
        JsonObject jo = new JsonObject();
        jo.addProperty("message", e.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(jo.toString()).build();
    }

}
