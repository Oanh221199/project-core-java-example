### 4.1 Multithreading
#### 4.1 What is it?
    - Multithreading là kỹ thuật cho phép nhiều thread chạy đồng thời 
    trong cùng một process, giúp thực hiện nhiều công việc cùng lúc.
#### 4.2 Why do we need it ?
    - Tăng khả năng xử lý đồng thời
    - Tận dụng CPU hiệu quả
    - Cải thiện hiệu năng và khả năng phản hồi của ứng dụng
#### 4.3 How does it work?
    - OS scheduler phân phối thời gian CPU cho các thread.
    trên cpu nhiều lõi, một số threa có thể chạy song song.
    Nếu không đủ lõi, CPU sẽ luân phiên chạy các thread bằng context switching.
#### 4.4 When do we use it?
    - Web server( Spring boot, tomcat)
    - Xử lý nhiều request
    - Download/ Upload
    - Background/Job
    - Batch Processing
#### 4.5 Advantages & Disadvantages
    Advantages:
        - Tăng hiệu năng
        - Tận dụng CPu đa lõi.
        - Cải thiện trải nghiệm người dùng.
    Disadvantages: 
        - Dễ xảy ra race condition, Deadlock
        - Khó debug
        - Cần sychronization
#### 4.6 Common interview questions.
    4.6.1
#### 4.7 Real-world example
    - Spring boot sử dụng nhiều thread để xử lý đồng thời nhiều HTTP Requests từ người dùng.

### 5. Thread lifecycle
#### 5.1 What is this?
    - Thread lifecycle là vòng đời của 1 thread
    từ khi được tạo đến khi kết thúc.
#### 5.2 Why do we need?
    - Giúp quản lý trạng thái của thread và hiểu cách thread hoạt động trong quá trình thực thi.
#### 5.3 How does it work?
    NEW -> RUNNABLE-> RUNNING-> BLOCKED/WAITING/TIMED_WAITING-> TERMINAL
    - New: Thread được tạo nhưng chưa chạy
    - Runnable: Sẵn sàng chạy chờ CPU cấp thời gian
    - Running: Đang được CPU thực thi
    - BLOCKED/WAITING/TIMED_WAITING: Tạm dừng do chờ block, chờ tín hiệu hoặc chờ hết thời gian
    - Terminal: Thread đã hoàn thành hoặc bị kết thúc.
#### 5.4 When do we use it?
    - Debug ứng dụng đa luồng
    - Phân tích thread dump
    - Tối ưu hiệu năng
#### 5.5 Advantages and Disadvantages
    Advantages:
    - Dễ theo dõi trạng thái thread
    - Hỗ trợ debug và tối ưu
    Disadvantages:
    - Quản lý nhiều thread phức tạp
#### 5.6 Real-world example
    - Một request trong spring boot được một thead xử lý từ khi nhận thread đến khi trả response, sau đó thread
        quay về thread pool để phục vụ request khác
### 6.Context switching
#### 6.1 What is it?
    - Context switching là quá trình CPU chuyển từ thread hoặc process này
    sang thread hoặc process khác
#### 6.2 Why do we need?
    - Vì CPU không thể chạy các thread cùng lúc, nên phải luân phiên cấp thời gian thực
    thi cho từng thread
#### 6.3 How does it work?
    - CPU lưu trạng thái context của thread hiện tại, sau đó nạp trạng thái thread khác
    để tiếp tục thực thi. Quá trình này diễn ra nhanh và do OS Scheduler quản lý.
#### 6.4 When do we use it?
    - Diễn ra trong mọi hệ điều hành đa nhiệm khi có thread hoặc process cùng cần sử dụng CPU
#### 6.5 Advantages and Disadvantages?
    - Advantages:
        - Hỗ trợ đa nhiệm
        - Tăng khả năng đáp ứng của  hệ thống
    - Disadvantages:
        - Có chi phí xử lý ( CPU phải lưu và khôi phục trạng thái)
        - Quá nhiều context switching sẽ làm giảm hiệu năng
#### 6.6 Real-word example
    - Một máy chỉ có 8 CPU Core nhưng server đang xử lý 500 thread. CPU sẽ liên tục 
    chuyển đổi giữa các thread để tất cả đều có cơ hội thực thi, tạo cảm giác các request
    được xử lý đồng thời.
### 7.Common question
#### 7.1 Concurrency và Parallelism khác nhau như thế nào?
    Concurrency:
        - Nhiều tác vụ cùng tiến triển 
        - Có thể chỉ cần 1 CPU
        - Dựa vào Context Switching
        Vd: 1 core : A-> B->C->A->B
    Parallelism
        - Nhiều tác vụ thực sự chạy cùng lúc
        - Cần nhiều CPU Core
        - Chạy song song trên nhiều Core
        Vd: 8 core: 
                - core 1 -> A
                - core 2 -> B
#### 7.2 Multithreading có luôn làm chương trình nhanh hơn không?
    Không.
    Nếu chương trình : CPU-bound
    -> Thì hiệu năng bị giới hạn bởi số core
    Nếu tạo quá nhiều thread
                |
    Context switching tăng
                |
    Chậm hơn
#### 7.3 Khi nào KHÔNG nên dùng Multithreading?
    - Khi tác vụ rất nhỏ
    - Chương trình đơn giản
    - CPU bound quá nặng
    - Shared data quá nhiều
#### 7.4 Thread-safe là gì?
    - Code vẫn đúng khi nhiều thread chạy đồng thời
#### 7.5 Làm sao để Thread-safe?
    - synchronized
    - Lock
    - Atomic
    - Immutable
    - Concurrent Collection
#### 7.6 synchronized là gì?
    - là cơ chế đồng bộ trong java
#### 7.7 synchronized hoạt động như thế nào?
    - Thread phải lấy được Monitor Lock trước khi thực thi.
    - Nếu lock đang bị giữ, thread sẽ chuyển sang trạng thái BLOCKED.
    -Khi lock được giải phóng, thread khác mới được thực thi.
#### 7.8 synchronized method và synchronized block khác nhau thế nào?
    - synchronized method:
        - Khóa toàn bộ method.
    - synchronized block:
        - Chỉ khóa đoạn code cần thiết.
        - Hiệu quả hơn vì giảm phạm vi khóa.
#### 7.9 synchronized khóa cái gì?
    - synchronized(this) → khóa object hiện tại.
    - synchronized(MyClass.class) → khóa class.
    - synchronized(lock) → khóa object được truyền vào.
#### 7.10 synchronized có nhược điểm gì?
    - Blocking thread.
    - Có thể gây Deadlock.
    - Giảm throughput nếu lock quá lớn.
#### 7.11 Lock khác synchronized như thế nào?
    synchronized:
        - Tự động khóa/mở
        - Đơn giản
        - Không timeout
        - Không interruptible
    lock:
        - Khóa và mở thủ công
        - Linh hoạt hơn
        - Có tryLock()
        - Có lockInterruptibly()
#### 7.11 Khi nào dùng ReentrantLock thay vì synchronized?
    -Cần timeout khi lấy lock.
    -Muốn thread có thể bị interrupt khi chờ lock.
    -Cần kiểm soát việc khóa/mở linh hoạt.
#### 7.12 Nếu quên unlock() thì sao?
    Lock sẽ không được giải phóng.
    -> Các thread khác sẽ chờ mãi
#### 7.13 AtomicInteger là gì?
    - Là lớp hỗ trợ cập nhật dữ liệu theo cách thread-safe mà không cần dùng synchronized.
#### 7.14 Atomic hoạt động như thế nào?
    - Sử dụng cơ chế CAS (Compare And Swap) để cập nhật giá trị.
    - Nếu giá trị hiện tại đúng như mong đợi thì cập nhật, nếu không thì thử lại.
    CAS (Compare And Swap) là một thao tác nguyên tử (Atomic Operation) gồm 3 bước:
    Compare – So sánh giá trị hiện tại với giá trị mong đợi.
    Swap – Nếu giống, cập nhật giá trị mới.
    Nếu không giống, không cập nhật và thử lại (retry).
    
    Toàn bộ quá trình này diễn ra như một thao tác duy nhất, không bị thread khác chen vào.

#### 7.15 CAS (Compare And Swap)là gì?
    So sánh giá trị hiện tại với giá trị mong đợi.
    Nếu giống → cập nhật.
    Nếu khác → retry.
#### 7.16 Atomic có luôn tốt hơn synchronized không?
    Không.
    Atomic phù hợp với các phép toán đơn giản như:
    increment
    decrement
    compareAndSet
    Nếu logic phức tạp hoặc liên quan nhiều biến thì vẫn cần Lock hoặc synchronized.
#### 7.17 Immutable Object là gì?
    Object không thể thay đổi sau khi được tạo.
    Ví dụ:
        String
        LocalDate
        BigInteger
#### 7.18 Tại sao Immutable thread-safe?
    Vì không có thread nào có thể thay đổi trạng thái của object.
    Không cần Synchronization.
#### 7.19 Làm sao tạo Immutable Class?
    - class là final.
    - Các field là private final.
    - Không có setter.
    - Khởi tạo đầy đủ qua constructor.
    - Trả về bản sao (defensive copy) nếu chứa object mutable.

