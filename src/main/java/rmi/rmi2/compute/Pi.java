package rmi.rmi2.compute;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Author: Daniel
 * Date: 20.11.13.
 */
public class Pi implements Task<BigDecimal>, Serializable {
    private final int digits;

    public Pi(int digits) {
        this.digits = digits;
    }

    @Override
    public BigDecimal execute() {
        return computePi(digits);
    }

    private BigDecimal computePi(int digits) {
        return new BigDecimal(3.14);
    }
}
