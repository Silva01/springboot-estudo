package com.example.demo.interfaces;


import com.example.demo.domain.Musica;
import com.example.demo.domain.Playlist;
import org.springframework.data.repository.CrudRepository;


public interface PlaylistDaoInterface extends CrudRepository<Playlist, Long> {

}
