### Visibility
####  1.1 What is it?
    - Visibility là khả năng một Thread nhìn thấy ngay những thay đổi dữ liệu do Thread khác thực hiện.
    - Nói đơn giản::
        - Nếu Thread A thay đổi giá trị của một biến, liệu Thread B có đọc được giá trị mới ngay hay vẫn thấy giá trị cũ?
    visibility là khả năng một thread nhìn thấy những thay đổi dữ liệu do thread khác thực hiện. Bản chất của vấn đề là mỗi thread có thể làm việc với bản sao dữ liệu trong CPU Cache hoặc Working Memory để tăng hiệu năng. Vì vậy, nếu dữ liệu chưa được đồng bộ về Main Memory hoặc thread khác chưa đọc lại từ Main Memory thì nó vẫn có thể nhìn thấy giá trị cũ. Java Memory Model cùng các cơ chế như volatile, synchronized và Lock được sử dụng để đảm bảo các thread nhìn thấy dữ liệu mới nhất.
####  1.2 Why do we need it?
    - Nếu không đảm bảo Visibility:
        - Thread này cập nhật dữ liệu.
        - Thread khác vẫn đọc dữ liệu cũ.
        - Chương trình có thể chạy sai hoặc không dừng như mong muốn.
####  1.3 How does it work?
    - Theo JMM:
        - Mỗi Thread có Working Memory riêng.
        - Dữ liệu dùng chung được lưu trong Main Memory.
        - Để đảm bảo Visibility, Java cung cấp các cơ chế như:
            - volatile
            - synchronized
            - Lock
####  1.4 When do we use it?
    - Visibility rất quan trọng khi:
        - Nhiều Thread cùng đọc/ghi một biến.
        - Biến điều khiển trạng thái (running, shutdown, stop...).
        - Ứng dụng Backend có nhiều Thread xử lý đồng thời.
####  1.5. Advantages & Disadvantages
    -Advantages:
        - Đảm bảo các Thread nhìn thấy dữ liệu mới nhất.
        - Tránh lỗi đọc dữ liệu cũ.
        - Giúp chương trình đa luồng hoạt động chính xác.
    - Disadvantages:
        - Đồng bộ dữ liệu có chi phí nhất định.
        -Chỉ đảm bảo nhìn thấy giá trị mới, không đảm bảo Atomicity.
####  1.6. Common Interview Questions
    1.6.1 volatile giải quyết vấn đề gì?
     - volatile đảm bảo Visibility và Ordering, nhưng không đảm bảo Atomicity.
    1.6.2 Visibility có đảm bảo Thread-safe không?
        - Không.
        - Visibility chỉ đảm bảo các Thread nhìn thấy dữ liệu mới nhất.
        - Nếu nhiều Thread cùng cập nhật dữ liệu, vẫn có thể xảy ra Race Condition.