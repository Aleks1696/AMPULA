package com.service.core.domain;




import com.api.request.types.DoctorsTypes;
import com.service.core.dao.CardRepository;
import com.service.core.dao.DoctorRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/****
 * Врач:
 * 1.Имя.
 * 2.Фамилия
 * 3.Какой врач(Хирург,кардиолог и тд)
 *
 * 20.12.2018 - by Yaroslav Halindzovskiy
 *
 * Aleksandr Borodavka 08.01.2019
 * добавил анотацию @Enumarated(EnumType.STRING)
 * */
@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    /*Нужна для того чтобы в базе сохранялись енами в виде
     строки (если доктор например SURGEON (№1 в списке енамов) то по умолчанию он сохранится в базе как 1.
     С этой анотацией в базе будет хранится не номер, а стока SURGEON.*/
    @Enumerated(EnumType.STRING)
    private DoctorsTypes doctorsTypes;


    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Card.class)
    @JoinTable(name = "Doctor_Card",
            joinColumns = @JoinColumn(name = "doctors_ref_id", referencedColumnName = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "card_ref_id", referencedColumnName = "card_id"))
    private List<Card> cards = new ArrayList<Card>();

    public Doctor() {
    }

    public Doctor(String name, String surname, DoctorsTypes doctorsTypes, List<Card> patients) {
        this.name = name;
        this.surname = surname;
        this.doctorsTypes = doctorsTypes;
        this.cards = patients;
    }

    //костылизм
    //если нужно удалить доктора этот метод удаляет из каждой карты данного доктора
    public void removeDoctor(DoctorRepository doctorRepository, CardRepository cardRepository){
        for (Card card : cards){
            card.getDoctors().remove(this);
            cardRepository.saveAndFlush(card);
        }
        doctorRepository.saveAndFlush(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public DoctorsTypes getDoctorsTypes() {
        return doctorsTypes;
    }

    public void setDoctorsTypes(DoctorsTypes doctorsTypes) {
        this.doctorsTypes = doctorsTypes;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Doctor{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", doctorsTypes=").append(doctorsTypes);
        sb.append(", cards=").append(cards);
        sb.append('}');
        return sb.toString();
    }


}
