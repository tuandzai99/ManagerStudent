package com.tuanother.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tuanother.models.MonHoc;
@Repository
public interface MonHocRepository  extends CrudRepository<MonHoc, Integer>{

}
