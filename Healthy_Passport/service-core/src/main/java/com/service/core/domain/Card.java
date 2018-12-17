package com.service.core.domain;

import javax.persistence.*;

/*** Карточка:
1.Рост
2.Вес
3.Группа крови
4.Пол
5.История Болезни(Врач может редактировать и просматривать)
6.Больница,в которой зарегистрирован пользователь

 by Yaroslav Halindzovskiy 17.12.2018
 */

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @Column(name = "card_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Long height;
    @Column
    private Long weight;
    @Column
    private Character gender;
    @Column
    private String history;
    @Column
    private String hospital;
    @OneToOne(fetch = FetchType.EAGER,mappedBy = "cards",targetEntity = Patient.class)
    private Patient patient;


}
