### ReentrantLock
#### 1.1 What is this?
    - Reentrantlock là một class ở trong package java.util.concurrent.lock
    nó cung cấp một cơ chế khóa thủ công để đồng bộ luồng.
    - Nó làm việc như synchnized nhưng linh hoạt và điều khiển tốt hơn.
    - Reentrantlock is a class in the java.util.concurrent.locks package
    that provides a manual locking mechanism for the thread synchronization
    - It works like synchronized but offers more flexibility and control

#### 1.2 Why do we need it?
    - dùng mỗi synchronized không đủ bởi vì cần điều khiển locking tốt hơn
    -Reentrantlock cung cấp thêm các tính năng như:
        - tryLock() - Cố gắng mở khóa mà không cần chờ đợi quá lâu
        - Timeout trong khi chờ khóa
        - lockInterruptibly - cho phép 1 luồng đang chờ bị dán đoạn
        - Fair locking
    - Sometimes synchronized is not enough because we need more control
    over locking
    - Reentrantlocking provides addtional features such as:
        -tryLock(): try to get the lock without waiting forever.
        - Timeout while waiting for a lock
        - lockInterruptibly(): allow a waiting thread to be intrerrupted.
        - Fair locking
#### 1.3 How does it work?
    -  Một thread phải chủ động dành quyền truy cập khóa khi vào đoạn mã
    và phải giải phóng mã khi hoàn thành
    - a thread must explicitly acquire the lock before entering
    the critical section and release it when finish
    How it works:
    - 1. Thread a calls lock() and acquires the lock()
    - 2. Other threads trying to arquire the same lock must wait
    - 3. A thread a excutes the critical section
    - 4. Thread A call unlock() to release lock()
    - 5. another waiting thread acquires the lock and continues
####1.4. When do we use it?
    - Nhiều thread update dữ liệu chia sẻ ( multiple thread update shared data)
    - Bạn cần timeout trong khi chờ 1 lock ( You need timeout while waiting for a lock)
    - Bạn muốn tránh khóa viễn vĩnh viễn ( you want avoid blocking forever)
    - Bạn cần ngắt kết nối khóa ( you need interruptible blocking)
    - Bạn cân điều khiển hơn synchonized( you need more control than synchronized)
    - Bạn cần tính năng như là trylock() ( you need feature such as trylock())
####1.5. Advantages and disadvantages
    Advantages
        - Đảm bảo atomicity( Guarantee  actomicity)
        - Đảm bảo visibility ( đảm bảo visibility)
        - Linh hoạt hơn synchronized ( More flexible than synchronized)
        - Hỗ trợ trylock() ( support trylock())
        - Hỗ trợ timeout ( support timeout())
        - Hỗ trợ lockInterruptibly() ( support lockinteruptibly())
        - Hỗ trợ fair locking ( support fair locking)
    DisAdvantages
        - Phải tự gọi hàm unlock() ( Must manually call unlock())
        - Quên unlock() có thể dẫn đến các thread khác chờ vĩnh viễn( Forgetting unlock() can cause other threads to wait forever)
        - Dài dòng hơn synchoronized ( More verbose than synchronnized)
        - Phức tạp hơn khi sử dụng ( Slightly more complex to use)
####1.6. Common Interview Questions
    1.6.1 Why use ReentrantLock instead of synchronized?
    Sử dụng ReentrantLock khi cần
        - trylock()
        - timeout
        - Interruptible locking
        - Fair locking