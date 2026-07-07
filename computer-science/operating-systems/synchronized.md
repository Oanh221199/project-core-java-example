### Synchronized
#### 1. What is it?
    - sychronized là một keyword java điều đó cho phép chỉ một thread thực thi
    một đoạn mã tại một thời điểm.
    - synchonized is a java keyword that allows only one thread
    to execute a critical section at a time.
#### 2. Why do we need? 
    - Để ngăn chặn nhiều thread cùng sử đổi dữ liệu chia sẽ cùng lúc.
    - To prevent multiple threads from modifying shared data at the same time.
#### 3. How does it work? 
    - Khi cập nhật biến dùng chung hay logic nghiệp vụ quan trọng
    - When updating shared variables or critical business logic.
#### 4. Advantages and disadvantages?
    - Advantages:
        - Đảm bảo visibility ( Guarantees visibility)
        - Đảm bảo Atomicity (Guarantees visibility)
        - Dễ dàng sử dụng (easy to use)
    - Disadvantages:
        - threads có thể block ( threads may block)
        - Có thể làm giảm hiệu năng ( Can reduce performance)
        - Sử dụng không đúng có thể dẫn tới deadlock( Incorrect use may lead to deadlock)
#### 5. common interview questions?
    - 5.1.1 synchronized ở trong java là gì? what is Synchronized in java
        - synchronized ở trong java là một keyword rằng chỉ chấp nhận một thread
        có thể thực thi một đoạn mã quyan trọng tại một thời điểm. Nó đảm bảo tính atomicity và visibility cho dữ liệu được chia sẻ
        - synchronized is a keyword in java that allows only one thread to excute a criticial section at a time.
        .It guarantees atomicity and visibility for shared data.
    