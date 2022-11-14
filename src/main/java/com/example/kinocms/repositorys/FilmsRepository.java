package com.example.kinocms.repositorys;

import com.example.kinocms.models.Films;
import org.springframework.data.repository.CrudRepository;

public interface FilmsRepository extends CrudRepository<Films, Long> {

}