package gateway.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

public class FallBackController {
    //fallback
    @GetMapping("/fallback")
    public ResponseEntity<Mono<String>> contactSupport() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Mono.just("An error occurred. Please try after some time or contact support team!!!"));
    }
}


