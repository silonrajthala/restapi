package test.clon.restapi.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReq {
    @JsonProperty("email")
    private String email;

}

