package practice.service.impl;

import practice.dao.AuthorDao;
import practice.lib.Inject;
import practice.lib.Service;
import practice.model.Author;
import practice.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Inject
    private AuthorDao authorDao;

    @Override
    public Author add(Author author) {
        return authorDao.add(author);
    }
}
