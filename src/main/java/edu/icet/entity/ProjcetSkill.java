package edu.icet.entity;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class ProjcetSkill {
    private Long id;
    @ManyToOne
    private Project project;
    @ManyToOne
    private Skill skill;

}
