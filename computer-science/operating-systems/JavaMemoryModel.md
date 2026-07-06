### Java Memory Model
####  1.1 What is it?
    - JMM là bộ quy tắc giúp các Thread làm việc với bộ nhớ một cách an toàn và nhất quán.
####  1.2 Why do we need it?
    - Nếu không có JMM, khi nhiều Thread cùng chạy sẽ xảy ra các vấn đề như:
        - Thread này cập nhật dữ liệu nhưng Thread khác không nhìn thấy (Visibility).
        - Hai Thread cùng cập nhật một biến dẫn đến sai kết quả (Atomicity).
        - JVM hoặc CPU thay đổi thứ tự thực thi lệnh (Instruction Reordering).
    - JMM được tạo ra để:
        - Đảm bảo dữ liệu được chia sẻ đúng giữa các Thread.
        - Định nghĩa khi nào dữ liệu phải đồng bộ với Main Memory.
        - Cho phép JVM tối ưu hiệu năng nhưng vẫn đảm bảo tính đúng đắn của chương trình.
####  1.3 How does it work?
    - JMM chia bộ nhớ thành hai phần:
        - Main Memory: Lưu các biến dùng chung.
        - Working Memory: Mỗi Thread có một Working Memory riêng (không phải là Stack, mà là khái niệm trong JMM).
        Thread sẽ:
            - Đọc dữ liệu từ Main Memory.
            - Lưu vào Working Memory.
            - Thao tác trên bản sao đó.
            - Ghi ngược lại Main Memory khi cần.
####  1.4 JMM giải quyết những vấn đề gì?
    - JMM tập trung vào 3 vấn đề quan trọng.
        1. Visibility
        2. Atomicity
        3. Ordering
####  1.5 Khi nào JMM được áp dụng?
    - Bất cứ khi nào chương trình có:
        - Multithreading
        - Shared Variables
        - synchronized
        - volatile
        - Atomic Classes
        - Lock
        - Concurrent Collections
####  1.6 Advantages & Disadvantages
    Advantages:
        - Đảm bảo tính nhất quán giữa các Thread.
        - Hỗ trợ lập trình đa luồng an toàn.
        - ho phép JVM tối ưu hiệu năng mà vẫn đảm bảo đúng logic.
    Disadvantages:
        - Khá khó hiểu.
        - Dễ phát sinh lỗi nếu không nắm rõ Visibility, Atomicity và Ordering.
        - Cần sử dụng đúng các công cụ như volatile, synchronized, Lock, Atomic.
####  1.7 Các từ khóa quan trọng trong JMM
    - Main Memory: Bộ nhớ dùng chung giữa các Thread
    - Working Memory: Bộ nhớ làm việc riêng của từng Thread
    - Visibility: Thread khác có nhìn thấy dữ liệu mới không
    - Atomicity: Một thao tác có được thực hiện trọn vẹn hay không
    - Ordering: hứ tự thực thi lệnh có bị thay đổi không
    - Happens-Before: Quy tắc đảm bảo thứ tự và khả năng nhìn thấy dữ liệu giữa các thao tác
####  1.8 Common Interview Questions
    1.8.1. JMM có phải là Heap không?
    - Không.
    - Heap là vùng nhớ chứa object.
    - JMM là đặc tả quy định cách Thread tương tác với bộ nhớ.
    1.8.2. Working Memory là gì?
    - Là vùng nhớ logic mà mỗi Thread sử dụng để lưu bản sao của các biến được đọc từ Main Memory.
    1.8.3 JMM có quản lý Stack không?
    - Không trực tiếp.
    - Stack là bộ nhớ riêng của mỗi Thread.
    - JMM chủ yếu quan tâm đến dữ liệu dùng chung giữa các Thread.
####  1.9 Real-world Example
    Ví dụ trong Spring Boot có một biến running dùng để điều khiển một thread nền.
    Thread A cập nhật:
    running = false;
    Nhưng Thread B vẫn có thể tiếp tục đọc giá trị true vì nó đang sử dụng bản sao dữ liệu cũ.
    Khi khai báo:
    private volatile boolean running;
    thì Thread B sẽ nhìn thấy giá trị mới ngay. Đây là một ví dụ về cách JMM giải quyết vấn đề Visibility
