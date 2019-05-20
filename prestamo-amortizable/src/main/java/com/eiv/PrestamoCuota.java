package com.eiv;

import java.math.BigDecimal;

public class PrestamoCuota {

    private BigDecimal cuota;
    private BigDecimal valorCuota;
    private BigDecimal capital;
    private BigDecimal interes;
    private BigDecimal saldo;
    
    public PrestamoCuota() {
        super();
        // TODO Auto-generated constructor stub
    }

    public PrestamoCuota(BigDecimal cuota, BigDecimal valorCuota, BigDecimal capital, 
            BigDecimal interes, BigDecimal saldo) {
        super();
        this.cuota = cuota;
        this.valorCuota = valorCuota;
        this.capital = capital;
        this.interes = interes;
        this.saldo = saldo;
    }

    public BigDecimal getCuota() {
        return cuota;
    }

    public void setCuota(BigDecimal cuota) {
        this.cuota = cuota;
    }

    public BigDecimal getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(BigDecimal valorCuota) {
        this.valorCuota = valorCuota;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public BigDecimal getInteres() {
        return interes;
    }

    public void setInteres(BigDecimal interes) {
        this.interes = interes;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cuota == null) ? 0 : cuota.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PrestamoCuota other = (PrestamoCuota) obj;
        if (cuota == null) {
            if (other.cuota != null)
                return false;
        } else if (!cuota.equals(other.cuota))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\n Cuota=" + cuota + "     ValorCuota=" + valorCuota + "      Capital=" + capital + 
                "       Interes=" + interes + "     Saldo=" + saldo;
    }

    
    
    
}
