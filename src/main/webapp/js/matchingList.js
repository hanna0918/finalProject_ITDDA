/*
    데이터베이스에서 매칭이름, 시작일을 받아와 각각 달력API events에 들어갈 title, start, end에 대입
    JSON 데이터 불러와서 달력 events에 넣어주기!!!!!!!!!!!!
    
*/
// 달력 날짜 입력되는 메서드
let searchingDate = "";
function dateInsert(dataTest){
    const selectedDate = document.querySelector("#selectedDateDiv");
    selectedDate.innerText = dataTest;
    searchingDate = dataTest;
    selectedDate.style.display = "block";
}

// 달력 api
document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
            events: [
                { // this object will be "parsed" into an Event Object
                    title: '러닝', // a property!
                    start: '2021-10-24', // a property!
                    end: '2021-10-24' // a property! ** see important note below about 'end' **
                },
                { // this object will be "parsed" into an Event Object
                    title: '맛집탐방', // a property!
                    start: '2021-10-24', // a property!
                    end: '2021-10-24' // a property! ** see important note below about 'end' **
                },
                { // this object will be "parsed" into an Event Object
                    title: '혼밥이 싫어', // a property!
                    start: '2021-10-24', // a property!
                    end: '2021-10-24' // a property! ** see important note below about 'end' **
                },
                { // this object will be "parsed" into an Event Object
                    title: '같이 뛰싧분', // a property!
                    start: '2021-10-24', // a property!
                    end: '2021-10-24' // a property! ** see important note below about 'end' **
                },
                { // this object will be "parsed" into an Event Object
                    title: '같이 먹어요', // a property!
                    start: '2021-10-24', // a property!
                    end: '2021-10-24' // a property! ** see important note below about 'end' **
                },
                { // this object will be "parsed" into an Event Object
                    title: '클라이밍 해봅시다', // a property!
                    start: '2021-10-24', // a property!
                    end: '2021-10-24' // a property! ** see important note below about 'end' **
                },
                { // this object will be "parsed" into an Event Object
                    title: '그냥 놀자', // a property!
                    start: '2021-10-24', // a property!
                    end: '2021-10-24' // a property! ** see important note below about 'end' **
                },
                { // this object will be "parsed" into an Event Object
                    title: 'event8', // a property!
                    start: '2021-10-24', // a property!
                    end: '2021-10-24' // a property! ** see important note below about 'end' **
                },
            ],
            aspectRatio: 3,
            height: 650,
            dayMaxEventRows: false, // for all non-TimeGrid views
            navLinks: true,
            navLinkDayClick: function(date) {
                calendarId.style.visibility = "hidden";
                var d = date;
                var completeDate = new Date(d.getTime() - (d.getTimezoneOffset() * 60000)).toISOString().slice(0, 10);
                dateInsert(completeDate);
                sendWithAjax();
            },
            eventClick: function(info) {
                var eventObj = info.event;
          
                if (eventObj.title) {
                    alert(`Title:${eventObj.title}\n이걸 누르면 db에서 정보를 얻어와 mapping으로 보내 해당 게시물로 보내기`);
                    info.jsEvent.preventDefault(); // (이거 지우면 안됨)prevents browser from following link in current tab.
                }
            }
    });
    calendar.render();
    calendar.setOption('locale', 'ko');
    calendar.setOption('height', 700);
});

// 달력 버튼 이벤트
const calendarBtnId = document.querySelector("#calendarBtn");
const calendarId = document.querySelector("#calendar");
const selectedDateDiv = document.querySelector("#selectedDateDiv");
function calendarShow(){
    if(calendarId.style.visibility != "hidden"){
        calendarId.style.visibility = "hidden";
    }else if(calendarId.style.visibility == "hidden"){
        calendarId.style.visibility = "";
    }
}
calendarBtnId.addEventListener("click", calendarShow);

// 달력 날짜 눌러 생긴 DIV 눌렀을때 이벤트
selectedDateDiv.addEventListener("click", function(){
	searchingDate = "";
    selectedDateDiv.style.display = "none";
    sendWithAjax();
});

// 리스트 뷰 글씨크기
let frequency = "allGroup"; ////// 이 값을 활용해서 db 데이터 값 조건 설정
const viewByGroupLi1 = document.querySelector("#viewByGroup>li:nth-child(1)");
const viewByGroupLi3 = document.querySelector("#viewByGroup>li:nth-child(3)");
const viewByGroupLi5 = document.querySelector("#viewByGroup>li:nth-child(5)");
const viewByGroupLiAll = document.querySelectorAll("#viewByGroup>li:nth-child(2n+1)");
function groupFontChange(){
    groupFontReset();
    this.style.fontSize = "1.1em";
    this.style.fontWeight = "bold";
    frequency = this.id;
    console.log(frequency);
    sendWithAjax();
}
function groupFontReset(){
    for(i=0; i<viewByGroupLiAll.length; i++){
        viewByGroupLiAll[i].style.fontWeight="100";
        viewByGroupLiAll[i].style.fontSize="1em";
    }
}
viewByGroupLi1.addEventListener("click", groupFontChange);
viewByGroupLi3.addEventListener("click", groupFontChange);
viewByGroupLi5.addEventListener("click", groupFontChange);

let selectedViewByTime = "recentTime"; ////// 이 값을 활용해서 db 데이터 값 조건 설정
const viewByTimeLi1 = document.querySelector("#viewByTime>li:nth-child(1)");
const viewByTimeLi3 = document.querySelector("#viewByTime>li:nth-child(3)");
const viewByTimeLiAll = document.querySelectorAll("#viewByTime>li:nth-child(2n+1)");
function groupTimeFontChange(){
    groupTimeFontReset();
    this.style.fontSize = "1.1em";
    this.style.fontWeight = "bold";
    selectedViewByTime = this.id;
    console.log(selectedViewByTime);
    sendWithAjax();
}
function groupTimeFontReset(){
    for(i=0; i<viewByTimeLiAll.length; i++){
        viewByTimeLiAll[i].style.fontWeight="100";
        viewByTimeLiAll[i].style.fontSize="1em";
    }
}
viewByTimeLi1.addEventListener("click", groupTimeFontChange);
viewByTimeLi3.addEventListener("click", groupTimeFontChange);

/*------------------------------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------------------------------*/

// 배열  선언
var tag = new Array();

// Text 이벤트리스너
const searchTextArea = document.querySelector("#searchText");
searchTextArea.addEventListener('keyup', keyupTest);

// 태그 배열에 값 넣기
function keyupTest(e){
    const keyCode = e.keyCode;
    var text="";
    if(tag.length<5){
        if(keyCode==32 || keyCode==13){
            text = searchTextArea.value;
            searchTextArea.value = "";
            tag.push(text.trim());
            eraseAllTag();
        	tagInValue();
        	sendWithAjax();
        }
    }
}
var data = "";
var nowPage;
function sendWithAjax(){
	console.log(tag);
	data = ""
	if(tag != null && tag != "") {
		data += "tag="+tag;
	}
	if(tag != null && tag != ""){
		data +="&selectedDate=" + searchingDate;
	}else {
		data +="selectedDate=" + searchingDate;
	}
	if(nowPage != ""){
		data += "&nowPage=" + nowPage;
	}
	data += "&frequency=" + frequency;
	data += "&listup=" + selectedViewByTime;
	console.log(data);
	var data = data;
	var rUrl = "/itda/matchingListTagSearch";
	console.log("ajax 들어옴");
	$.ajax({
		type : "POST",
		url: rUrl,
		data: data,
		success: function(result){
			var listResult = $(result.vo);
			var pageResult = $(result.pVo);
			var newList = "";
			var newPageNum = "";
			listResult.each(function(idx, vo){
				if(vo == null) {
					newList += '<h1>데이터가 없습니다</h1>';
				}
				var splitTag = vo.b_select.split('/');
				newList += `<a href="/itda/matchingView?b_id=${vo.b_id}"><div class="matchingBox" id="matchingBox">`;
				newList += `<div class="photo">`;
				newList += `<img src="/itda/img/quoka.png" alt="매칭1" width="100%"/>`;
				newList += `<div class="endSoon">${vo.b_frequency}</div>`;
				newList += `</div>`;
				newList += `<div class="hashTag">`;
				for(i=0;i<splitTag.length;i++){
					newList += `#${splitTag[i]} `;
				}
				newList += `</div>`;
				newList += `<div class="where">${vo.b_where}</div>`;
				newList += `<div class="writer">${vo.m_userid }</div>`;
				newList += `<div class="matchingDate">${vo.b_matchingdate}</div>`;
				newList += `<div class="matchingStatus">${vo.b_nowpart} / ${vo.b_maxpart}</div>`;
				newList += `</div></a>`;
			});
			pageResult.each(function(idx, pVo){
				if(pVo.nowPage > 1){
					newPageNum += "<li class='page-item'><a href='javascript:matchingPagingPrev()' class='page-link'>Prev</a></li>"
				}
				if(pVo.nowPage == 1){
					newPageNum += "<li class='page-item'><a href='' class='page-link'>Prev</a></li>"
				}
				for(i=pVo.startPage;i<=pVo.startPage + pVo.onePageNumCount-1;i++){
					if(i <= pVo.totalPage){
						if(i == pVo.nowPage){
							newPageNum += "<li class='page-item' id='activePage'>";
						}
						if(i != pVo.nowPage){
							newPageNum += "<li class='page-item'>";
						}
						newPageNum += "<a href='javascript:matchingPaging("+i+")'>"+i+"</a></li>";
					}
				}
				if(pVo.nowPage < pVo.totalPage){
					newPageNum += "<li class='page-item'><a href='javascript:matchingPagingNext()'>Next</a></li>";
				}
				
			});
			console.log(newList);
			$("#matchingSection").html(newList);
			$("#matchingPagingUl").html(newPageNum);
		}, error: function(){
			console.log("넌 역시 됨 한번 시도해봐 제발로....~!~!~~!!~ ")
		}
	});
}


// 태그 지우는 이벤트리스너
const hiddenTagDiv0 = document.querySelector("#hiddenTag0");
const hiddenTagDiv1 = document.querySelector("#hiddenTag1");
const hiddenTagDiv2 = document.querySelector("#hiddenTag2");
const hiddenTagDiv3 = document.querySelector("#hiddenTag3");
const hiddenTagDiv4 = document.querySelector("#hiddenTag4");
hiddenTagDiv0.addEventListener("click", eraseTag);
hiddenTagDiv1.addEventListener("click", eraseTag);
hiddenTagDiv2.addEventListener("click", eraseTag);
hiddenTagDiv3.addEventListener("click", eraseTag);
hiddenTagDiv4.addEventListener("click", eraseTag);

// 배열 값 빼기
function eraseTag(){
    const indexNo = parseInt(this.id.slice(9));
    tag.splice(indexNo, 1);
    document.querySelector(`#hiddenTag${indexNo}`).style.display = "none";
    eraseAllTag();
    tagInValue();
    sendWithAjax();
}

// 태그일괄 지우기
function eraseAllTag(){
    for(i=0;i<5;i++){
        document.querySelector(`#hiddenTag${i}`).style.display = "none";
        document.querySelector(`#hiddenTag${i}`).innerHTML = "";
    }
}

// 태그에 값 넣는 펑션 태그에 값이 있다는 가정하에
function tagInValue(){
    for(i=0;i<tag.length;i++){
        document.querySelector(`#hiddenTag${i}`).innerHTML = "#" + tag[i];
        document.querySelector(`#hiddenTag${i}`).style.display = "block";
    }
}

// 페이징
function matchingPaging(pageNumber) {
	this.nowPage = pageNumber;
	sendWithAjax(pageNumber);	
}
// 페이징 Next
function matchingPagingNext() {
	nowPage += 1;
	sendWithAjax();
}
// 페이징 Prev
function matchingPagingPrev() {
	nowPage -= 1;
	sendWithAjax();
}