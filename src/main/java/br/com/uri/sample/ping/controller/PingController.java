package br.com.uri.sample.ping.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {


    // <modificador de acesso> <retorno> <nomeDoMetodo>(<Parametros>)
    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }

    @GetMapping("/hello/{batata}")
    public ResponseEntity<String> hello(@PathVariable("batata")
                                            String word) {
        return ResponseEntity.ok(word);
    }


}
