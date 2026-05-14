package com.ironhack.jpalab;

import com.ironhack.jpalab.contact.*;
import com.ironhack.jpalab.event.*;
import com.ironhack.jpalab.nurse.*;
import com.ironhack.jpalab.repository.*;
import com.ironhack.jpalab.task.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired ContactRepository contactRepo;
    @Autowired AssociationRepository associationRepo;
    @Autowired ConferenceRepository conferenceRepo;
    @Autowired ExhibitionRepository exhibitionRepo;
    @Autowired TaskRepository taskRepo;

    @Override
    public void run(String... args) {

        // --- CONTACTOS ---
        Contact c1 = new Contact();
        Name n1 = new Name();
        n1.setSalutation("Dr."); n1.setFirstName("Ana"); n1.setLastName("García");
        c1.setName(n1); c1.setCompany("Ironhack"); c1.setTitle("CEO");
        contactRepo.save(c1);

        Contact c2 = new Contact();
        Name n2 = new Name();
        n2.setSalutation("Mr."); n2.setFirstName("Carlos"); n2.setLastName("López");
        c2.setName(n2); c2.setCompany("TechCorp"); c2.setTitle("CTO");
        contactRepo.save(c2);

        Contact c3 = new Contact();
        Name n3 = new Name();
        n3.setSalutation("Mrs."); n3.setFirstName("María"); n3.setLastName("Martínez");
        c3.setName(n3); c3.setCompany("HealthPlus"); c3.setTitle("Director");
        contactRepo.save(c3);

        // --- ASOCIACIÓN DE ENFERMERÍA ---
        Association assoc = new Association();
        assoc.setName("Asociación de Enfermería de España");

        Division[] divs = new Division[7];
        String[] distritos = {"Madrid", "Barcelona", "Valencia", "Sevilla", "Bilbao", "Málaga", "Zaragoza"};

        for (int i = 0; i < 7; i++) {
            Member pres = new Member();
            pres.setName("Presidenta División " + (i+1));
            pres.setStatus(MemberStatus.ACTIVE);
            pres.setRenewalDate(LocalDate.of(2025, 1, 1));

            Member miembro = new Member();
            miembro.setName("Miembro División " + (i+1));
            miembro.setStatus(i % 2 == 0 ? MemberStatus.ACTIVE : MemberStatus.LAPSED);
            miembro.setRenewalDate(LocalDate.of(2024, 6, 15));

            Division div = new Division();
            div.setName("División " + (i+1));
            div.setDistrict(distritos[i]);
            div.setPresident(pres);
            div.setMembers(List.of(miembro));
            divs[i] = div;
        }

        assoc.setDivisions(List.of(divs));
        associationRepo.save(assoc);

        // --- CONFERENCIA ---
        Speaker s1 = new Speaker();
        s1.setName("Linus Torvalds"); s1.setPresentationDuration(60);

        Speaker s2 = new Speaker();
        s2.setName("Grace Hopper"); s2.setPresentationDuration(45);

        Guest g1 = new Guest(); g1.setName("Pedro Ruiz"); g1.setStatus(GuestStatus.ATTENDING);
        Guest g2 = new Guest(); g2.setName("Laura Sanz"); g2.setStatus(GuestStatus.NO_RESPONSE);
        Guest g3 = new Guest(); g3.setName("Javier Mora"); g3.setStatus(GuestStatus.NOT_ATTENDING);

        Conference conf = new Conference();
        conf.setTitle("Tech Summit 2025");
        conf.setDate(LocalDate.of(2025, 10, 15));
        conf.setDuration(480);
        conf.setLocation("Madrid Expo");
        conf.setSpeakers(List.of(s1, s2));
        conf.setGuests(List.of(g1, g2, g3));
        conferenceRepo.save(conf);

        // --- EXHIBICIÓN ---
        Guest g4 = new Guest(); g4.setName("Elena Torres"); g4.setStatus(GuestStatus.ATTENDING);

        Exhibition expo = new Exhibition();
        expo.setTitle("Arte Digital 2025");
        expo.setDate(LocalDate.of(2025, 11, 20));
        expo.setDuration(240);
        expo.setLocation("Barcelona Museum");
        expo.setGuests(List.of(g4));
        exhibitionRepo.save(expo);

        // --- TAREAS ---
        BillableTask bt = new BillableTask();
        bt.setTitle("Diseñar base de datos"); bt.setDueDate(LocalDate.of(2025, 9, 1));
        bt.setCompleted(false); bt.setHourlyRate(new BigDecimal("75.00"));
        taskRepo.save(bt);

        InternalTask it1 = new InternalTask();
        it1.setTitle("Reunión de equipo"); it1.setDueDate(LocalDate.of(2025, 8, 15));
        it1.setCompleted(true);
        taskRepo.save(it1);

        InternalTask it2 = new InternalTask();
        it2.setTitle("Revisar documentación"); it2.setDueDate(LocalDate.of(2025, 8, 30));
        it2.setCompleted(false);
        taskRepo.save(it2);

        System.out.println("✅ Datos cargados correctamente");
    }
}