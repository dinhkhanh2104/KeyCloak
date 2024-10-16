package com.example.backend.controller;


import com.example.backend.jwt.CustomJwt;
import java.text.MessageFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (
    origins = "http://localhost:4200",
    allowedHeaders = "*",
    methods = {RequestMethod.GET}
)
public class HelloController {
  @GetMapping("/hello")
  @PreAuthorize("hasAuthority('ROLE_admin')")
  public Message hello() {
    var jwt = (CustomJwt) SecurityContextHolder.getContext().getAuthentication();
    var message = MessageFormat.format(
        "Hello admin {0} {1}.\n Finally, you successfully completed the assignment. :)",
        jwt.getFirstname(), jwt.getLastname()
    );
    return new Message(message);
  }
  record Message(String message) { };
}
