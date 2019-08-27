package ro.itschool.springdatademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.springdatademo.repository.model.Document;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
    List<Document> findAllByOwner(String owner);

    Optional<Document> findFirstByOwnerOrderByDocumentIdDesc(String owner);

    List<Document> findAllByOwnerAndContentAndDocumentIdBetween(String owner, String content, int a, int b);
}
