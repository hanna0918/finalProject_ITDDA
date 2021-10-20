const bannerDoc = document.querySelector("#matchingDetailBanner");
window.addEventListener("scroll", bannerTop);
window.addEventListener("resize", bannerLeft);
function bannerTop(){
    const bannerTopPx = window.pageYOffset;
    setTimeout(function(){
        bannerDoc.style.top = bannerTopPx + 50 + "px";
    }, 120);
}
function bannerLeft(){
    const bannerWidth = window.innerWidth;
    console.log(bannerWidth);
    bannerDoc.style.left = bannerWidth -300 + "px";
}
bannerTop();
bannerLeft();

/* ----------------------------------------------------------------- */
$('#bannerBtn').click(function () {
    $('.matchingModal').css('display', 'block');
});

    
$('#participateBtn').one("click", function () {
    $(".joinModalContent").append("<label style='color: red; font-size: 0.8em'>로그인 후 참가버튼을 눌러주세요</label>");
});

$('#closeBtn').click(function () {
    $('.matchingModal').css('display', 'none');
});

$('.matchingModalOverlay').click(function () {
    $('.matchingModal').css('display', 'none');
});