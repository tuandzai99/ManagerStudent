package com.tuanother.services.impls;

import com.tuanother.models.Admin;
import com.tuanother.models.Role;
import com.tuanother.repositorys.AdminRepository;
import com.tuanother.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;


    @Override
    public  Admin  save(Admin admin) {
        Admin admin1=new Admin();
        admin1.setUsername(admin.getUsername());
        admin1.setPassword(passwordGenerat(admin.getPassword()));
        return adminRepository.save(admin1);
    }

    @Override
    public <S extends Admin> Optional<S> findOne(Example<S> example) {
        return adminRepository.findOne(example);
    }

    @Override
    public Page<Admin> findAll(Pageable pageable) {
        return adminRepository.findAll(pageable);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public List<Admin> findAll(Sort sort) {
        return adminRepository.findAll(sort);
    }

    @Override
    public List<Admin> findAllById(Iterable<String> ids) {
        return adminRepository.findAllById(ids);
    }

    @Override
    public <S extends Admin> List<S> saveAll(Iterable<S> entities) {
        return adminRepository.saveAll(entities);
    }

    @Override
    public Optional<Admin> findById(String id) {
        return adminRepository.findById(id);
    }

    @Override
    public void flush() {
        adminRepository.flush();
    }

    @Override
    public <S extends Admin> S saveAndFlush(S entity) {
        return adminRepository.saveAndFlush(entity);
    }

    @Override
    public boolean existsById(String id) {
        return adminRepository.existsById(id);
    }

    @Override
    public void deleteInBatch(Iterable<Admin> entities) {
        adminRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends Admin> Page<S> findAll(Example<S> example, Pageable pageable) {
        return adminRepository.findAll(example, pageable);
    }

    @Override
    public void deleteAllInBatch() {
        adminRepository.deleteAllInBatch();
    }

    @Override
    public Admin getOne(String id) {
        return adminRepository.getOne(id);
    }

    @Override
    public <S extends Admin> long count(Example<S> example) {
        return adminRepository.count(example);
    }

    @Override
    public <S extends Admin> boolean exists(Example<S> example) {
        return adminRepository.exists(example);
    }

    @Override
    public <S extends Admin> List<S> findAll(Example<S> example) {
        return adminRepository.findAll(example);
    }

    @Override
    public long count() {
        return adminRepository.count();
    }

    @Override
    public void deleteById(String id) {
        adminRepository.deleteById(id);
    }

    @Override
    public <S extends Admin> List<S> findAll(Example<S> example, Sort sort) {
        return adminRepository.findAll(example, sort);
    }

    @Override
    public void delete(Admin entity) {
        adminRepository.delete(entity);
    }

    @Override
    public void deleteAll(Iterable<? extends Admin> entities) {
        adminRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        adminRepository.deleteAll();
    }


    @Override
    public boolean checkLogin(String username, String password) {
        Optional<Admin> optional=findById(username);
        if(optional.isPresent()&&optional.get().getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAccount(String username, String password) {
        Optional<Admin> admin=findById(username);
        if(admin.isPresent() && admin.get().getPassword().equals(password)) {
            return true;
        }
        return false;
    }
    public String passwordGenerat(String password){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

        return encoder.encode(password);

    }
}
