package test.clon.restapi.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ResponseMessage {
    private String code;
    private String message;
    private boolean success;

    // Constructor
    public ResponseMessage(String code,String message, boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }
}
