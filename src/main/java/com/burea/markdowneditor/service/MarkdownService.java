package com.burea.markdowneditor.service;

import com.burea.markdowneditor.entity.Markdown;

import java.util.List;

/**
 * Created by Jhon Quiufeng on 13/12/18.
 */
public interface MarkdownService  {
    Markdown save(Markdown markdown);
    List<Markdown> findAll();
    boolean delete(Long id);
    Markdown update(Long id, Markdown markdown);

}
