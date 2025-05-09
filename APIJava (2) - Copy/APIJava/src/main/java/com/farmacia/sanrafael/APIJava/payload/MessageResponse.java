package com.farmacia.sanrafael.APIJava.payload;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;
@Data
@ToString
@Builder
public class MessageResponse {
    private String message;
    private Object data;
    private HttpStatus status;
}
