### Atomicity
####  1.1 What is it?
    - Atomicity là tính nguyên tử, nghĩa là một thao tác phải được thực hiện trọn vẹn từ đầu đến cuối, không bị thread khác xen vào.
####  1.2 Why do we need it?
    Khi nhiều thread cùng cập nhật một biến, nếu thao tác không có tính nguyên tử sẽ xảy ra:
    Race Condition.
    Lost Update.
    Dữ liệu không nhất quán. 
####  1.3. How does it work?
    Để đảm bảo Atomicity, Java cung cấp:
    synchronized
    ReentrantLock
    AtomicInteger
    AtomicLong
    AtomicReference

####  1.4. When do we use it?
    Atomicity cần thiết khi:

    - Tăng hoặc giảm biến đếm (counter++).
    - Cập nhật số dư tài khoản.
    - Thống kê số lượng request.
    - Cập nhật dữ liệu dùng chung giữa nhiều thread.
####  1.5. Advantages & Disadvantages
    Advantages
        - Đảm bảo dữ liệu luôn chính xác.
        - Tránh Race Condition.
        - Đảm bảo tính nhất quán khi nhiều thread cùng cập nhật dữ liệu.
    Disadvantages
        - Đồng bộ hóa có thể làm giảm hiệu năng.
        - Nếu lạm dụng synchronized hoặc Lock có thể gây Deadlock hoặc giảm khả năng xử lý đồng thời.
####  1.6. Common Interview Questions
    1.6.1 count++ có Atomic không?
        Không.
        Thực tế gồm ba bước:
            - Read
            - Increment
            - Write
        Nên có thể xảy ra Race Condition.
    1.6.2 Làm sao để đảm bảo Atomicity?
        - synchronized
        - ReentrantLock
        - AtomicInteger
        - AtomicLong
        - AtomicReference
    1.6.3 volatile có đảm bảo Atomicity không?
        Không.
        volatile chỉ đảm bảo:
            - Visibility.
            - Ordering.
        Không đảm bảo Atomicity.
    1.6.4 AtomicInteger hoạt động như thế nào?
        AtomicInteger sử dụng cơ chế CAS (Compare And Swap) để cập nhật giá trị theo cách thread-safe mà không cần dùng Lock.

    1.6.5 Atomicity là gì?
        Atomicity là tính nguyên tử của một thao tác, nghĩa là thao tác đó phải được thực hiện trọn vẹn từ đầu đến cuối mà không bị thread khác xen vào. Ví dụ, count++ không phải là thao tác nguyên tử vì nó gồm ba bước: đọc giá trị, tăng giá trị và ghi lại. Nếu một thread khác xen vào giữa các bước này, kết quả có thể sai. Vì vậy, Java cung cấp synchronized, Lock và các lớp Atomic để đảm bảo Atomicity.
####  1.7. Real-world Example
    Ví dụ một website thống kê số lượt truy cập
    Nếu có hàng nghìn request đồng thời, kết quả sẽ không chính xác vì nhiều thread cùng cập nhật biến.
    Nhờ sử dụng AtomicInteger, mỗi lần tăng giá trị đều là thao tác nguyên tử và không bị mất dữ liệu.