package com.management.college.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "updownload")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Updownload {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;
 private String profilePicture;
 private long size;
 private byte [] content;
 
 
}