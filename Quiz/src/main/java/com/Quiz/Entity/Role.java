package com.Quiz.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by c263 on 20.07.2015.
 */

@Entity
@Table(name = "role")
public class Role {
    private long id;
    private String name;
}
