package com.bilalkose.springmongodbexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("bill")
public class Bill {
    @Id
    private String id;
    @Field("name")
    @Indexed(unique = true)
    private String billName;
    @Field("category")
    private BillCategory billCategory;
    @Field("amount")
    private BigDecimal billAmount;
}

