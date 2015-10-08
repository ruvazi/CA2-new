package exceptions;

import com.google.gson.JsonObject;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Context
    ServletContext context;
    @Override
    public Response toResponse(NotFoundException e) {
        JsonObject jo = new JsonObject();

        if (Boolean.valueOf(context.getInitParameter("debug"))) {
            String err = "";
            StackTraceElement[] stack = e.getStackTrace();
            for (StackTraceElement elm : stack) {
                err += elm.toString();
            }
            jo.addProperty("stackTrace", err);
        }
        jo.addProperty("code", 404);
        jo.addProperty("message", "Resource not found. Please check your values and verify that they are correct.");
        return Response.status(Response.Status.NOT_FOUND).entity(jo.toString()).type(MediaType.APPLICATION_JSON).build();
    }
}
