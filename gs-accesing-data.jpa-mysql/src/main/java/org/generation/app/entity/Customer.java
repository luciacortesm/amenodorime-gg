package org.generation.app.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Entity 
@Data
@Table(name="customer_data") //nombre de la tabla 
public class Customer implements Serializable{
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCustomer; //id_customer: snake case de base de datos
	//@Size (para tamñao del varchar) de la dependencia  javax.validation
	@Column(name="first_name") //pa dar nombre de columna
	private String firstName; //first_name
	@Column(name="last_name")
	private String lastName;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Role role;
//	@OneToMany Justo este OneToMany es el que no se recomienda por alguna extraña razón.*Buscar*
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//	private List<Order> orders;
	public Customer() {
		
	}
	/**
	 * @param idCustomer
	 * @param firstName
	 * @param lastName
	 * @param role
	 */
	public Customer(Long idCustomer, String firstName, String lastName) {
		this.idCustomer = idCustomer;
		this.firstName = firstName;
		this.lastName = lastName;
//		this.Role = role;
	}
	
}


