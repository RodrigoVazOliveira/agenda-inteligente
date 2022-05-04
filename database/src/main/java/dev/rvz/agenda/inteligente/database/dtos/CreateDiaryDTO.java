package dev.rvz.agenda.inteligente.database.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import dev.rvz.agenda.inteligente.database.entities.*;
import dev.rvz.agenda.inteligente.database.helpers.ConvertEntityToString;

public class CreateDiaryDTO {

    private final String email;
    private final String subject;
    private final String description;
    private final String comments;
    private final String place;
    private final String category;

    @JsonCreator
    public CreateDiaryDTO(String email, String subject, String description, String comments, String place,
                          String category) {
        this.email = email;
        this.subject = subject;
        this.description = description;
        this.comments = comments;
        this.place = place;
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public String getComments() {
        return comments;
    }

    public String getPlace() {
        return place;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return ConvertEntityToString.run(this);
    }

    public Diary convertDTOToEntityDiary() {
        Contact contact = new Contact();
        contact.setEmail(new Email(this.email));

        Profile profile = new Profile();
        profile.setContact(contact);

        Category category = new Category();
        category.setName(this.category);

        Diary diary = new Diary();
        diary.setProfile(profile);
        diary.setCategory(category);
        diary.setSubject(subject);
        diary.setDescription(description);
        diary.setComments(comments);

        if (TypePlaceEnum.VIRTUAL.name().equals(this.place)) {
            diary.setPlace(TypePlaceEnum.VIRTUAL);
        } else {
            diary.setPlace(TypePlaceEnum.PRESENTIAL);
        }

        return diary;
    }
}