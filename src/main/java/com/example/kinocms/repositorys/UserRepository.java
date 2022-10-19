package com.example.kinocms.repositorys;

import com.example.kinocms.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {}
