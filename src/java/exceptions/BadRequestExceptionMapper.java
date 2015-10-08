package exceptions;

import com.google.gson.JsonObject;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {

    @Context
    ServletContext context;
    @Override
    public Response toResponse(BadRequestException e) {
        JsonObject jo = new JsonObject();
        if (Boolean.valueOf(context.getInitParameter("debug"))) {
            String err = "";
            StackTraceElement[] stack = e.getStackTrace();
            for (StackTraceElement elm : stack) {
                err += elm.toString();
            }
            jo.addProperty("stackTrace", err);
        }
        jo.addProperty("code", 400);
        jo.addProperty("message", "Malformed request. Please inspect your URL for errors.");
        return Response.status(Response.Status.BAD_REQUEST).entity(jo.toString()).type(MediaType.APPLICATION_JSON).build();
    }
}
