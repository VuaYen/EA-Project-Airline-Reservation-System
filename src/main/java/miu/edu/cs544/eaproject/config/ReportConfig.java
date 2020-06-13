package miu.edu.cs544.eaproject.config;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

public class ReportConfig extends JRDefaultScriptlet {

    @Override
    public void afterReportInit() throws JRScriptletException {
      //  this.setVariableValue("orderNumber", "Set value for variable");

      //  String Variable_1 = (String)this.getVariableValue("orderNumber");
      //  System.out.println(Variable_1);
    }

}
