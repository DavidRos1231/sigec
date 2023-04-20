package mx.edu.utez.recupera.services;

import mx.edu.utez.recupera.models.Contact;
import mx.edu.utez.recupera.models.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Transactional(rollbackFor = {Exception.class})
    public Contact saveContact(Contact contact){
        return this.contactRepository.save(contact);
    }
    @Transactional(rollbackFor = {Exception.class})
    public Contact updateContact(Contact contact){
        if(this.contactRepository.existsById(contact.getId())){
            return this.contactRepository.save(contact);
        }else {
            return null;
        }
    }


    @Transactional(readOnly = true)
    public Contact getContact(Long id){
        return this.contactRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Contact> getContactsByUserId(Long id){
        return this.contactRepository.getContactsByUser(id);
    }

    @Transactional(rollbackFor = {Exception.class})
    public boolean deleteContact(Long id){
        try {
            this.contactRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
