package com.ironhack.jpalab.task;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("INTERNAL")
public class InternalTask extends Task {
    // Sin campos adicionales
}