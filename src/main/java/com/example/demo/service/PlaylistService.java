package com.example.demo.service;

import com.example.demo.domain.Playlist;
import com.example.demo.interfaces.PlaylistDaoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistDaoInterface dao;

    public void salvar(Playlist playlist) {
        dao.save(playlist);
    }

    @Transactional(readOnly = true)
    public List<Playlist> recuperar() {
        return StreamSupport.stream(dao.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Playlist recuperarPorID(long id) {
        return dao.findById(id).get();
    }

    public void atualizar(Playlist playlist) {
        salvar(playlist);
    }

    public void excluir(long id) {
        dao.delete(dao.findById(id).get());
    }
}
