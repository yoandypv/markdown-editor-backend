package com.burea.markdowneditor.web;

import com.burea.markdowneditor.entity.Markdown;
import com.burea.markdowneditor.repository.MarkdownRepository;
import com.burea.markdowneditor.service.MarkdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jhon Quiufeng on 13/12/18.
 */
@Controller
@RequestMapping(value="md-api")
public class MarkdownResource {

    @Autowired
    MarkdownService markdownService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Markdown>> getMarkdownList() {

        List<Markdown> markdowns = markdownService.findAll();

        if (!(markdowns.isEmpty()))
            return new ResponseEntity<List<Markdown>>(markdowns, HttpStatus.OK);
        else
            return new ResponseEntity<List<Markdown>>(new ArrayList<Markdown>(), HttpStatus.NO_CONTENT);

    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Markdown> saveMarkdownDocument(@RequestBody String markdownText) {

        Markdown md = new Markdown(markdownText, Instant.now());

        if (markdownText != null &&  !"".equals(markdownText)) {
            md = markdownService.save(md);
            if (md.getId() > 0)
                return new ResponseEntity<Markdown>( md, HttpStatus.CREATED)  ;
            return new ResponseEntity<Markdown>(HttpStatus.BAD_REQUEST);
        }
        else
            return new ResponseEntity<Markdown>(HttpStatus.NOT_ACCEPTABLE);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> removeMarkdown(@PathVariable("id") Long id) {

        boolean res = false;

        if (id > 0)
           res = markdownService.delete(id);
        else
            return new ResponseEntity<String>("El valor del Id debe ser superior a 0", HttpStatus.NOT_ACCEPTABLE);

         if (res)
              return new ResponseEntity<String>(HttpStatus.NO_CONTENT);

          return new ResponseEntity<String>("Documento markdown no encontrado", HttpStatus.NOT_FOUND);

    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Markdown> updateMarkdown(@PathVariable("id") Long id, @RequestBody String markdownUpdated) {

        if (id > 0){
              Markdown mdUpdated = new Markdown(markdownUpdated,Instant.now());
              Markdown result = markdownService.update(id, mdUpdated);

              if (result == null)
                 return new ResponseEntity<Markdown>(HttpStatus.BAD_REQUEST);
               return new ResponseEntity<Markdown>(result,HttpStatus.OK);

        }
        else
            return new ResponseEntity<Markdown>(HttpStatus.NOT_ACCEPTABLE);

    }



}
