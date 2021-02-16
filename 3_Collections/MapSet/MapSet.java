package coll.MapSet;

import java.util.*;

public class MapSet<K, V> extends AbstractMap<K, HashSet<V>> implements Iterable<V> {
    Map<K, HashSet<V>> mapset = new HashMap<>();

    public void addValue(K key, V value){
        //if given key exists
        if (mapset.containsKey(key)){
            //add given value to associated key in mapset
            mapset.get(key).add(value);
        } else {
            //create a new hashset for value
            HashSet<V> newValue = new HashSet<>();
            newValue.add(value);
            //add value to mapset
            mapset.put(key, newValue);
        }
    }

    //only values are iterated through
        //tranversed first in descending order of size of Hashset objects
    @Override
    public Iterator<V> iterator() {
        Iterator<V> it = new Iterator<V>() {

            private List<K> keys = new ArrayList<>(mapset.keySet());
            private List<V> currentSet;

            private int keyIndex = 0;
            private int setIndex = 0;
            private boolean first = true;
            boolean next = true;

            @Override
            public boolean hasNext() {
                return next;
            }

            @Override
            public V next() {
                sortKeys();
                currentSet = new ArrayList<>(mapset.get(keys.get(keyIndex)));

                if (!first) {
                    if (setIndex == currentSet.size() - 1) {

                        keyIndex++;

                        setIndex = 0;
                        if (keyIndex == keys.size() - 1) {
                            next = false;
                        }
                    } else {
                        setIndex++;

                    }
                }

                currentSet = new ArrayList<>(mapset.get(keys.get(keyIndex)));
                first = false;
                return currentSet.get(setIndex);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            public void sortKeys() {
                keys.sort(new Comparator<K>() {
                    @Override
                    public int compare(K o1, K o2) {
                        return Integer.valueOf(mapset.get(o2).size()).compareTo(mapset.get(o1).size());
                    }
                });
            }

        };
        return it;

    }

    @Override
    public Set<Entry<K, HashSet<V>>> entrySet() {
        return mapset.entrySet();
    }


}
