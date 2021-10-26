// 섬머노트 API 선언
$('#summernote').summernote({
    placeholder: '매칭 정보를 입력해주세요',
    tabsize: 2,
    height: 600,
});

// 모달창 띄우는 메소드
//const mapBtnDoc = document.querySelector("#mapBtn");
//mapBtnDoc.addEventListener("click", hiddenMap);

$('#mapBtn').click(function () {
    $('.mapModalOverlay').css('display', 'block');
    $('.mapJoinModal').css('display', 'block');
});

$('.mapModalOverlay').click(function () {
    $('.mapJoinModal').css('display', 'none');
});

// 태그 배열 선언
 var tag = new Array();

// Text 이벤트리스너
const searchTextArea = document.querySelector("#searchText");
searchTextArea.addEventListener('keyup', keyupTest);

// 태그 배열에 값 넣기
function keyupTest(e){
    const keyCode = e.keyCode;
    var text="";
    if(tag.length<10){
        if(keyCode==32 || keyCode==13){
            text = searchTextArea.value;
            searchTextArea.value = "";
            tag.push(text);
            eraseAllTag();
            tagInValue();
            console.log(tag);
        }
    }
}

// 태그 지우는 이벤트리스너
const hiddenTagDiv0 = document.querySelector("#hiddenTag0");
const hiddenTagDiv1 = document.querySelector("#hiddenTag1");
const hiddenTagDiv2 = document.querySelector("#hiddenTag2");
const hiddenTagDiv3 = document.querySelector("#hiddenTag3");
const hiddenTagDiv4 = document.querySelector("#hiddenTag4");
const hiddenTagDiv5 = document.querySelector("#hiddenTag5");
const hiddenTagDiv6 = document.querySelector("#hiddenTag6");
const hiddenTagDiv7 = document.querySelector("#hiddenTag7");
const hiddenTagDiv8 = document.querySelector("#hiddenTag8");
const hiddenTagDiv9 = document.querySelector("#hiddenTag9");
hiddenTagDiv0.addEventListener("click", eraseTag);
hiddenTagDiv1.addEventListener("click", eraseTag);
hiddenTagDiv2.addEventListener("click", eraseTag);
hiddenTagDiv3.addEventListener("click", eraseTag);
hiddenTagDiv4.addEventListener("click", eraseTag);
hiddenTagDiv5.addEventListener("click", eraseTag);
hiddenTagDiv6.addEventListener("click", eraseTag);
hiddenTagDiv7.addEventListener("click", eraseTag);
hiddenTagDiv8.addEventListener("click", eraseTag);
hiddenTagDiv9.addEventListener("click", eraseTag);

// 배열 값 빼기
function eraseTag(){
    const indexNo = parseInt(this.id.slice(9));
    tag.splice(indexNo, 1);
    eraseAllTag();
    tagInValue();
    console.log(tag);
}


// 태그일괄 지우기
function eraseAllTag(){
    for(i=0;i<10;i++){
        document.querySelector(`#hiddenTag${i}`).style.display = "none";
    }
}

// 태그에 값 넣는 펑션 태그에 값이 있다는 가정하에
function tagInValue(){
    for(i=0;i<tag.length;i++){
        document.querySelector(`#hiddenTag${i}`).innerHTML = "#" + tag[i];
        document.querySelector(`#hiddenTag${i}`).style.display = "";
    }
}