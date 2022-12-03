package io.github.emanueldsc.geradorderecibo.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.text.StringSubstitutor;
import org.springframework.stereotype.Service;

import io.github.emanueldsc.geradorderecibo.models.Recipet;

@Service
public class RecipetService {

    public Recipet generateValidateRecipet(Recipet recipet) throws NoSuchAlgorithmException {
        String key = this.generateKey(recipet);
        recipet.setKey(key);
        System.out.println(recipet.getKey());
        return recipet;
    }

    public String generateValidateQRData(Recipet recipet) throws NoSuchAlgorithmException {
        String qrData = this.generateQrCodeData(recipet);
        return qrData;
    }

    public Boolean validateRecipet(String cipher) throws NoSuchAlgorithmException {
        var listCipher = cipher.split("\\.");
        String[] listDataDecode = new String[listCipher.length];
        if (listDataDecode.length != 7)
            return false;
        for (var i = 0; i < listDataDecode.length; i++) {
            var decodeCipher = Base64.getMimeDecoder().decode(listCipher[i]);
            listDataDecode[i] = new String(decodeCipher);
        }
        Recipet recipet = new Recipet();
        recipet.setNumber(Integer.parseInt(listDataDecode[0]));
        recipet.setValue(Double.parseDouble(listDataDecode[1]));
        recipet.setCreditor(listDataDecode[2]);
        recipet.setDebtor(listDataDecode[3]);
        recipet.setReferent(listDataDecode[4]);
        recipet.setRgCpf(listDataDecode[5]);
        String keyToTest = this.generateKey(recipet);
        Boolean isKeyValid = keyToTest.equals(listDataDecode[listDataDecode.length - 1]);
        return isKeyValid;
    }

    private String generateQrCodeData(Recipet recipet) throws NoSuchAlgorithmException {
        String qrData = this.getTemplateWithCipherValues(recipet);
        String newKay = this.generateKey(recipet);
        String key = Base64.getEncoder().encodeToString(newKay.getBytes());
        qrData = qrData.concat("." + key);
        return qrData;
    }

    private String generateKey(Recipet recipet) throws NoSuchAlgorithmException {
        String raw = this.getTemplateWithCipherValues(recipet);
        if (raw.isEmpty())
            return null;
        return this.getMD5Hash(raw, "sha256");
    }

    private String getTemplateWithCipherValues(Recipet recipet) throws NoSuchAlgorithmException {
        Map<String, String> mapValues = new HashMap<>();
        mapValues.put("number", getMD5Hash(recipet.getNumber().toString()));
        mapValues.put("value", getMD5Hash(recipet.getValue().toString()));
        mapValues.put("creditor", getMD5Hash(recipet.getCreditor()));
        mapValues.put("debtor", getMD5Hash(recipet.getDebtor()));
        mapValues.put("referent", getMD5Hash(recipet.getReferent()));
        mapValues.put("rgCpf", getMD5Hash(recipet.getRgCpf()));
        String template = "${number}.${value}.${creditor}.${debtor}.${referent}.${rgCpf}";
        StringSubstitutor sub = new StringSubstitutor(mapValues);
        String resolvedTemplateKey = sub.replace(template);
        return resolvedTemplateKey;
    }

    private String getMD5Hash(String data) throws NoSuchAlgorithmException {
        return this.getMD5Hash(data, "md5");
    }

    private String getMD5Hash(String data, String alg) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance(alg);
        md5.update(data.getBytes(), 0, data.length());
        String md5Hash = new BigInteger(1, md5.digest()).toString(16);
        return md5Hash.toUpperCase();
    }

}
