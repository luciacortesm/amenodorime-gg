package org.generation.app.entity;

import java.io.Serializable;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@Table(name= "customer_order")
public class Order implements Serializable{
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderId;
	private String description;
	private String status;
	@ManyToOne(fetch=FetchType.LAZY)//Conexión con la llave foránea
	@JsonIgnoreProperties({"hibernateLazyInitializar","handler"})
	private Customer customer;
	//Conexión que crea la tabla intermedia.
	@ManyToMany(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializar","handler"})
	private List<Product> products;
}
