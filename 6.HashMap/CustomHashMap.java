package com.example.map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomHashMap<K,V> {

    private List<LinkedList<Entity>> list;
    private float lf = 0.5f;
    private int size;
    private static final int CAPACITY = 10;

    public CustomHashMap() {
        this(CAPACITY);
    }

    public CustomHashMap(int capacity) {
        list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            list.add(new LinkedList<>());
        }
    }

    public void put(K key, V value){
        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<Entity> entities = list.get(hash);
        for(Entity entity : entities){
            if(entity.key.equals(key)){
                entity.value = value;
                return;
            }
        }
        if(((float) size /list.size()) > lf){
            reHash();
        }
        Entity entity = new Entity(key,value);
        entities.add(entity);

        size++;
    }

    private void reHash(){
        //TO-DO
        List<LinkedList<Entity>> old = list;
        list = new ArrayList<>();

        size = 0;

        for (int i = 0; i < old.size() * 2; i++) {
            list.add(new LinkedList<>());
        }

        for(LinkedList<Entity> entities : old){
            for (Entity e : entities){
                put(e.key,e.value);
            }
        }
    }

    public V get(K key){
        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<Entity> entities = list.get(hash);
        for(Entity entity :  entities){
            if(entity.key.equals(key)){
                return entity.value;
            }
        }

        return null;
    }

    public V remove(K key){
        int hash = Math.abs(key.hashCode()%list.size());

        LinkedList<Entity> entities = list.get(hash);
        for(Entity  entity : entities){
            if(entity.key.equals(key)){
                entities.remove(entity);
                size--;
                return  entity.value;
            }
        }
        return null;
    }

    public boolean containsKey(K key){
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);

        for(Entity entity : entities){
            if(entity.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (LinkedList<Entity> entities : list){
            for (Entity e: entities){
                sb.append(e.key);
                sb.append("=");
                sb.append(e.value);
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        return sb.toString();
    }

    private class Entity {
        K key;
        V value;

        Entity(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}

