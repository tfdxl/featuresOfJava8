package tfdxl.chapter01;


import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tianfeng on 2017/4/3.
 */
public class StreamProcessing01 {

    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList();

        for(int i=0;i<10;i++){
            inventory.add(new Apple("apple"+i,i));
        }

        //顺序处理
        List heavyApples1 = inventory.stream().filter((Apple apple) ->apple.getWeight()>4).collect(Collectors.toList());

        //并行处理
        List<Apple> heavyApple2 = inventory.parallelStream().filter((Apple apple) ->apple.getWeight()>4).collect(Collectors.toList());
        System.out.println("data: "+ JSON.toJSON(heavyApple2));
    }
}
