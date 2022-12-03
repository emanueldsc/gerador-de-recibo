package io.github.emanueldsc.geradorderecibo.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import io.github.emanueldsc.geradorderecibo.models.Recipet;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class JasperService {

    private static final String REPORT_PATH = "classpath:reports/";
    private static final String REPORT_SUFIX = ".jasper";

    private Map<String, Object> params = new HashMap<>();

    public void addParams(String key, Object value) {
        this.params.put(key, value);
    }

    public byte[] exportPdf(Recipet recipet, String qrData) {
        this.setParameters(recipet, qrData);
        byte[] bytes = null;
        try {
            File file = ResourceUtils.getFile(REPORT_PATH + "RECIPET" + REPORT_SUFIX);
            JasperPrint print = JasperFillManager.fillReport(file.getAbsolutePath(), params, new JREmptyDataSource());
            bytes = JasperExportManager.exportReportToPdf(print);
        } catch (JRException | FileNotFoundException fe) {
            fe.printStackTrace();
        }
        return bytes;
    }

    private static final String[] monthWord = {
        "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", 
        "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
    };

    private void setParameters(Recipet recipet, String qrcode) {

        String[] spliDate = recipet.getDate().split("-");

        String day = spliDate[2];
        String month = monthWord[Integer.parseInt(spliDate[1]) -1];
        String year = spliDate[0];

        this.addParams("NUMBER", recipet.getNumber().toString());
        this.addParams("VALUE", "R$: " + recipet.getValue().toString());
        this.addParams("CREDITOR", recipet.getCreditor());
        this.addParams("DEBTOR", recipet.getDebtor());
        this.addParams("REFERENT", recipet.getReferent());
        this.addParams("PLACE", recipet.getPlace());
        this.addParams("RGCPF", recipet.getRgCpf());
        this.addParams("KEY", recipet.getKey());
        this.addParams("VALUE_TO_WORD", valueToWord(recipet.getValue()));
        this.addParams("CITYUF", recipet.getCityUf());
        this.addParams("YEAR", year);
        this.addParams("MONTH", month);
        this.addParams("DAY", day);
        this.addParams("QRCODE", qrcode);
    }

    private String valueToWord(Double value) {
        return value.toString();
    }

}
