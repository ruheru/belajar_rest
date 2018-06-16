package com.learn.restful.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="books")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"createdAt", "updatedAt"},allowGetters=true)//digunakan agar data pada variable tersebut tidak bisa dimasukan secara manual.
public class Buku  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String titleBook;
	
	@NotBlank
	private String namaPengarang;

	@NotBlank
	private	int statusPinjam;

	@NotBlank
	private String namaPeminjam;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitleBook() {
		return titleBook;
	}

	public void setTitleBook(String titleBook) {
		this.titleBook = titleBook;
	}

	public String getNamaPengarang() {
		return namaPengarang;
	}

	public void setNamaPengarang(String namaPengarang) {
		this.namaPengarang = namaPengarang;
	}

	public int getStatusPinjam() {
		return statusPinjam;
	}

	public void setStatusPinjam(int statusPinjam) {
		this.statusPinjam = statusPinjam;
	}

	public String getNamaPeminjam() {
		return namaPeminjam;
	}

	public void setNamaPeminjam(String namaPeminjam) {
		this.namaPeminjam = namaPeminjam;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
