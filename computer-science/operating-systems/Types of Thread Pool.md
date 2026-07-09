### Types of Thread Pool in Java
#### 1. Fixed Thread Pool

##### 1.1 What is this?
    - A Fixed Thread Pool tạo ra một số luồng worker threads cố định.
    - Số lượng thread không bao giờ vượt quá size đã được config
##### 1.2  How does it work?
    - Thread sẽ tái sử dụng lại thay vì tạo mới
##### 1.3  When do we use it?
    - Sử dụng khi
        - Khối lượng công việc ổn định
        - Số lượng task đồng thời có thể đoán trước được
        - Xây dựng rest apis
        - Xử lý các yêu cầu kinh doanh
##### 1.4 Advantages & Disadvantages?
    Advantages:
        - Sử dụng tài nguyên ổn định
        - Dễ dàng config
        - Tái sử dụng thread
        - Ngăn chặn quá nhiwwuf thread
    Disadvantages:
        - Task chờ nếu tất cả thread đều bận
        - Những queue lớn có thể tăng bộ nhớ
#### 2. Cached Thread Pool
##### 2.1 What is it?
    - Cached Thread Pool tạo một thread mới
    khi cần và tái dụng lại thread nhàn rỗi
##### 2.2 How does it work?
    - Những thread nhàn rỗi sẽ được xóa sau 60s
##### 2.3 When do we use it?
    - sử dụng khi:
        - Nhiều nhiệm vụ có thời gian thực hiện ngắn
        - Số lượng task thay đổi thường xuyên
        - Các ứng dụng đòi hỏi nhiều thao tác I/O
##### 2.4 Advantages & Disadvantages
    Advantages:
        - Độ linh hoạt cao
        - Tái sử dụng thread nhàn rỗi
        - Không có task nào đang chờ trong hàng đợi
    Disadvantages:
        - Có thể tạo một số lượng thread rất lớn
        - Sử dụng bộ nhớ cao khi tải nặng
        -  Không nên sử dụng  cho các hệ thống lưu lượng truy cập cao
         mà không có sự kiểm soát cẩn thận
#### 3.Single Thread Executor
##### 3.1 What is it?
    - Chỉ tạo 1 worker thread
##### 3.2 How does it work?
    - Các task vụ thực thi theo thứ tự đã gửi
##### 3.3 When do we use it?
    - Sử dụng khi:
        - Các yêu cầu phải được thực hiện tuần tự
        - Trật tự rất quan trọng
        - Tránh sự phức tạp trong đồng bộ hóa
##### 3.4 Advantages & Disadvantages
    Advantages:
        - Đơn giản
        - Duy trì thứ tự công việc
        - Không có tình trạng race condions (tranh chấp task)
        giữa các tác vụ đã gửi
    Disadvantages:
        - thông lượng thấp
        - Một tác vụ nhiều giờ sẽ làm chậm các tác vụ tiếp theo
#### 4.Scheduled Thread Pool
##### 4.1 What is it?
    - Thực thi các task sau khoảng thời gian trì hoãn
    hoặc theo các khoảng thời gian cố định
##### 4.2 When do we use it?
    - Khi chạy scheduled jobs
    - Gửi báo cáo 
    - Làm mới cache
    - Khám sức khỏe định kỳ
##### 4.3 Advantages & Disadvantages
    Advantages:
        -  Lập lịch trình tích hợp sẵn
        -  Linh hoạt
        -   Hỗ trợ nhiều thread worker
    Disadvantages
        - Không phù hợp cho việc xử lý hàng loạt
        đòi hỏi nhiều tài nguyên CPU
        - Cần thiết lập cẩn thận tránh công việc chồng chéo


    



    