package com.jins.db.Todoapp.service;

import com.jins.db.Todoapp.dto.CreateTacheRequest;
import com.jins.db.Todoapp.model.Tache;
import com.jins.db.Todoapp.model.User;
import com.jins.db.Todoapp.repository.TacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TacheService {
    private final UserService userService;
    private final TacheRepository tacheRepository;

    public Tache createTache(CreateTacheRequest request) {

        User user = userService.getConnectedUser();

        Tache tache = setTacheAttributes(request, user);

        return tacheRepository.save(tache);
    }

    public List<Tache> getall(){
        User user = userService.getConnectedUser();
        return tacheRepository.findByUserId(user.getId());
    }

    public Tache updateTache(CreateTacheRequest request, long id) {
        Tache tache = tacheRepository.findById(id).orElse(null);
        User user = userService.getConnectedUser();
        if (tache == null) {
            return null;
        }
        if (tache.getUser().getId() != user.getId()) {
            return null;
        }
        tache = setTacheAttributes(request, user);
        tache.setId(id);
        tacheRepository.save(tache);

        return tache;
    }

    public Tache getTache(long id) {
        User user = userService.getConnectedUser();
        Tache tache = tacheRepository.findById(id).orElse(null);
        if (tache == null) return null;
        if (tache.getUser().getId() != user.getId()) return null;

        return tache;
    }

    public Tache deleteTache(long id) {
        Tache tache = tacheRepository.findById(id).orElse(null);
        User user = userService.getConnectedUser();
        if (tache == null) {
            return null;
        }
        if (tache.getUser().getId() != user.getId()) {
            return null;
        }

        tacheRepository.delete(tache);

        return tache;
    }

    private Tache setTacheAttributes(CreateTacheRequest request, User user) {
        Tache tache = new Tache();
        tache.setTitre(request.getTitre());
        tache.setContenu(request.getContenu());
        tache.setEtat(request.getEtat());
        tache.setPriorite(request.getPriorite());
        tache.setDate(request.getDate());
        tache.setUser(user);
        return tache;
    }

}
