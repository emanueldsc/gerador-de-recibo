package io.github.emanueldsc.geradorderecibo.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.emanueldsc.geradorderecibo.models.Recipet;
import io.github.emanueldsc.geradorderecibo.services.JasperService;
import io.github.emanueldsc.geradorderecibo.services.RecipetService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/recipet")
public class RecipetController {

    @Autowired
    private RecipetService recipetService;

    @Autowired
    private JasperService jasperService;

    @PostMapping(value = { "/test", "/test/{cifer}" })
    public ResponseEntity<Boolean> testRecipet(
            @PathVariable(value = "cifer") Optional<String> cipher) throws NoSuchAlgorithmException {
        if (cipher.isPresent()) {
            Boolean isValid = this.recipetService.validateRecipet(cipher.get());
            return ResponseEntity.ok(isValid);
        }
        return ResponseEntity.ok(false);
    }

    @PostMapping()
    public void showReport(@Valid @RequestBody Recipet recipet, HttpServletResponse response)
            throws NoSuchAlgorithmException, IOException {
        Recipet recipetValid = recipetService.generateValidateRecipet(recipet);
        String qrData = recipetService.generateValidateQRData(recipetValid);
        byte[] bytes = jasperService.exportPdf(recipetValid, qrData);
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-disposition", "inline; filename=RECIPET.pdf");
        response.getOutputStream().write(bytes);
    }

}
