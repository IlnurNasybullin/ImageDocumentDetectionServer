package org.example.app.entity;

import java.io.Serializable;
import java.util.Objects;

public class Document implements Serializable {

    private String classification;
    private String content;

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(classification, document.classification) && Objects.equals(content, document.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classification, content);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Document{");
        sb.append("classification='").append(classification).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
