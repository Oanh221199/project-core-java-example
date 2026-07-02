package com.demo.collectionsdemo.hashmap;

import java.util.HashMap;
import java.util.Map;

public class CollisionExample {
    public static void main(String[] args) {
//        2 key khác nhau cùng hashcode
//        HashMap có 16 bucket
//        Nếu bạn lưu hàng triệu key thì:
//        Chỉ có 16 bucket ban đầu.
//        Rõ ràng sẽ có nhiều key cùng rơi vào một bucket.
//        Đó chính là collision.
        // Hashmap không dựa hoàn toàn hashcode() để xác định 1 key
        String key1 = "FB";
        String key2 = "Ea";
        System.out.println(key1.hashCode());
        System.out.println(key2.hashCode());

        Map<String,Integer> map = new HashMap<>();

        map.put(key1,1);

        map.put(key2,2);

        System.out.println(map);
    }
}
