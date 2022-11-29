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

    public byte[] exportPdf(Recipet recipet) {
        this.setParameters(recipet);
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

    private void setParameters(Recipet recipet) {
        this.addParams("NUMBER", recipet.getNumber().toString());
        this.addParams("VALUE", recipet.getValue().toString());
        this.addParams("CREDITOR", recipet.getCreditor());
        this.addParams("DEBTOR", recipet.getDebtor());
        this.addParams("REFERENT", recipet.getReferent());
        this.addParams("PLACE", recipet.getPlace());
        this.addParams("RGCPF", recipet.getRgCpf());
        this.addParams("KEY", recipet.getKey());
    }

}
