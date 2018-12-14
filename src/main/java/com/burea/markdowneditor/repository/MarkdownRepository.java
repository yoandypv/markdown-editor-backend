package com.burea.markdowneditor.repository;

import com.burea.markdowneditor.entity.Markdown;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Created by Jhon Quiufeng on 13/12/18.
 */

public interface MarkdownRepository extends CrudRepository<Markdown, UUID> {
}
