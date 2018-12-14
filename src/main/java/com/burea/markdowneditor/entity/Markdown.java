package com.burea.markdowneditor.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

/**
 * Created by Jhon Quiufeng on 13/12/18.
 */

@Entity
@Table(name = "Markdown")
public class Markdown {

    @Id
    @Column(name =  "mdid",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String mddocument;

    private Instant lastmodify;

    public Markdown() {
    }

    public Markdown(String mddocument, Instant lastmodify) {
        this.mddocument = mddocument;
        this.lastmodify = lastmodify;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMddocument() {
        return mddocument;
    }

    public void setMddocument(String mddocument) {
        this.mddocument = mddocument;
    }

    public Instant getLastmodify() {
        return lastmodify;
    }

    public void setLastmodify(Instant lastmodify) {
        this.lastmodify = lastmodify;
    }

    @Override
    public String toString() {
        return "Markdown{" +
                "id=" + id +
                ", mddocument='" + mddocument + '\'' +
                ", lastmodify=" + lastmodify +
                '}';
    }
}
