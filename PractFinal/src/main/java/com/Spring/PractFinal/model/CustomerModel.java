package com.Spring.PractFinal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("CUSTOMERS")
public class CustomerModel {
  private @Column("CUSTOMER_ID") @Id Long customerId;
	private @Column("CUSTOMER_NAME") String customerName;
	private @Column("CONTRASENA") String password;
}

