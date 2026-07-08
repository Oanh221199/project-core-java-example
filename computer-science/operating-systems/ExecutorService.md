### ExecutorService
####  1.1 What is it?
    - ExecutorService là một java inteface ở trong java.util.concurrent
    được sử dụng để quản lý và thực thi task với threadpoll.
    - Thay vì tạo và quản lý thread một cách thủ công
    bạn sẽ gửi task cho executorService, và nó sẽ giao task cho các thread có sắn
    - ExecutorService is a Java interface in the java.util.concurrent package used to manage and execute tasks with a Thread Pool.
    - Instead of creating and managing threads manually, you submit tasks to the ExecutorService, and it assigns them to available threads.
####  1.2 Why do we need it?
    - Tạo thread thủ công thường không hiệu quả:
        -  Việc tạo thread đắt
        -  Tạo quá nhiều thread tiêu thụ bộ nhớ
        -  Thường việc tạo thread tăng context switching
        - Việc quản lý vòng đời thread phức tạp
    - Creating threads manually is inefficient because:
        - Thread creation is expensive.
        - Too many threads consume memory.
        - Frequent thread creation increases Context Switching.
        - Managing thread lifecycle is complicated.
#### 1.3. How does it work?
    Task -> submit() /excute() -> ExecutorService -> Thread Pool- > Worker Thread -> Excute task-> Return thread pool
    1. Tạo một executorService.
    2. Gửi tasks sử dụng submit() hoặc excute()
    3. Các task được đặt vào 1 queue
    4. Một thread làm việc có sẵn nhặt vào task
    5. Thread thực thi task
    6. Sau khi hoàn thành, thread trả về pool
    7. Gọi shutdown() khi không có tasks cần thực hiện

    1.Create an ExecutorService.
    2.Submit tasks using execute() or submit().
    3.Tasks are placed into a queue.
    4.An available worker thread picks up the task.
    5.The thread executes the task.
    6.After completion, the thread returns to the pool.
    7.Call shutdown() when no more tasks need to be submitted.
#### 1.4. When do we use it?
    - Thực thi nhiều tasks
    - Tiến hành http requests
    - Gọi APIs
    - Gửi email bất đồng bộ
    - Đọc và viết file

    - Executing multiple independent tasks.
    - Processing HTTP requests.
    - Calling external APIs.
    - Sending emails asynchronously.
    - Reading or writing files.
    - Running background jobs.
    - Building high-concurrency backend applications.
#### 1.5. Advantages & Disadvantages
    Advantages: 
        - Sử dụng lại được thread
        - Cải thiện hiệu năng
        - Giảm việc tạo thread
        - Quản lý thread một cách đơn giản
        - Hỗ trợ bất đồng bộ
        - Có thể trả kêts của task sử dụng future
    Advantages
        - Reuses threads.
        - Improves performance.
        - Reduces thread creation overhead.
        - Simplifies thread management.
        - Supports asynchronous execution.
        - Can return task results using Future.
    Disadvantages
        - Cần chọn kích thước thread pool phù hợp
        - Quên gọi shutdown() có thể giữ ứng dụng chạy liên tục
        - Task chạy liên tục dài có thể deley task khác
        - Cấu hình kém có thể giảm hiệu năng
#### 1.6. Common Interview Questions
    1.6.1What is the difference between execute() and submit()?
        Excute():
            - Return void()
            - Không thể return kết quả
            - Exception được xử lý bới thread
        Submit()
            - Return feature()
            - Có thể return kết quả
            - Exception bị giữ lại thông qua future
    1.6.2 What is a Future?
        Thể hiện kết quả của 1 tác vụ bất đồng bộ
            - Kiểm tra task đã hoàn thành chưa
            - Chờ hoàn thành
            - Lấy giá trị trả về
    1.6.3 Why should we call shutdown()?
            - ứng dụng nhừng cho phép các task mới
            nhưng vẫn chạy hoàn tất task cũ,
            Nếu không có tính nằng này ứng dụng vẫn chạy vì thread poll 
            vẫn hoạt động
#### 1.7. Real-world Example
    - send mail

    
