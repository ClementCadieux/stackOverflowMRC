package com.fdmgroup.somrc;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactController {
    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public String redirect() {
        return "redirect:/update-contact/1";
    }

    @GetMapping("/update-contact/{id}")
    public String toUpdateContact(@PathVariable long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Contact> contactOps = contactService.readById(id);
        if (contactOps.isPresent()) {
            model.addAttribute("contact", contactOps.get());
            model.addAttribute("newContactInfo", new ContactInfo());
            model.addAttribute("infoTypes", InfoType.values());
            return "update-contact";
        }
        String message = "Contact doesn't exist";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/";
    }

    @PostMapping("/update-contact-info")
    public String updateContact(Contact contact) {
        contact.getInfo().forEach(cI -> cI.setContact(contact));
        contactService.updateContact(contact.getId(), contact);
        return "redirect:/update-contact/" + contact.getId();
    }

    @PostMapping("/add-new-contact-info/{id}")
    public String makeNewContactInfo(ContactInfo contactInfo, @PathVariable long id, Model model,
            RedirectAttributes redirectAttributes) {
        // This print shows the value of contactInfo.id before I modify it. At this
        // point, it is equal to the @PathVariable valuye above and I don't understand
        // why
        System.out.println(contactInfo.getId());
        contactInfo.setId(0);
        Optional<Contact> optRes = contactService.readById(id);
        if (optRes.isPresent()) {
            Contact contact = optRes.get();
            contact.getInfo().clear();
            contact.getInfo().add(contactInfo);
            return this.updateContact(contact);
        }
        String message = "Contact doesn't exist";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/";
    }
}
