### Volatile
####  1.1 What is it?
    volatile là một keyword trong Java dùng để đảm bảo Visibility của một biến giữa các Thread.
    Khi một Thread cập nhật giá trị của biến volatile, các Thread khác sẽ nhìn thấy giá trị mới ngay lập tức.
    Lưu ý: volatile không đảm bảo Atomicity.
####  1.2 Why do we need it?
    Nếu không có volatile, mỗi Thread có thể đọc dữ liệu từ Working Memory (hoặc CPU Cache), dẫn đến việc vẫn nhìn thấy giá trị cũ.
    volatile giúp các Thread luôn đọc được giá trị mới nhất.
####  1.3 How does it work?
    volatile đảm bảo Visibility bằng cách thay đổi quy tắc đọc và ghi của Java Memory Model. Khi một thread ghi vào biến volatile, giá trị sẽ được đồng bộ ra Main Memory ngay. Khi thread khác đọc biến đó, nó sẽ đọc giá trị mới từ Main Memory thay vì sử dụng bản sao cũ trong Working Memory hoặc CPU Cache. JVM thực hiện điều này thông qua memory barriers, giúp đảm bảo các thread luôn nhìn thấy dữ liệu mới nhất. Tuy nhiên, volatile không khóa dữ liệu nên không đảm bảo Atomicity cho các thao tác như count++.
####  1.4. When do we use it?
    - Biến cờ (flag).
    - Biến trạng thái (running, shutdown, stop).
    - Chỉ có một Thread ghi, nhiều Thread đọc.
####  1.5. Advantages & Disadvantages
    Advantages
        - Đảm bảo Visibility.
        - Hiệu năng tốt hơn synchronized.
        - Dễ sử dụng.
    Disadvantages
        - Không đảm bảo Atomicity.
        - Không phù hợp với các phép toán như count++.
####  1.6. Common Interview Questions
    1.6.1 volatile là gì?
        - volatile là keyword trong Java dùng để đảm bảo Visibility. Khi một Thread cập nhật biến volatile, các Thread khác sẽ nhìn thấy giá trị mới ngay. Tuy nhiên, volatile không đảm bảo Atomicity nên không thể thay thế synchronized trong các thao tác cập nhật dữ liệu.

