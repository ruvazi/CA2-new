package exceptions;

import javax.ws.rs.core.Response.Status;

public class InternalServerException extends Exception {
    private Status statuscode;

    public Status getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(Status statuscode) {
        this.statuscode = statuscode;
    }
    public InternalServerException(String e, Status statuscode){
        super(e);
    }

}
