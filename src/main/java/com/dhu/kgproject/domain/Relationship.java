package com.dhu.kgproject.domain;


import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import java.util.ArrayList;
import java.util.List;

@RelationshipEntity
public abstract class Relationship {

    private Long id;
    private List<Relationship> relationships = new ArrayList<>();

    @StartNode
    private Node startNode;

    @EndNode
    private Node endNode;

    public Relationship() {
    }

    public Relationship(Node startNode, Node endNode) {
        this.startNode = startNode;
        this.endNode = endNode;
    }

    public Long getId() {
        return id;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public Node getStartNode() {
        return startNode;
    }

    public Node getEndNode() {
        return endNode;
    }
}
