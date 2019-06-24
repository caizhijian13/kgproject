package com.dhu.kgproject.services;

import com.dhu.kgproject.domain.Node;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NodeServiceTest {

    @Autowired
    NodeService nodeService;

    @Test
    public void findOne(){
        Node result = nodeService.findByName("相关标准");
        System.out.println(result.getName());
    }

    @Test
    public void findLike(){
        Collection<Node> nodes = nodeService.findNodesByNameLike("字母形");
        for (Node node: nodes
             ) {
            System.out.println(node);
//            System.out.println(node.getName());
//            System.out.println(node.getDescription());
//            System.out.println(node.getType());
//            System.out.println(node.getRelationships());
        }
    }

    @Test
    public void findGrgph(){
        System.out.println(nodeService.selectgraph("字母形"));
    }

}