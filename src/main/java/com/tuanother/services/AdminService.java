package com.tuanother.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.tuanother.models.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface AdminService  {

	void deleteAll();

	void deleteAll(Iterable<? extends Admin> entities);

	void delete(Admin entity);

	<S extends Admin> List<S> findAll(Example<S> example, Sort sort);

	void deleteById(String id);

	long count();

	<S extends Admin> List<S> findAll(Example<S> example);

	<S extends Admin> boolean exists(Example<S> example);

	<S extends Admin> long count(Example<S> example);

	Admin getOne(String id);

	void deleteAllInBatch();

	<S extends Admin> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Admin> entities);

	boolean existsById(String id);
	<S extends Admin> S saveAndFlush(S entity);

	void flush();

	Optional<Admin> findById(String id);

	<S extends Admin> List<S> saveAll(Iterable<S> entities);

	List<Admin> findAllById(Iterable<String> ids);

	List<Admin> findAll(Sort sort);

	List<Admin> findAll();

	Page<Admin> findAll(Pageable pageable);

	<S extends Admin> Optional<S> findOne(Example<S> example);

	Admin  save(Admin admin);
	
	boolean checkLogin(String username, String password);
	boolean checkAccount(String username,String password);



}
