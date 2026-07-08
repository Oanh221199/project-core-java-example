### Thread pool
####  1.1 What is it?
    _ thread pool là tập hợp các thread có thể tái sử dụng với nhau
    ( a thread poool is a collection of reusable threads that excute multiple tasks)
    - Thay vì tạo 1 thread mỗi task, các task được giao nhiệm vụ
    thoát khỏi thread pool. Sau khi kết thúc 1 task, thead trả về poolk và chờ task tiếp theo
    ( instead of creating a new thread for every task, tasks are assigned to existing
    threads in the pool. After finishing a task,  the thread returns to the pool and waits for the next task)
####  1.2 Why do we need it?
    - Tạo một thread mới cho mỗi task thì đắt:
    ( Creating a new thread for every task is expensive because:)
        - Việc tạo thread tốn thời gian ( Thread creation takes time)
        - Mỗi thread đều tiêu thụ bộ nhớ ( Each thread consumners memory)
        - Quá nhiều thread tăng context switching ( Too many threads increase context switching)
        - Quản lý nhiều thread khó ( Managing many threads is diffcult)
####  1.3 How does it work?
    Task -> Task queue -> Thread pool -> Avaiable thread-> Excute Task -> Thread return to the pool
    1. Ứng dụng tạo 1 thread poll ( The application creates a thread pool)
    2. Các task được gửi vào pool ( Task are submitted to pool)
    3. Các task được đưa vào hàng đợi ( Tasks are placed into a queue)
    4. Một thread có sẵn nhặt một task ( A available thread picks up a task)
    5. Sau khi hoàn thành, threa trả về pool thay vì hủy
    ( after compeletion, the thread returns to the pool instead of being destroyed)
    6. Cùng 1 thread có thể thực hiện nhiều task khác nhau
    ( The same thread can excute many different task)

####  1.4 When do we use it?
    Sử dụng thread pool khi ( Use a thread pool when:)
    - Xử lý nhiều task độc lập ( Processing many independent tasks)
    - Xử lý các http request ở trong ứng dụng web( Handling http requests in thw web application)
    - Gọi các api bên ngoài ( Calling external APIs)
    - Đọc và viết file( Reading and writing file)
    - Gửi mail (Sending mails)
####  1.5 Advantages and disadvantages?
    Advantages:
        - Tái sử dụng thread (Reuses threads)
        - Cải thiện hiệu năng ( Improves performance)
        - Giảm chi phí tạo luồng (reduces thread creation overhead)
        - Giảm context switching ( Reduces context switching)
        - Quản lý tài nguyên tốt hơn ( Better resource management)
        - Hỗ trợ tính đồng thời cao( support high concurrency)
    Disadvantages:
        - Chọn size pool không đúng có thể giảm hiệu năng 
        ( Choosing the wrong pool size can reduce performance)
        - Quá nhiều thread rác CPU và bộ nhớ ( Too many threads waste CPU and memory)
        - Một task chạy lâu ảnh hưởng đến task khác ( Long running tasks may deplay pother tasks)
####  1.6 Common questions
    1.6.1 What is a Thread Pool?
        - Một thread pool là một tập hợp các thread có thể tái sử dụng thực thi nhiều task
        - Thay vì mỗi task tạo 1 thread thì các thread được tái sử dụng
        để cải thiện hiệu năng và giảm sử dụng tài nguyên
    1.6.2. Why do we need a Thread Pool?
        - Tạo một thread mới mỗi task thif đăt  bởi thread tiêu thụ CPY và memory
        - Thread pool giúp giảm tài nguyên và tăng hiệu năng
    1.6.3 How does a Thread Pool work?
        - Các task được đưa vào thread pool. Nếu một thread
        có sẵn, nó thực thi task ngay lập tức. Ngược lại các task khác 
        sẽ ở trong hàng đợi chờ cho đến khi có luồng xử lý phù hợp.
        Sau khi hoàn thành task, thread  trở về pool để tái sử dụng.
    1.6.4 What happens when all threads are busy?
        - Những cái task mới sẽ được đặt ở task queue.
        Chúng sẽ chờ những thread làm việc kết thúc task hiện tại .
    1.6.5 Can one thread execute multiple tasks?
        - Sau khi kết thúc 1 task, thread trở về pool và có thể thực thi task khác
    1.6.6 What happens if the Thread Pool is too small?
        - Các task sẽ dành nhiều thời gian chờ queue
        giảm thông lượng và tăng thời gian chờ
    1.6.7. What happens if the Thread Pool is too large?
        - Quá nhiều threads tiêu thụ nhiều bộ nhớ và tăng context switching dẫn 
        đến giảm hiệu năng
    1.6.8 How do you choose the Thread Pool size?
        Phụ thuộc vào :
            - CPU-bound task: Số lương thread thường gần bằng số lõi CPU
            - I/O-bound tasks: Có thể sử dụng  nhiều luồng hơn bởi nhiều
            luồng dành thời gian chờ thao tác i/o
    1.6.9. What is the relationship between Thread Pool and ExecutorService?
        - Thread pool là tập hợp của những task làm việc
        - ExcutorService là một interface được sử dụng để quản lý thread pool
         và gửi các task để thực thi
