/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorws_client_application;

import webservice.NegativeNumberException_Exception;

/**
 *
 * @author Jelle
 */
public class CalculatorWS_Client_Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int i = 3;
            int j = 4;
            int result = add(i, j);
            System.out.println("Result = " + result);
        }
        catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }

    private static int add(int arg0, int arg1) throws NegativeNumberException_Exception {
        webservice.WebCalculatorService service = new webservice.WebCalculatorService();
        webservice.WebCalculator port = service.getWebCalculatorPort();
        return port.add(arg0, arg1);
    }

}
