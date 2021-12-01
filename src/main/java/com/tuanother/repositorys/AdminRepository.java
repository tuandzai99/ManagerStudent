package com.tuanother.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tuanother.models.Admin;
@Repository
public interface AdminRepository  extends JpaRepository<Admin, String>{
	@Query("SELECT sv FROM Admin sv  WHERE sv.username = ?1")
	Admin findByUsername(String s);

}
