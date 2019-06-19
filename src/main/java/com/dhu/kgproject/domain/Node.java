package com.dhu.kgproject.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.List;

@Data
@NodeEntity
public class Node {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String level;
    private String description;
    private String type;
    private String img_url;

    @JsonIgnore
    @org.neo4j.ogm.annotation.Relationship(type = "Include")
    private List<Relationship> relationships;

    public Node() {
    }

    public Node(Long id, String name,String level ,String describe) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.description = describe;
    }

}
