package com.Mini_Projet_Java.Mini_Projet_Java.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.NoteElement;


@Repository
public interface NoteElementRepository extends JpaRepository<NoteElement, Long> {
	
}
