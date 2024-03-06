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
