package mx.edu.utez.recupera.controllers;

import mx.edu.utez.recupera.models.Contact;
import mx.edu.utez.recupera.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins ={"*"})
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/")
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact){
        return new ResponseEntity<>(this.contactService.saveContact(contact), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable Long id){
        return new ResponseEntity<>(this.contactService.getContact(id), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getContactsByUserId(@PathVariable Long id){
        return new ResponseEntity<>(this.contactService.getContactsByUserId(id), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact){
        return new ResponseEntity<>(this.contactService.updateContact(contact), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteContact(@PathVariable Long id){
        return new ResponseEntity<>(this.contactService.deleteContact(id), HttpStatus.OK);
    }


}
