package org.kidx.kidvoo.repository;

import java.util.List;

import org.kidx.kidvoo.model.VideoDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;  

@Repository
public interface VideoRepository extends CrudRepository<VideoDao, Integer>  
{
	public List<VideoDao> findByCategoryCode(String code);  
}  