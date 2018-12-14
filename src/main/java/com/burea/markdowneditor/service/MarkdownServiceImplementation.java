package com.burea.markdowneditor.service;

import com.burea.markdowneditor.entity.Markdown;
import com.burea.markdowneditor.repository.MarkdownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Jhon Quiufeng on 13/12/18.
 */

@Service
public class MarkdownServiceImplementation implements  MarkdownService {

    @Autowired
    private MarkdownRepository markdownRepository;

    @Override
    public Markdown save(Markdown markdown) {
        return markdownRepository.save(markdown);
    }

    @Override
    public List<Markdown> findAll() {
        return (List<Markdown>) markdownRepository.findAll();
    }

    @Override
    public boolean delete(Long id) {
         Optional<Markdown> md = this.findAll().stream().filter(markdown -> markdown.getId() == id).findFirst();

        if (md.isPresent()){
            markdownRepository.delete(md.get());
            return true;
        }
        return  false;
    }

    @Override
    public Markdown update(Long id, Markdown markdown) {
        Optional<Markdown> md = this.findAll().stream().filter(current -> current.getId() == id).findFirst();

        Markdown updated = null;

        if (md.isPresent()){
            markdown.setId(md.get().getId());
            updated = markdownRepository.save(markdown);
        }

        return updated;
    }


}
