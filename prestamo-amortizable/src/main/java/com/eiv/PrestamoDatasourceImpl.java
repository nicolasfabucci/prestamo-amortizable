package com.eiv;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrestamoDatasourceImpl implements PrestamoDatasource {

    private Map<Long, List<PrestamoCuota>> prestamos;
    
    public PrestamoDatasourceImpl() {
        prestamos = new HashMap<>();
        
    }
    

    @Override
    public List<PrestamoCuota> armarPrestamoAmortizable(BigDecimal capital, Integer cantidadCuotas, BigDecimal tna) {
        return null;
    }
}
