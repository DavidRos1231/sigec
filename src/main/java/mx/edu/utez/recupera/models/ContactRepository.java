package mx.edu.utez.recupera.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query(value = "SELECT * FROM contact WHERE user_id = :user_id ", nativeQuery = true)
    List<Contact> getContactsByUser(@Param("user_id") Long id);

}
