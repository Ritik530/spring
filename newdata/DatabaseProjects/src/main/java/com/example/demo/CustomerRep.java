package com.example.demo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

public interface CustomerRep extends JpaRepository<Customer,Integer>{

	Optional<Customer> findByCid(int cid);

//	List<Customer> findByCid(int cid);

	

}
