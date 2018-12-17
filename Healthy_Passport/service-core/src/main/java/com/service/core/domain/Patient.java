package com.service.core.domain;


import javax.persistence.*;
import java.util.Date;

/**********
 Пациент:
 0.ID(можно сделать по ИНН)
 1. Фамилия
 2.Имя
 3.год рождения
 4. Сущность " Карточка"

 by Yaroslav Halindzovskiy 17.12.2018

 */
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private Date birthday;
    @OneToOne(fetch = FetchType.EAGER, targetEntity = Card.class)
    @JoinColumn(name = "patient_id", referencedColumnName = "card_id")
    private Card card;

    public Patient() {
    }

    public Patient(String name, String surname, Date birthday, Card card) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.card = card;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Patient{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", card=").append(card);
        sb.append('}');
        return sb.toString();
    }
}
