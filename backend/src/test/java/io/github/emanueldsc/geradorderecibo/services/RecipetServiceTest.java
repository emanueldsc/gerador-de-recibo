package io.github.emanueldsc.geradorderecibo.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.emanueldsc.geradorderecibo.models.Recipet;

import static io.github.emanueldsc.geradorderecibo.common.RecipetConstants.RECIPET_VALID;
import static io.github.emanueldsc.geradorderecibo.common.RecipetConstants.RECIPET_INVALID;
import static io.github.emanueldsc.geradorderecibo.common.RecipetConstants.KEY_RECIPET_VALID;
import static io.github.emanueldsc.geradorderecibo.common.RecipetConstants.CIPHER_RECIPET_VALID;
import static io.github.emanueldsc.geradorderecibo.common.RecipetConstants.QRDATA;

import java.security.NoSuchAlgorithmException;

@SpringBootTest(classes = RecipetService.class)

public class RecipetServiceTest {

    @Autowired
    private RecipetService recipetService;

    @Test
    public void createKeyOfTheRecipet_validRecipet_recipedWithKey() {
        try {
            Recipet sut = recipetService.generateValidateRecipet(RECIPET_VALID);
            Assertions.assertThat(sut.getKey()).isEqualTo(KEY_RECIPET_VALID);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createKeyOfTheRecipet_invalidRecipet_recipedWithKey() {
        Assertions
                .assertThatThrownBy(() -> recipetService.generateValidateRecipet(RECIPET_INVALID))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void createQrData_validRecipet_stringQrData() throws NoSuchAlgorithmException {
        String sut = recipetService.generateValidateQRData(RECIPET_VALID);
        Assertions.assertThat(sut).isEqualTo(QRDATA);
    }

    @Test
    public void validateRecipet_whenRecipedValid_boolean() throws NoSuchAlgorithmException {
        Assertions.assertThat(recipetService.validateRecipet(CIPHER_RECIPET_VALID)).isEqualTo(true);
    }

    @Test
    public void validateRecipet_whenRecipedInvalid_boolean()throws NoSuchAlgorithmException {
        Assertions.assertThat(recipetService.validateRecipet("asdlkasjdl")).isEqualTo(false);
    }
    
    @Test
    public void validateRecipet_whenRecipedEmpty_boolean()throws NoSuchAlgorithmException {
        Assertions.assertThat(recipetService.validateRecipet("")).isEqualTo(false);
    }

}
