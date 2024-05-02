# 52100697 - Phan Thị Thùy Linh

# Giới thiệu đề tài:

Để hoàn thành bài báo cáo giữa kì, em chọn thiết kế một ứng dụng bán mỹ phẩm và xây dựng các chức năng theo yêu cầu đề ra thông qua việc kết hợp Templete Engine khá phổ biến đó là Thymeleaf và Spring Boot để tạo nên ứng dụng.

# Tổng quan về Thymeleaf và Spring Boot:

**Thymeleaf:**
Thymeleaf là một công cụ xử lý template phía máy chủ được viết bằng Java. Nó có thể được sử dụng cho cả môi trường web và non-web, với khả năng xử lý HTML, XML, JavaScript, CSS và văn bản thuần túy. Mục tiêu chính của Thymeleaf là cung cấp các template tự nhiên, đồng nhất, đơn giản (nature templates) và dễ dàng bảo trì.
<space>**Spring Boot:**<space>
Spring Boot là một framework Java giúp đơn giản hóa việc phát triển các ứng dụng web Spring. Nó cung cấp một loạt các tính năng tự động hóa, bao gồm cấu hình tự động, khởi động nhúng và tích hợp với các thư viện phổ biến.

Sự kết hợp giữa Thymeleaf và Spring Boot tạo ra một giải pháp mạnh mẽ và linh hoạt cho việc phát triển các ứng dụng web Java giúp:

-   Tăng tốc độ phát triển: Thymeleaf và Spring Boot đều cung cấp các tính năng tự động hóa giúp giảm thiểu thời gian và công sức cần thiết để phát triển ứng dụng.
-   Cải thiện khả năng bảo trì: Thymeleaf và Spring Boot đều có cấu trúc đơn giản và dễ hiểu, giúp việc bảo trì ứng dụng trở nên dễ dàng hơn.
-   Tăng hiệu suất: Thymeleaf và Spring Boot đều được tối ưu hóa để mang lại hiệu suất cao, giúp tăng tốc độ tải trang web.

## Annotation trong Spring Boot và ứng dụng trong đề tài:

Annotation là một tính năng mạnh mẽ trong Java cho phép cung cấp thông tin bổ sung và metadata cho mã nguồn. Trong Spring Boot, annotation được sử dụng rộng rãi để:

-   Cấu hình ứng dụng: Annotation giúp định nghĩa các cấu hình cho ứng dụng Spring Boot, bao gồm cấu hình bean, cấu hình web, cấu hình database, v.v.
-   Quản lý bean: Annotation giúp tạo và quản lý các bean trong Spring Boot, bao gồm các bean dịch vụ, bean repository, v.v.
-   Kích hoạt các tính năng: Annotation giúp kích hoạt các tính năng tự động hóa của Spring Boot, bao gồm auto-configuration, auto-wiring, v.v.

### Các annotation sử dụng trong đề tài:

@RestController: Annotation đặc biệt để tạo RESTful web service controller.
Kết hợp:

-   @Controller: Xử lý request HTTP.
-   @ResponseBody: Trả về dữ liệu dưới dạng JSON (hoặc định dạng khác).

@RequestMapping:

-   Ánh xạ URL đến phương thức xử lý trong controller.
-   Hỗ trợ các phương thức HTTP (GET, POST, PUT, DELETE).
-   Có thể áp dụng ở cấp độ class và method.

@Autowired:

-   Tự động kết nối các bean trong Spring Boot.
-   Giảm thiểu mã boilerplate.
-   Tăng khả năng bảo trì và test.

@Service:

-   Đánh dấu class là một service.
-   Dùng cho các class logic nghiệp vụ.

@Repository:

-   Đánh dấu class là một repository.
-   Dùng cho các class truy cập dữ liệu.

@Configuration:

-   Đánh dấu class cấu hình.
-   Định nghĩa các bean cho ứng dụng.
-   Sử dụng cho class chứa logic khởi tạo.

@Bean:

-   Đánh dấu method trong class cấu hình.
-   Tạo và trả về một bean.
-   Spring Boot quản lý bean trong suốt vòng đời.
-   Cho phép thực hiện logic khởi tạo và dependency injection.

@PostMapping, @GetMapping, @PutMapping, @DeleteMapping:

-   Tương ứng với các phương thức HTTP POST, GET, PUT, DELETE.

# Các công nghệ khác sử dụng trong ứng dụng:

## MySQL:

MySQL là một hệ quản trị cơ sở dữ liệu quan hệ (RDBMS) mã nguồn mở phổ biến được sử dụng để lưu trữ và quản lý dữ liệu cho các ứng dụng web và nhiều loại ứng dụng khác.

## Spring Security:

Spring Security là một framework Java mã nguồn mở được sử dụng rộng rãi để cung cấp các tính năng bảo mật cho các ứng dụng web Spring. Nó hỗ trợ nhiều tính năng quan trọng như: authentication, Authorization, security threats,…

## Spring Data JPA:

Spring Data JPA là một framework Java nằm trong Spring Framework, cung cấp abstraction (sự trừu tượng hóa) để tương tác với các cơ sở dữ liệu quan hệ (RDBMS) sử dụng Java Persistence API (JPA). Nói cách khác, Spring Data JPA giúp bạn làm việc với cơ sở dữ liệu JPA dễ dàng hơn và tiết kiệm thời gian hơn.

# Thiết kế cơ sở dữ liệu:

## ERD:

![hinh1](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/27d1c094-57b9-4085-be11-cbb56a39acdd)

## ERD mức vật lý:

![hinh2](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/42d5007e-b95a-4fc4-9371-c21646b52307)

### Giải thích về ERD:

-   User là model chung cho cả admin và customer, mỗi customer sẽ có nhiều sản phẩm trong giỏ hàng. User có các thông tin cơ bản như id, name, emai, password.
-   Role là model phân quyền của user. Mỗi user có thể có nhiều role khác nhau.
-   Product là model chứa thông tin về các sản phẩm có trong cửa hàng gồm các thuộc tính như id, name, price, color, image. Mỗi sản phẩm thuộc về một brand và có thể thuộc về một hoặc nhiều giỏ hàng.
-   Brand chứa thông tin về thương hiệu của sản phẩm. Mỗi brand có thể có một hoặc nhiều sản phẩm.
-   Khi khách hàng thêm sản phẩm vào giỏ hàng, hệ thống sẽ lưu vào Cart giúp người dùng có thể xem lại giỏ hàng khi họ đăng nhập vào thống. Khi xác nhận đặt hàng, các item trong bảng sẽ bị xóa khỏi giỏ hàng.

# Cấu trúc thư mục trong project:

## Chi tiết các thư mục:

<img src="![hinh3](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/bedc692a-da74-4565-9888-0cd2159af31b)
" min-width="400px" max-width="400px" width="400px" align="right">

<p align="left"> 
Thư mục API: chứa các API tương tác với brand, giỏ hàng, sản phẩm,…

Thư mục config: chứa các cấu hình bảo mật cho ứng dụng.

Thư mục controller: chứa các controller điều hướng trang web.

Thư mục DTO: chứa các class được sử dụng để chuyển đổi dữ liệu từ Model (lớp biểu diễn dữ liệu) sang định dạng khác (thường là JSON) trước khi trả về cho client.

Thư mục model: Chứa các class để ánh xạ xuống các bảng trong cở dữ liệu.

Thư mục repository: Chứa các Interface tương tác với cơ sở dữ liệu.

Thư mục service: Chứa class thực hiện nhiệm vụ xử lý logic.

Thư mục resource/static: Chứa các folder css, fonts, js, images.

Thư mục resource/templates: Chứa các layout.

</p>

# Cấu hình để chạy project:

1. Tạo CSDL trong MySQL: Midterm

![hinh4](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/d91dae64-c342-499f-8eaf-565da0ab2796)

2. Import data đã cung cấp để có dữ liệu.
3. Sử dụng tài khoảng trong database để đăng nhập.
   <space>Username: admin1@gmail.com<space>
   <space>Password: 12345<space>

# API trong ứng dụng:

### Register - Đăng ký tài khoản:

Method: Post

Endpoint:`http://localhost:8081/api/auth/register`

Description: API cho phép người dùng đăng kí tài khoản.

![hinh5](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/dd5613e6-5308-4da4-984e-a669e0ec5e82)

### Log in - Đăng nhập

Method: Get

Endpoint: `http://localhost:8081/api/auth/login`

Description: API cho phép người dùng sử dụng tài khoản đã đăng kí để đăng nhập vào hệ thống.

![hinh6](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/3e1070a9-c616-4a11-b697-392b11581f8f)


### Get Brand

Method: Get

Endpoint: `http://localhost:8081/api/brands`

Description: API cho phép lấy ra các brand và sản phẩm của nó có trong cửa hàng.

![hinh7](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/2766b17a-1abf-40d4-97eb-0b0a6b991262)


### Create Brand

Method: Post

Endpoint: `http://localhost:8081/api/brands/insert`

Description: API cho phép tạo một brand mới.

![hinh8](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/81d01f06-7984-4a64-be4a-01d91163abae)


### Create Product

Method: Post

Endpoint:` http://localhost:8081/api/product/insert`

Description: API cho phép tạo sản phẩm mới tương ứng với brand.
![hinh9](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/202fa4e2-f6ed-44f5-bb51-bbe629a9e475)


### Get Product

Method: Get

Endpoint:`http://localhost:8081/api/product`

Description: API cho phép lấy ra tất cả các sản phẩm có trong cửa hàng.

![hinh10](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/7ee5662e-91c9-45a3-9128-0367b922b49b)


### Get Product By ID

Method: Get

Endpoint:`http://localhost:8081/api/product/1`

Description: API cho phép tìm kiếm sản phẩm bằng id.

![hinh11](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/bd8cc33d-481a-4817-8512-7f90ff984277)


### Delete Product

Method: Delete

Endpoint:`http://localhost:8081/api/product/7`

Description: API cho phép xóa sản phẩm bởi id.

![hinh12](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/98db95c7-4994-4e47-b18e-c394ba8c969e)


### Show Cart

Method:Get

Endpoint: `http://localhost:8081/api/cart`

Description: API cho phép xem các sản phẩm có trong giỏ hàng.

![hinh13](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/584b05d9-fed3-4e91-98d6-eb586f97f326)


### Add to Cart

Method: Post

Endpoint: `http://localhost:8081/api/cart/add/2 `

Description: API cho phép thêm sản phẩm vào giỏ hàng.

![hinh14](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/3b9ae52d-2c23-41b4-a6b8-6ad49d1a310e)


### Minus product in Cart

Method: Put

Endpoint: `http://localhost:8081/api/cart/minus/2 `

Description: API cho phép giảm số lượng sản phẩm đã thêm vào giỏ hàng.

![hinh15](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/cb02cf49-a98c-4921-b055-b6a6b1227e09)


### Delele item Cart

Method: Delete

Endpoint: `http://localhost:8081/api/cart/remove/2 `

Description: API cho phép xóa sản phẩm có trong giỏ hàng.

![hinh16](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/7f2eb870-20db-42b7-ac20-840d1d5c4b0c)

### CheckOut

Method: Get

Endpoint: `http://localhost:8081/api/cart/checkout `

Description: API cho phép xem hóa đơn đã thanh toán.

![hinh17](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/e45e14dc-cdd0-4d75-9087-ca52be834ef3)

# Demo

![hinh18](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/bd020029-686b-4ebd-8a35-a18b4a6e005c)
Giao diện Login

![hinh19](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/eb300759-5483-4648-934e-9e37200e0170)
Giao diện đăng ký.

![hinh20](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/1380bbc5-fc39-4803-b959-64ae1aed3d94)
![hinh21](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/b3216723-d118-4046-ad8c-67a9945c87c8)
![hinh22](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/0eeda58f-552e-4bf7-8d95-56dbb02074fa)
Giao diện chính của hệ thống.

![hinh23](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/889ce3d8-ea69-4458-9215-e54b8636fac6)
Giao diện giỏ hàng.

![hinh24](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/1cd290ab-cc42-405f-bdd7-a57716282b82)
Giao diện khi hoàn tất thanh toán.

![hinh25](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/b8be524e-0731-419e-9ef1-028ea9546fe8)
Giao diện lọc sản phẩm theo brand.

![hinh26](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/073782b5-0f60-4976-aaec-c7f920a0b5e2)
![hinh27](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/fe467012-b45e-4b5d-a2e8-cc24ae1c1d44)
Giao diện tìm kiếm sản phẩm

# Giải thích về Security

![hinh28](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/d4ee14b8-cfbf-456b-9026-eecb2279fdce)
Định nghĩa một phương thức bean có tên filterChain nhận một đối tượng HttpSecurity làm đầu vào và trả về một đối tượng SecurityFilterChain.

Cấu hình bảo mật web bằng cách sử dụng HttpSecurity:

-   `http.csrf(csrf -> csrf.disable())`: Vô hiệu hóa bảo vệ Cross-Site Request Forgery (CSRF).
-   `authorizeHttpRequests((authorize) -> { ... })`: Cấu hình các quy tắc cho phép đối với các mẫu URL khác nhau:
    `.requestMatchers("/checkout").authenticated()`: Yêu cầu xác thực cho mẫu URL "/checkout".
    `.anyRequest().permitAll()`: Cho phép truy cập vào tất cả các URL khác mà không cần xác thực.
-   `formLogin(form -> form. ... )`: Cấu hình đăng nhập dựa trên biểu mẫu:
    `.loginPage("/login")`: Đặt URL trang đăng nhập thành "/login".
    `.loginProcessingUrl("/login")`: Chỉ định URL mà trình duyệt sẽ POST dữ liệu biểu mẫu đăng nhập.
    `.defaultSuccessUrl("/")`: Chuyển hướng người dùng đến thư mục gốc ("/") sau khi đăng nhập thành công.
    `.permitAll()`: Cho phép mọi người truy cập vào trang đăng nhập.
-   `logout(logout -> logout. ... )`: Cấu hình chức năng đăng xuất:
    `.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))`: Đặt mẫu URL để bắt đầu đăng xuất ("/logout").
    `.permitAll()`: Cho phép mọi người truy cập vào URL đăng xuất.

Phương thức configureGlobal:

-   Một phương thức @Autowired nhận một đối tượng AuthenticationManagerBuilder làm đầu vào.
-   Cấu hình xác thực người dùng bằng cách sử dụng AuthenticationManagerBuilder:
    `.userDetailsService(userDetailsService)`: Cho Spring Security biết sử dụng userDetailsService được tiêm để truy xuất chi tiết người dùng để xác thực.
    `.passwordEncoder(passwordEncoder())`: Đặt PasswordEncoder được sử dụng để băm mật khẩu (được tạo trong phương thức bean passwordEncoder).

# Unit Test

## Test Brand

![hinh29](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/aad7565f-c1e7-43b8-b0ce-5cea56a81157)
| STT | Test case | Description |Input| Expect output | Result|
|---|---|---|---|---|---|
| 1 | testGetBrandByID_NotFound()| Kiểm tra trường hợp không tìm thấy thương hiệu |Id| Không có thông tin nhãn hàng vì ID không tồn tại | Pass|
|2|testGetAllBrands()|Hiển thị tất cả các nhãn hàng có trong cửa hàng|void|Lấy tất cả thông tin nhãn hàng có trong CSDL|Pass|
|3 |testGetBrandById() | Lấy thông tin nhãn hàng bằng ID |id| Lấy được thông tin của nhãn hàng.| Pass|
|4|testAddBrand_Success()|Thêm nhãn hàng mới thành công|Brand|Thêm nhãn hàng thành công|Pass|
|5|testAddBrand_Failure()|Thêm nhãn hàng bị lỗi|Brand (error)|Thêm dữ liệu brand thất bại vì lỗi dữ liệu|Pass|

## Test Cart

![hinh30](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/09baab0c-e566-4a0c-909f-ad777f4fc106)
| STT | Test case | Description |Input| Expect output | Result|
|---|---|---|---|---|---|
| 1 | testRemoveProductFromCart()| Xóa sản phẩm trong giỏ hàng|Id user, Id product| Các sản phẩm trong giỏ hàng bị xóa | Pass|
|2|testGetCount()|Lấy số lượng mặt hàng trong giỏ hàng.|Id product|Tổng tiền thanh toán|Pass|
|3 |testClearCart() | Xóa tất cả sản phẩm trong giỏ hàng|Id user và Id product| Các sản phẩm trong giỏ hàng xóa thành công| Pass|
|4|testAddProductToCart()|Thêm sản phẩm vào giỏ hàng|Id user và Id product|Thêm sản phẩm vào giỏ hàng thành công|Pass|
|5|testGetAmount()|Lấy tổng số tiền của tất cả các mặt hàng có trong gio hàng|Id product|Tổng tiền|Pass|

## Test Product

![hinh31](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/6d736172-3878-4d8f-a4d5-96911c87d319)
| STT | Test case | Description |Input| Expect output | Result|
|---|---|---|---|---|---|
| 1 | testGetProductByIdNotFound()| Kiểm tra trường hợp không tìm thấy sản phẩm theo id|Id | Không tìm thấy dữ liệu sản phẩm| Pass|
|2|testAddProduct()|Thêm sản phẩm vào cửa hàng|Product|T1 sản phẩm mới được thêm|Pass|
|3 |testGetAllProducts()| Lấy tất cả thông tin của tất cả sản phẩm|void| Danh sách thông tin| Pass|
|4| testGetProductById()|Lấy thông tin sản phẩm bằng id|Id|Thông tin sản phẩm cần tìm|Pass|

## Test User

![hinh32](https://github.com/phanthuylinh22/Midterm_52100697/assets/146012513/cdc5d58d-555a-4f5b-91f3-0ad8b4052e41)
| STT | Test case | Description |Input| Expect output | Result|
|---|---|---|---|---|---|
| 1 | testSaveUser()| Lưu 1 người dùng mới vào hệ thống|User | New user| Pass|
|2|testFindAllUser()|Tìm tất cả người dùng trong hệ thống|String username|Thông tin người dùng|Pass|
|3 |testFindByEmail()| LTìm thông tin người dùng bằng email|String email| Thông tin người dùng| Pass|
