package SolvedProblems.HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap<K, V> {
    ArrayList<LinkedList<Entity>> table;
    int size;
    float lf;

    HashMap() {
        table = new ArrayList<>();
        size = 0;
        lf = 0.5f;

        for (int i = 0; i < 10; i++) {
            table.add(new LinkedList<>());
        }
    }

    public void put(K key, V value) {
        int hash = Math.abs(key.hashCode() % table.size());
        LinkedList<Entity> entities = table.get(hash);

        // If key value already exist
        for (Entity entity : entities) {
            if(entity.key.equals(key)){
                entity.value = value;
                return;
            }
        }

        // If not exist check lf and just add it
        if((float) size / table.size() > lf){
            reHash();
        }

        entities.add(new Entity(key, value));
        size++;
    }


    private void reHash() {
        ArrayList<LinkedList<Entity>> old = table;
        table = new ArrayList<>();
        size = 0;

        for (int i = 0; i < old.size() * 2; i++) {
            table.add(new LinkedList<>());
        }

        for (LinkedList<Entity> entities : old) {
            for (Entity entity : entities) {
                this.put(entity.key, entity.value);
            }
        }
    }

    public V get(K key){
        int hash = Math.abs(key.hashCode() % table.size());
        LinkedList<Entity> entities = table.get(hash);

        for (Entity entity : entities) {
            if(entity.key.equals(key)){
                return entity.value;
            }
        }

        return null;
    }

    public boolean remove(K key){
        int hash = Math.abs(key.hashCode() % table.size());

        LinkedList<Entity> entities = table.get(hash);
        Entity target = null;

        for (Entity entity : entities) {
            if(entity.key.equals(key)){
                target = entity;
                break;
            }
        }

        if(target != null){
            entities.remove(target);
            size--;
            return true;
        }

        return false;        
    }

    public boolean contains(K key){
        return get(key) != null;
    }   

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        for (LinkedList<Entity> entities : table) {
            for (Entity entity : entities) {
                sb.append("\n{ " + entity.key + " : " + entity.value + " }");
            }
        }
        sb.append("\n}");

        return sb.toString();
    }

    class Entity {
        K key;
        V value;
    
        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
