//hàm đóng mở login và register
function openLoginAndRegister(){
    var loginAndRegister = document.getElementById("modal_access");
    loginAndRegister.style.display='flex';
}
function closeLoginAndRegister(){
    var loginAndRegister = document.getElementById("modal_access");
    loginAndRegister.style.display='none';
}
//chuyển sang trang login.jsp
function redirectToJSPPage(url) {
    window.location.href = url;
}

function redirectToJSPPageWithPara(url, attribute, value){
    urlPara = url + "?" + attribute + "=" + encodeURIComponent(value);
    window.location.href = urlPara;
}


function callServlet(url, attributeName, attributeValue, urlTo) {
    // Tạo một đối tượng XMLHttpRequest để gửi request
    var xhr = new XMLHttpRequest();
    
    // Thiết lập phương thức và url
    xhr.open("POST", url, true);
    
    // Thiết lập header để xác định kiểu dữ liệu của request
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    
    // Lắng nghe sự kiện khi request hoàn thành
    xhr.onload = function() {
        // Kiểm tra nếu request thành công
        if (xhr.status === 200) {
            // Xử lý dữ liệu nhận được nếu cần
            console.log(xhr.responseText);
        } else {
            // Xử lý lỗi nếu có
            console.error("Request failed with status:", xhr.status);
        }
    };
    
    // Tạo chuỗi dữ liệu để gửi đi, ở đây chúng ta sử dụng URL-encoded format
    var data = attributeName + "=" + encodeURIComponent(attributeValue);
    
    // Gửi request với dữ liệu đã tạo
    xhr.send(data);
    window.location.href = urlTo;
}

