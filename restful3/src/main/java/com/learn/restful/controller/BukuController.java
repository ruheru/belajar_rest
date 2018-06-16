package com.learn.restful.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.restful.model.Buku;
import com.learn.restful.repository.BukuRepository;

@RestController
@RequestMapping("/buku")
public class BukuController {

	@Autowired 
	BukuRepository bukuRepository;
	
	@GetMapping("/")
	public List<Buku> getAll(){
		return bukuRepository.findAll();
	}
	
	@PostMapping("/")
	public Buku addBuku(@Valid @RequestBody Buku buku) {
			return bukuRepository.save(buku);
	}
	
	//editneh
	@PutMapping("/{id}")
	public ResponseEntity<Buku> updateBuku(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Buku detailBuku) {
		Buku buku = bukuRepository.findOne(id);
		
		if(null == buku) {
			return ResponseEntity.notFound().build();
		}
		buku.setTitleBook(detailBuku.getTitleBook());
		buku.setNamaPengarang(detailBuku.getNamaPengarang());
		buku.setNamaPeminjam(detailBuku.getNamaPeminjam());
		buku.setStatusPinjam(detailBuku.getStatusPinjam());
		Buku updatedBuku = bukuRepository.save(buku);
		return ResponseEntity.ok(updatedBuku);
	}
	
	@DeleteMapping("/{id}")
	public String deleteBuku(@PathVariable (value="id") Long id) {
		Buku buku = bukuRepository.findOne(id);
		String result = "";
		if(null == buku) {
			result = "id "+id+" tidak ditemukan";
			return result;
		}
		
		bukuRepository.delete(id);
		result = "buku dengan ID : "+id+" Berhasil dihapus";
		return result;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Buku> getBukuById(@PathVariable (value = "id") Long id){
		Buku buku = bukuRepository.findOne(id);
		
		if(null == buku)
		return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(buku);
	}
	
	@GetMapping("/sortbuku")
	public List<Buku> sortBuku(@RequestParam(value="title") String titleBook){
		return bukuRepository.findByTitleBook(titleBook);
	}
	
	@GetMapping("/sortstatus/{statusPeminjaman}")
	public List<Buku> sortStatus(@PathVariable(value="statusPeminjaman") int statusPeminjaman){
		return bukuRepository.findByStatusPinjam(statusPeminjaman);
	}
}
