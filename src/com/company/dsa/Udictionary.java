package com.company.dsa;

import java.util.ArrayList;
import java.util.List;

public class Udictionary<T> {
    List<List<T>> dict;
    List<T> keys = new ArrayList<>();
    boolean print = false;

    //-------------constructors---------------
    //empty
    Udictionary(){
        dict = new ArrayList<>();
    }

    //For key and value
    Udictionary(T key, T value){
        dict = new ArrayList<>();
        List<T> first = new ArrayList<>();
        first.add(key); first.add(value);
        dict.add(first);

        keys.add(key);
    }


    //-------- Main Functions-----------
    //Add Function
    void add(T key, T value){
        if(!keys.contains(key)){
            List<T> list = new ArrayList<>();
            list.add(key); list.add(value);
            dict.add(list);
            if(print)System.out.println("Key : " + key + "\nValue : " + value + "\nhas been added!");
            keys.add(key);
        }
        else{
            System.out.println(key + " already exists in the dictionary!");
        }
    }

    //Default remove function
    void remove(){
        int n = dict.size();
        if(!dict.isEmpty()){
            if(print) System.out.println("[Key = " + dict.get(n-1).get(0) + ", Value = " + dict.get(n-1).get(1) + "] has been removed!");
            dict.remove(n-1);
        }

    }
    //Remove function using key
    void remove(T key){
        if(keys.contains(key)){
            for(int i=0;i<dict.size();i++){
                if(dict.get(i).get(0) == key){
                    dict.remove(i);
                    keys.remove(i);
                    break;
                }
            }
            if(print) System.out.println(key + " has been removed from the dictionary!");
        }
        else{
            String mesg = key + " does not exist in the dictionary! ";
            if(key instanceof String) {
                mesg += "This is case sensitive, check your input string";
            }
            System.out.println(mesg);
        }
    }
    //remove function using index
    void remove(int index){
        if(index < dict.size()){
            dict.remove(index);
            if(print) System.out.println(dict.get(index).get(0) + " has been removed from the dictionary!");
        }
        else{
            System.out.println("Index out of bound!");
        }
    }

    //---------Get functions----------
    //Get function using key
    List<T> get(T key){
        List<T> output = new ArrayList<>();
        if(keys.contains(key)){
            for(int i=0;i<dict.size();i++){
                if(dict.get(i).get(0) == key){
                    output.add(key); output.add(dict.get(i).get(1));
                    return output;
                }
            }
        }
        return output;
    }
    //Get function using index
    List<T> get(int index){
        List<T> output = new ArrayList<>();
        if(index < dict.size()){
            output.add(dict.get(index).get(0));
            output.add(dict.get(index).get(1));
            return output;
        }
        return output;
    }
    //Get all keys from values
    List<T> getAllKeys(T value){
        List<T> keys = new ArrayList<>();
        for(int i=0;i<dict.size();i++){
            if(dict.get(i).get(1) == value){
               keys.add(dict.get(i).get(0));
            }
        }
        return keys;
    }
    //Get first occurence of key using value
    T getKey(T value){
        for(int i=0;i<dict.size();i++){
            if(dict.get(i).get(1) == value){
                return dict.get(i).get(0);
            }
        }
        return null;
    }

    //Get first occurence of value using key
    T getValue(T key){
        for(int i=0;i<dict.size();i++){
            if(dict.get(i).get(0) == key){
                return dict.get(i).get(1);
            }
        }
        return null;
    }


    //check if the dictionary is empty
    boolean isEmpty(){
        return dict.size() == 0;
    }

    //Check if the dictionary contains the key
    boolean contains(T key){
        return keys.contains(key);
    }

    //Size
    int size(){
        return dict.size();
    }

    //Can switch to printing the logs
    void log(boolean flag){
        if(flag) print = true;
        else print = false;
    }

    //print
    void print(){
        for(int i=0;i<dict.size();i++){
            System.out.print("[Key = " + dict.get(i).get(0) + ", Value = " + dict.get(i).get(1) + "] ");
        }
        System.out.println();
    }

    //returns whole list
    List<List<T>> getAll(){
        return dict;
    }
}

