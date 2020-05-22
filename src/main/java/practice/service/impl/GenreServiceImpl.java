package practice.service.impl;

import practice.dao.GenreDao;
import practice.lib.Inject;
import practice.lib.Service;
import practice.model.Genre;
import practice.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {
    @Inject
    private GenreDao genreDao;

    @Override
    public Genre add(Genre genre) {
        return genreDao.add(genre);
    }
}
