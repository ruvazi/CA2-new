package exceptions;

import com.google.gson.JsonObject;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UnauthorizedAccessExceptionMapper implements ExceptionMapper<UnauthorizedAccessException> {

    @Context
    ServletContext context;

    @Override
    public Response toResponse(UnauthorizedAccessException e) {
        JsonObject jo = new JsonObject();

        if (Boolean.valueOf(context.getInitParameter("debug"))) {

            String err = "";

            StackTraceElement[] stack = e.getStackTrace();

            for (StackTraceElement elm : stack) {
                err += elm.toString();
            }

            jo.addProperty("stackTrace", err);
        }

        jo.addProperty("code", 401);
        jo.addProperty("message", "Access denied");

        return Response.status(Response.Status.UNAUTHORIZED).entity(jo.toString()).type(MediaType.APPLICATION_JSON).build();
    }
}
