package ro.itschool.springdatademo.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "DOCUMENTS")
public class Document {
    @Id
    @GeneratedValue
    private Integer documentId;
    private String name;
    private String content;
    private String owner;

    public Document() {
    }

    public Document(String name, String content, String owner) {
        this.name = name;
        this.content = content;
        this.owner = owner;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document that = (Document) o;

        return Objects.equals(this.content, that.content) &&
                Objects.equals(this.documentId, that.documentId) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, documentId, name, owner);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("content = " + content)
                .add("documentId = " + documentId)
                .add("name = " + name)
                .add("owner = " + owner)
                .toString();
    }
}
