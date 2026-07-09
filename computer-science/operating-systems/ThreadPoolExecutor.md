### ThreadPoolExecutor
#### 1. What is this?
    - ThreadPoolExecutor là cách thực thi chung nhất của ExcutorService interface.
    Nó quản lý một thread poll bằng cách tạo, sử dụng lại, chấm dứt
    các thread làm việc dựa trên config của chính nó
    - Không như executorService , nó chỉ là 1 inteface
    ThreadPoolExcutor cung cấp khả năng kiểm soát hoàn toàn cách hoạt động của threadpool
    - ThreadpoolExecutor is the most common implementation
    of the executorService interface. It manages a threadpool by creating , reusing, and terminaling 
    worker threads based on its configuration
    - Unlike ExcutorService , which is only an interface
    ThreadpoolExcutor provides full control over how the thread pool behaves
#### 2. Why do we need it?
    ThreadPoolExecutor cung cấp cho các devbelopers khả năng quản lý thread
    Nó cho phép bạn config:
    - Core thread size
    - Maximum thread size
    - Task queue
    - Thread idle timeout
    - Thread factory
    - Rejection policy
#### 3. How does it work?
    1. 1 task được nộp
    2. Nếu số lượng thread running nhỏ hơn corePoolSize, thì 1 worker thread
    mới sẽ được tạo
    3. Nếu không thì task sẽ được thêm vào queue
    4. Nếu queue full và số lượng thread nhỏ hơn maximumPoolSize
    thì một thread mới sẽ được tạo
    5. Nếu cả queue full và số lượng thread đã có chạm tới mức tối đâ
    , thì task sẽ được xử lý bởi chính sách từ chối cấu hình
    6.Threads lớn hơn core size và hoạt động lâu hơn keepAliveTime tghif sẽ bị chấm dứt

    A task is submitted.
    If the number of running threads is less than corePoolSize, a new worker thread is created.
    Otherwise, the task is added to the queue.
    If the queue is full and the number of threads is less than maximumPoolSize, a new thread is created.
    If both the queue is full and the maximum number of threads has been reached, the task is handled by the configured rejection policy.
    Threads above the core size that remain idle longer than keepAliveTime are terminated.
#### 4. When do we use it?
    - sử dụng threadPoolExcutor khi:
        - Xây dụng một hệ thống backend có sự đồng thời cao
        - Thực hiện hàng nghìn requests
        - Cần kiểm soát hoàn toàn đối với việc quản lý luồng
        - Tối ưu hóa việc sử dụng CPU và memory
        - Tùy chỉnh hành vi thread pool

    - Use threadPoolExecutor when:
        - Buidling high-concurrency backend systems
        - Processing thounsands of requests
        - Needing full control over heaed managnment
        - Optimizing CPU and memory usage
        - Customizing thread pool behavior
#### 5. Advantages and Disadvantages
    Advantages:
        - Điều khiển hoàn toàn việc quản lý threadPoool
        - Sử dụng lại các worker threads
        - Cải thiện hiệu năng
        - Giảm context switching
        - Configurable queue size
        - Hỗ trợ tùy chỉnh chính sách từ chối
        - Hỗ trợ tùy chỉnh việc tạo thread
    Disadvantages:
        - Nhiều tổ hợp sử dụng excutors
        - Cấu hình không chính xác sẽ làm giảm hiệu năng
        - Chọn pool size không phù hợp có thể gây ra tắc nghẽn
        sử dụng tài nguyên quá mức

    Advantages
        - Full control over the Thread Pool.
        - Reuses worker threads.
        - Improves performance.
        - Reduces Context Switching.
        - Configurable queue size.
        - Supports custom rejection policies.
        - Supports custom thread creation.
    Disa- dvantages
        - More complex than using Executors.
        - Incorrect configuration may reduce performance.
        - Choosing unsuitable pool sizes can cause bottlenecks or excessive resource usage.
#### 6. Common interview question?
    6.1 What is ThreadPoolExecutor?
        ThreadPoolExcutor là việc triển khai chính của ExecutorService
        đẻ mà quản lý cấu hình thread pool
    6.2 What is the difference between ExecutorService and ThreadPoolExecutor?
        ExecutorService:
            - Interface
            - Define task thực thi apis
            - Cấu hình được giới hạn
        ThreadPoolExecutor:
            - Implementation
            - Thực hiện và quản lý thread pool
            - Cấu hình hoàn toàn
    6.3 What is corePoolSize?
        - Số lượng tối thiểu worker thread được giữ hoạt động ngay cả khi chúng không hoạt động.
    6.4 What is maximumPoolSize?
        - Sô lượng worker thread có thể tạo ra khi hàng đợi đầy
    6.5 What is keepAliveTime?
        - Khoản thời gian mà các luồng bổ sung ( vượt quá core pool size) vẫn tồi tài 
        trong trạng thái nhàn rỗi trước khi bị chấm dứt
    6.6 What is the role of the task queue?
        - Lưu trữ các task đang chờ khi tất cả các core thread bận
    6.7 What happens when the queue is full?
        - Nếu số lượng worker thread đang nhỏ hơn maximumPoolSize thì sẽ
            tạo thêm worker thread
        - Nếu số lượng worker thread đã chạm tới tối đa, thì sẽ áp dụng chính sách từ chối
#### workflow
    Task
    │
    ▼
    ExecutorService (Interface)
    │
    ▼
    ThreadPoolExecutor (Implementation)
    │
    ├── corePoolSize : Số lượng tối thiểu worker thread được giữ kể cả khi nó nhàn rỗi
    ├── maximumPoolSize: Số lượng tối đa  worker thread mà thread pool  có thể được tạo khi queue đầy
    ├── BlockingQueue: hàng đợi các task đang chờ được xử lý
    ├── keepAliveTime: Là khoản thời gian mà worker thread vược quá corePoolSize được phép nhàn rỗi trước khi bị hủy
    ├── ThreadFactory: thành phần tạo worker thread cho threadPoolExecutor
    └── RejectedExecutionHandler: Chính sách xử lý không thể nhận thêm task
    │
    ▼
    Worker Threads
    │
    ▼
    Execute Tasks    
            
