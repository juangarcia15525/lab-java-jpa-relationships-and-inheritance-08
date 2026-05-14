package com.ironhack.jpalab.task;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("BILLABLE")
public class BillableTask extends Task {

    private BigDecimal hourlyRate;

    public BigDecimal getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(BigDecimal r) { this.hourlyRate = r; }
}