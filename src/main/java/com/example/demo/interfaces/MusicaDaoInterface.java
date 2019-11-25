package com.example.demo.interfaces;

import com.example.demo.domain.Musica;
import org.springframework.data.repository.CrudRepository;


public interface MusicaDaoInterface extends CrudRepository<Musica, Long> {

}
