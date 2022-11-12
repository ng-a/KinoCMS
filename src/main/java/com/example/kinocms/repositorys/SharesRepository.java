package com.example.kinocms.repositorys;

import com.example.kinocms.models.News;
import com.example.kinocms.models.Shares;
import org.springframework.data.repository.CrudRepository;

public interface SharesRepository extends CrudRepository<Shares, Long> {
}