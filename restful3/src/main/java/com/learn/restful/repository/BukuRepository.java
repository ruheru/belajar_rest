package com.learn.restful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.restful.model.Buku;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Long>{
	List<Buku> findByStatusPinjam(int statusPinjam);
	List<Buku> findByTitleBook(String titleBook);

}
