package io.github.emanueldsc.geradorderecibo.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.emanueldsc.geradorderecibo.models.Recipet;
import io.github.emanueldsc.geradorderecibo.services.RecipetService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/recipet")
public class RecipetController {

    @Autowired
    private RecipetService recipetService;

    @PostMapping()
    public ResponseEntity<Recipet> generateRecipet(
            @Valid @RequestBody Recipet reciped) throws NoSuchAlgorithmException {
        Recipet recipetValid = recipetService.generateValidateRecipet(reciped);
        return ResponseEntity.ok().body(recipetValid);
    }

    @PostMapping(value = { "/test", "/test/{cifer}" })
    public ResponseEntity<Boolean> testRecipet(
            @PathVariable(value = "cifer") Optional<String> cipher) throws NoSuchAlgorithmException {
        if (cipher.isPresent()) {
            Boolean isValid = this.recipetService.validateRecipet(cipher.get());
            return ResponseEntity.ok(isValid);
        }
        return ResponseEntity.ok(false);
    }

}
