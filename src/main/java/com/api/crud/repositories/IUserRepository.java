package com.api.crud.repositories;

import com.api.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*Hcaer consultas, hacer las query*/
@Repository
public interface IUserRepository extends JpaRepository <UserModel, Long> {

}
