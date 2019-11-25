package com.example.demo.service;

import com.example.demo.domain.Musica;
import com.example.demo.interfaces.MusicaDaoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MusicaService {
    @Autowired
    private MusicaDaoInterface dao;

    public void salvar(Musica musica) {
        dao.save(musica);
    }

    @Transactional(readOnly = true)
    public List<Musica> recuperarPorPlaylist(long playlistId) {
        return StreamSupport.stream(dao.findAll().spliterator(), false)
                .filter(d -> d.getPlaylist().getId() == playlistId)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Musica recuperarPorPlaylistIdEMusicaId(long playlistId, long musicaId) {
        return StreamSupport.stream(dao.findAll().spliterator(), false)
                .filter(d -> d.getPlaylist().getId() == playlistId && d.getId() == musicaId)
                .collect(Collectors.toList()).get(0);
    }

    public void atualizar(Musica musica) {
        salvar(musica);
    }

    public void excluir(long musicaId) {
        dao.delete(dao.findById(musicaId).get());
    }
}
