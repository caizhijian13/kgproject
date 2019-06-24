package com.dhu.kgproject.repositories;

import com.dhu.kgproject.domain.Node;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class NodeRepositoryTest {
    @Autowired
    NodeRepository repository;

//    @Test
//    public void findOne(){
//        Node result = repository.findNodeByName("asd标准");
////        Assert.assertNotNull(result);
//        System.out.println(result.getName());
//    }

    @Test
    public void findLike(){
        Collection<Node> nodes = repository.findNodesByNameLike("型");
        if(nodes.isEmpty()){
            System.out.println("null");
        }
        else
        for (Node node:nodes){
            System.out.println(node.getName());
        }
    }

    @Test
    public void findByNameTest(){
        Node node = repository.findByName("字母型");
        System.out.println(node);
    }

    @Test
    public void selectgraph(){
        Collection<Node> nodes = repository.selectgraph("字母形");
        for (Node node: nodes){
//            System.out.println(node.getRelationships());
            System.out.println(node);
        }
    }
}