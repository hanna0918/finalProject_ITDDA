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

    
$('#participateBtn').click(function () {
    $('.matchingModal').css('display', 'none');
    $('#regForm').submit();
});

$('#closeBtn').click(function () {
    $('.matchingModal').css('display', 'none');
});

$('.matchingModalOverlay').click(function () {
    $('.matchingModal').css('display', 'none');
});