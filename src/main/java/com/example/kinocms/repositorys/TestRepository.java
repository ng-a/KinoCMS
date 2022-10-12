package com.example.kinocms.repositorys;

import com.example.kinocms.models.Test;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TestRepository extends CrudRepository<Test, Long> {
}
