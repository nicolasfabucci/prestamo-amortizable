package com.eiv;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    
    private PrestamoDatasource datasource;
    
    public final static BigDecimal DIAS_POR_ANO =  new BigDecimal("365");
    public final static BigDecimal DIAS_POR_MES =  new BigDecimal("30");
    public final static BigDecimal CIEN_PORCIENTO =  new BigDecimal("100");
    
    public static void main(String[] args) {
        App app = new App();
        app.run();        
    }
    
    public App() {
        datasource = new PrestamoDatasourceImpl();
    }
    
    private void run() {
       
       Scanner scanner = new Scanner(System.in);
       
       BigDecimal capital = BigDecimal.ZERO;
       BigDecimal cantidadCuotas =  BigDecimal.ZERO;
       BigDecimal tna = BigDecimal.ZERO;
       
       try {
           System.out.println("Ingresar Capital: ");
           capital = scanner.nextBigDecimal();
           
           System.out.println("Ingresar Cantidad de Cuotas: ");
           cantidadCuotas = scanner.nextBigDecimal();
           
           System.out.println("Ingresar la TNA: ");
           tna = scanner.nextBigDecimal();
           } catch (NumberFormatException | ArithmeticException e) {
               System.out.println(e.getMessage());
           } catch (Exception e) {
               System.out.println("Error");
         } finally {
             scanner.close();
         }
        
        BigDecimal razon =  tna.divide(DIAS_POR_ANO,4, RoundingMode.CEILING)
                            .multiply(DIAS_POR_MES.divide(CIEN_PORCIENTO,4, RoundingMode.CEILING));
        
        BigDecimal valorCuotaDividendo = capital.multiply(razon).multiply(
                                        razon.add(BigDecimal.ONE).pow(cantidadCuotas.intValue()));
        
        BigDecimal valorCuotaDivisor = razon.add(BigDecimal.ONE)
                                        .pow(cantidadCuotas.intValue())
                                        .subtract(BigDecimal.ONE);
        
        BigDecimal valorCuota = valorCuotaDividendo
                                .divide(valorCuotaDivisor,3, RoundingMode.CEILING);        
       
        BigDecimal interes;
        BigDecimal saldo = capital;
        
        List<PrestamoCuota> prestamoCuotas = new ArrayList<PrestamoCuota>();

        for (int i=1; i <= cantidadCuotas.intValue();i++)
        {
            interes = saldo.multiply(razon).setScale(3, RoundingMode.CEILING);
            capital = valorCuota.subtract(interes).setScale(3, RoundingMode.CEILING);
            saldo = saldo.subtract(capital).setScale(3, RoundingMode.CEILING);
            
            prestamoCuotas.add(new PrestamoCuota(BigDecimal.valueOf(i),valorCuota,capital,
                                                interes,saldo));
  
        }
        System.out.println(prestamoCuotas);
       // prestamoCuotas.forEach(PrestamoCuota -> System.out.println(prestamoCuotas));
        
        
    }

}
