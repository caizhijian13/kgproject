package com.dhu.kgproject.services;


import com.dhu.kgproject.domain.Kind_of;
import com.dhu.kgproject.domain.Node;
import com.dhu.kgproject.domain.Relationship;
import com.dhu.kgproject.repositories.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class NodeService {
    @Autowired
    private final NodeRepository  repository;

    public NodeService(NodeRepository repository) {
        this.repository = repository;
    }

    private Map<String,Object> toD3Format(Collection<Node> nodes){
        List<Map<String,Object>> Allnodes = new ArrayList<>();
        List<Map<String,Object>> rels = new ArrayList<>();
        int i = 0;
        Iterator<Node> result = nodes.iterator();
        while(result.hasNext()){
            int source;
            Node node = result.next();
            Map<String,Object> no = map("id",node.getId(),"name",node.getName(),"description",node.getDescription());
            if(Allnodes.indexOf(no)==-1){
                Allnodes.add(no);
                source = i++;
            }
            else{
                source = Allnodes.indexOf(no);
            }
//            if(node.getRelationships() != null){
//                for(Relationship re: node.getRelationships()){
//                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription());
//                    int target = Allnodes.indexOf(nodee);
//                    if(target == -1){
//                        Allnodes.add(nodee);
//                        target = i++;
//                    }
//                    rels.add(map("source",source,"target",target));
//                }
//            }
            if(node.getLowerInclude() != null){
                for(Relationship re: node.getLowerInclude()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","Include"));
                }
            }
            if(node.getUpperInclude() != null){
                for(Relationship re: node.getUpperInclude()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","INCLUDE"));
                }
            }

            if(node.getAttribute_of() != null){
                for(Relationship re: node.getAttribute_of()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","Attribute_of"));
                }
            }

            if(node.getInstance_of() != null){
                for(Relationship re: node.getInstance_of()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","Instance_of"));
                }
            }

            if(node.getKind_of() != null){
                for(Relationship re: node.getKind_of()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type", "Kind_of"));
                }
            }

            if(node.getPart_of() != null){
                for(Relationship re: node.getPart_of()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","Part_of"));
                }
            }

            if(node.getLowerInstance_of() != null){
                for(Relationship re: node.getLowerInstance_of()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","Instance_of"));
                }
            }

            if(node.getLowerKind_of() != null){
                for(Relationship re: node.getLowerKind_of()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","Kind_of"));
                }
            }

            if(node.getNext() != null){
                for(Relationship re: node.getNext()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","next"));
                }
            }

            if(node.getDesignTrend() != null){
                for(Relationship re: node.getDesignTrend()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","DesignTrend"));
                }
            }
            if(node.getFabricDesign() != null){
                for(Relationship re: node.getFabricDesign()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","FabricDesign"));
                }
            }
            if(node.getTrendFabric() != null){
                for(Relationship re: node.getTrendFabric()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","TrendFabric"));
                }
            }

            if(node.getFit() != null){
                for(Relationship re: node.getFit()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","适合"));
                }
            }
            if(node.getUnfit() != null){
                for(Relationship re: node.getUnfit()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","不适合"));
                }
            }
            if(node.getMatch() != null){
                for(Relationship re: node.getMatch()){
                    Map<String,Object> nodee = map("id",re.getEndNode().getId(),"name",re.getEndNode().getName(),"description",re.getEndNode().getDescription());
                    int target = Allnodes.indexOf(nodee);
                    if(target == -1){
                        Allnodes.add(nodee);
                        target = i++;
                    }
                    rels.add(map("source",source,"target",target,"type","匹配"));
                }
            }
        }
        return map("nodes",Allnodes,"links",rels);
    }

    private Map<String, Object> map(String source, Object source1, String target, Object target1) {
        Map<String,Object> result = new HashMap<String,Object>(2);
        result.put(source,source1);
        result.put(target,target1);
        return result;
    }

    private Map<String, Object> map(String key1,Object value1,String key2,Object value2,String key3,Object value3) {
        Map<String,Object> result = new HashMap<String ,Object>(3);
        result.put(key1,value1);
        result.put(key2,value2);
        result.put(key3,value3);
        return result;
    }

    @Transactional(readOnly = true)
    public Node findByName(String name){
        Node result = repository.findByName(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<Node> findNodesByNameLike(String name){
        Collection<Node> result = repository.findNodesByNameLike(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<Node> findByNameLike(String name){
        Collection<Node> result = repository.findByNameLike(name);
        return result;
    }

    @Transactional(readOnly = true)
    public Map<String,Object> selectgraph(String name){
            Collection<Node> result = repository.selectgraph(name);
            return toD3Format(result);
    }

    @Transactional(readOnly = true)
    public Map<String ,Object> graph(int limit){
        Collection<Node> result = repository.graph(limit);
        return toD3Format(result);
    }
}
