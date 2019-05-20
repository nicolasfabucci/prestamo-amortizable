package com.eiv;

import java.math.BigDecimal;
import java.util.List;

public interface PrestamoDatasource {

    public List<PrestamoCuota> armarPrestamoAmortizable(BigDecimal capital, Integer cantidadCuotas,
            BigDecimal tna);
}
