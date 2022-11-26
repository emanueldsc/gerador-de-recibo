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

        this.generateQrCodeData(recipet);

        return recipet;
    }

    public Boolean validateRecipet(String cifer) throws NoSuchAlgorithmException {

        var listCifer = cifer.split("\\.");
        String[] listDataDecode = new String[listCifer.length];
        for (var i = 0; i < listDataDecode.length; i++) {
            var decodeCifer = Base64.getMimeDecoder().decode(listCifer[i]);
            listDataDecode[i] = new String(decodeCifer);
            System.out.println(listDataDecode[i]);
        }
        Recipet recipet = new Recipet();
        recipet.setNumber(Integer.parseInt(listDataDecode[0]));
        recipet.setValue(Double.parseDouble(listDataDecode[1]));
        recipet.setCreditor(listDataDecode[2]);
        recipet.setDebtor(listDataDecode[3]);
        recipet.setReferent(listDataDecode[4]);
        recipet.setRgCpf(listDataDecode[5]);
        String keyToTest = this.generateKey(recipet);
        Boolean isKeyValid = keyToTest.equals(listDataDecode[listDataDecode.length -1]);
        return isKeyValid;
    }

    private String generateQrCodeData(Recipet recipet) {
        Map<String, String> map = new HashMap<>();

        String number = Base64.getEncoder().encodeToString(recipet.getNumber().toString().getBytes());
        String value = Base64.getEncoder().encodeToString(recipet.getValue().toString().getBytes());
        String creditor = Base64.getEncoder().encodeToString(recipet.getCreditor().getBytes());
        String debtor = Base64.getEncoder().encodeToString(recipet.getDebtor().getBytes());
        String referent = Base64.getEncoder().encodeToString(recipet.getReferent().getBytes());
        String rgCpf = Base64.getEncoder().encodeToString(recipet.getRgCpf().getBytes());
        String key = Base64.getEncoder().encodeToString(recipet.getKey().getBytes());

        map.put("number", number);
        map.put("value", value);
        map.put("creditor", creditor);
        map.put("debtor", debtor);
        map.put("referent", referent);
        map.put("rgCpf", rgCpf);
        map.put("key", key);

        String template = "${number}.${value}.${creditor}.${debtor}.${referent}.${rgCpf}.${key}";
        StringSubstitutor sub = new StringSubstitutor(map);
        String qrData = sub.replace(template);
        System.out.println("======================================================");
        System.out.println(qrData);

        return "";
    }

    private String generateKey(Recipet recipet) throws NoSuchAlgorithmException {
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
        return this.getMD5Hash(resolvedTemplateKey, "sha256");
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
