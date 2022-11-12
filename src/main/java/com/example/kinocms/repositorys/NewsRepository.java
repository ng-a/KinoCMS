package com.example.kinocms.repositorys;

import com.example.kinocms.models.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Long> {
}
